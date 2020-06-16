package cn.cuit.gyl.service.quartz.job.earlywarning.cgrk;

import cn.cuit.gyl.dao.business.IEarlyWarning_CgrkDao;
import cn.cuit.gyl.dao.business.cgdddao;
import cn.cuit.gyl.dao.business.cgddzhidao;
import cn.cuit.gyl.dao.database.IMessageDao;
import cn.cuit.gyl.dao.database.IUserDao;
import cn.cuit.gyl.dao.privilege.IPermissionDao;
import cn.cuit.gyl.dao.privilege.IRoleDao;
import cn.cuit.gyl.domain.business.Cgddzhib;
import cn.cuit.gyl.domain.business.EarlyWarning_Cgrk;
import cn.cuit.gyl.domain.database.Message;
import cn.cuit.gyl.domain.database.UserInfo;
import cn.cuit.gyl.domain.privilege.Role;
import cn.cuit.gyl.service.socket.MyWebSocket;
import cn.cuit.gyl.utils.SpringUtils;
import cn.cuit.gyl.utils.TimeUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.web.socket.TextMessage;

import java.util.*;

public class CgRkEarlyWarningJob implements Job {
    /**
     * 返回对应的距离 天、时、分
     * @param beginDate
     * @param endDate
     * @return
     * @throws Exception
     */
    private String getTimeDifference(Date beginDate, Date endDate) throws Exception{
        if (beginDate.after(endDate)){
            return null;
        }
        long d = 1000*60*60*24;
        long h = d/24;
        long m = h/60;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDate);
        long beginDateMillis = calendar.getTimeInMillis();
        calendar.setTime(endDate);
        long endDateMillis = calendar.getTimeInMillis();
        long away = endDateMillis-beginDateMillis;
        long day = away/d;
        long hours = (away%d)/h;
        long minutes = ((away%d)%h)/m;
        return day+"天"+hours+"时"+minutes+"分";
    }
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            //System.out.println("任务开始执行...");
            //获取MyWebSocket对象，用于发消息
            MyWebSocket myWebSocket = (MyWebSocket) SpringUtils.getBean("myWebSocket");
            //获取dao，用于数据增删改查
            IEarlyWarning_CgrkDao iEarlyWarning_cgrkDao = (IEarlyWarning_CgrkDao) SpringUtils.getBean("IEarlyWarning_CgrkDao");
            cgddzhidao iCgDao = (cgddzhidao) SpringUtils.getBean("cgddzhidao");
            cgdddao iCgDao2 = (cgdddao) SpringUtils.getBean("cgdddao");
            IMessageDao iMessageDao = (IMessageDao) SpringUtils.getBean("iMessageDao");
            IPermissionDao iPermissionDao = (IPermissionDao) SpringUtils.getBean("iPermissionDao");
            IRoleDao iRoleDao = (IRoleDao) SpringUtils.getBean("iRoleDao");
            IUserDao iUserDao = (IUserDao) SpringUtils.getBean("iUserDao");
            //HttpSession session = (HttpSession)SpringUtils.getBean(HttpSession.class);//获取当前正在会话的session

            //查询所有需要的预警的信息，即status为1
            List<EarlyWarning_Cgrk> earlyWarning_stores = iEarlyWarning_cgrkDao.findAllWhereStatusIsTrue();
            if(earlyWarning_stores!=null){
                Iterator<EarlyWarning_Cgrk> iterator = earlyWarning_stores.iterator();
                while (iterator.hasNext()){
                    //System.out.println("-------------------------");
                    EarlyWarning_Cgrk earlyWarning_cgrk = iterator.next();
                    String Djh = earlyWarning_cgrk.getDjh();//单据号
                    Long Hh = earlyWarning_cgrk.getHh();//行号
                    String productNum = earlyWarning_cgrk.getProductNum();//存货编码
                    Integer checkExpDays = earlyWarning_cgrk.getCheckDays();//检查过期时间的提前天数（整数）
                    //System.out.println(checkExpDays);
                    StringBuffer buffer = new StringBuffer("单据号为"+Djh+"且行号为"+Hh+"的采购单中，编码为"+productNum+"的商品入库预警消息：\n");//用于返回消息
                    int count = 0;//如果count<0，说明有消息要存储与发送
                    //1、检查存货过期的到达天数
                    if(checkExpDays != null){
                        Date today = new Date();
                        Cgddzhib byZIdAndHh = iCgDao.findByZIdAndHh(iCgDao2.findByDjh(Djh).getCgddzhubid(), Hh);
                        Date exp = byZIdAndHh.getYqshrq();
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(exp);
                        calendar.add(Calendar.DATE, -checkExpDays);
                        Date earlyWarningTime = calendar.getTime();
                        //System.out.println("earlyWarningTime:"+earlyWarningTime);
                        //System.out.println(before);
                        if(today.after(earlyWarningTime)){
                            if(today.before(exp)){//预警的临界日期 <= 今天 <= 要求出库日期yqfhrq
                                String timeDifference = TimeUtils.getTimeDifference(today, exp);
                                buffer.append("\t距离要求入库日期还有"+timeDifference+"的时间。\n");
                                count--;
                            }else {//今天 > 要求出库日期yqfhrq
                                Integer invalidDays = earlyWarning_cgrk.getInvalidDays();
                                if(invalidDays == null){//过了要求发货日期，不需要继续预警情况
                                    EarlyWarning_Cgrk byId = iEarlyWarning_cgrkDao.findById(earlyWarning_cgrk.getId());
                                    byId.setStatus(0);
                                    iEarlyWarning_cgrkDao.updateById(byId);//设置status为0，不预警状态
                                }else {//过了要求发货日期，需要继续预警情况:并且需要连续预警invalidDays天
                                    calendar.setTime(exp);//证明过了要求发货日期后，就不需要预警了。
                                    calendar.add(Calendar.DATE, +invalidDays);
                                    if(today.before(calendar.getTime())){//要求发货日期  < 今天 < 要求发货日期+invalidDays，即需要继续预警
                                        String timeDifference = TimeUtils.getTimeDifference(exp,today);
                                        buffer.append("\t要求入库日期已过"+timeDifference+"的时间。\n");
                                        count--;
                                    }else {//今天 > 要求发货日期+invalidDays，即不继续预警
                                        EarlyWarning_Cgrk byId = iEarlyWarning_cgrkDao.findById(earlyWarning_cgrk.getId());
                                        byId.setStatus(0);
                                        iEarlyWarning_cgrkDao.updateById(byId);//设置status为0，不预警状态
                                    }
                                }
                            }
                        }
                    }
                    buffer.append("以上是预警消息，请做好相应的工作！\n");

                    //存储消息，并发消息到客户端
                    if(count < 0){//有消息要存储与发送
                        HashSet<UserInfo> allUserInfosHashSet = new HashSet<>();//需要从写方法
                        //说明：这里有权限3个，分别为UI_EWS_STORE仓库预警、UI_EWS_XSFH销售发货预警、UI_EWS_CGRK采购入库预警
                        Integer id = iPermissionDao.findIdByPermissionName("UI_EWS_CGRK");//查询所有拥有【仓库预警权限】的角色
                        List<Role> roles = iRoleDao.findByPermissionId(id);
                        if(roles!=null){
                            for (Role role:roles) {
                                //查询出拥有该role角色的所有用户users
                                List<UserInfo> userInfos = iUserDao.findByRoleId(role.getId());
                                allUserInfosHashSet.addAll(userInfos);
                            }
                        }
                        if(allUserInfosHashSet.size() > 0){
                            Iterator<UserInfo> iterator1 = allUserInfosHashSet.iterator();
                            while (iterator1.hasNext()){
                                UserInfo userInfo = iterator1.next();
                                Message message = new Message();
                                message.setType(2);
                                message.setSender("system");
                                message.setReceiver(userInfo.getUsername());
                                message.setMsg(buffer.toString());
                                message.setStatus(0);
                                message.setSendTime(new Date());
                                iMessageDao.saveNotHasMidAndReturnId(message);//保存信息并获取message的id到地址对象中
                                ObjectMapper mapper = new ObjectMapper();
                                //System.out.println("mid:"+message.getMid());
                                //System.out.println("username:"+userInfo.getUsername());
                                String msg = mapper.writeValueAsString(message);
                                //System.out.println(msg);
                                myWebSocket.sendMessage(userInfo.getUsername(),new TextMessage(msg));//发消息
                            }
                        }
                    }else {
                        //...
                    }
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
