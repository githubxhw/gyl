package cn.cuit.gyl.service.quartz.job.earlywarning.xsck;

import cn.cuit.gyl.dao.business.IEarlyWarning_XsckDao;
import cn.cuit.gyl.dao.database.IMessageDao;
import cn.cuit.gyl.dao.database.IUserDao;
import cn.cuit.gyl.dao.privilege.IPermissionDao;
import cn.cuit.gyl.dao.privilege.IRoleDao;
import cn.cuit.gyl.domain.business.EarlyWarning_Xsck;
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

/**
 * 该类的说明：
 * 销售出库预警任务类，按规定的corn表达式周期执行。
 * 1、遍历所有的预警消息：过滤条件=>预警状态=0。
 * 2、是否到了该预警的天数。
 * 3、在预警过期后，是否继续预警，以及在继续预警的条件下在预警的天数之内预警。
 * 4、添加消息、发送消息给相关人员：拥有【销售出库预警权限】=> UI_EWS_XSCK 的角色。
 */
public class XsckEarlyWarningJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            //System.out.println("开始执行任务XsckEarlyWarningJob...");
            //发消息的工具
            MyWebSocket myWebSocket = (MyWebSocket) SpringUtils.getBean("myWebSocket");
            //销售出库预警的dao
            IEarlyWarning_XsckDao iEarlyWarning_xsckDao = (IEarlyWarning_XsckDao)SpringUtils.getBean("iEarlyWarning_XsckDao");
            IMessageDao iMessageDao = (IMessageDao)SpringUtils.getBean("iMessageDao");
            IPermissionDao iPermissionDao = (IPermissionDao)SpringUtils.getBean("iPermissionDao");
            IRoleDao iRoleDao = (IRoleDao)SpringUtils.getBean("iRoleDao");
            IUserDao iUserDao = (IUserDao)SpringUtils.getBean("iUserDao");

            //查询所有的status为1的销售出库预警消息
            List<EarlyWarning_Xsck> earlyWarning_xscks = iEarlyWarning_xsckDao.findAllAndStatusNotClosed();
            if(earlyWarning_xscks!=null){
                Iterator<EarlyWarning_Xsck> iterator = earlyWarning_xscks.iterator();
                while (iterator.hasNext()){
                    EarlyWarning_Xsck earlyWarning_xsck = iterator.next();

                    Date today = new Date();//今天
                    Integer checkDays = earlyWarning_xsck.getCheckDays();//提前预警的天数
                    Date yqfhrq = earlyWarning_xsck.getYqfhrq();//要求发货日期

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(yqfhrq);
                    calendar.add(Calendar.DATE,-checkDays);
                    Date earlyWarningTime = calendar.getTime();//判断是否预警的临界条件
                    StringBuffer resBuffer = new StringBuffer("在ID:"+earlyWarning_xsck.getId()+"、销售订单号:"+earlyWarning_xsck.getDdh()
                            +"、行号:"+earlyWarning_xsck.getHh()+"、商品编码："+earlyWarning_xsck.getProductNum()+"、商品名称："+earlyWarning_xsck.getProductName()+"的出库预警消息：\n");
                    int count = 0;//标记是否需要=>添加消息、发送消息
                    if(today.after(earlyWarningTime)){
                        if(today.before(yqfhrq)){//预警的临界日期 <= 今天 <= 要求出库日期yqfhrq
                            String timeDifference = TimeUtils.getTimeDifference(today, yqfhrq);
                            resBuffer.append("\t距离要求发货日期还有"+timeDifference+"的时间。\n");
                            count--;
                        }else {//今天 > 要求出库日期yqfhrq
                            Integer invalidDays = earlyWarning_xsck.getInvalidDays();
                            if(invalidDays == null){//过了要求发货日期，不需要继续预警情况
                                iEarlyWarning_xsckDao.setStatusToZeroById(earlyWarning_xsck.getId());//设置status为0，不预警状态
                            }else {//过了要求发货日期，需要继续预警情况:并且需要连续预警invalidDays天
                                calendar.setTime(yqfhrq);//证明过了要求发货日期后，就不需要预警了。
                                calendar.add(Calendar.DATE, +invalidDays);
                                if(today.before(calendar.getTime())){//要求发货日期  < 今天 < 要求发货日期+invalidDays，即需要继续预警
                                    String timeDifference = TimeUtils.getTimeDifference(yqfhrq,today);
                                    resBuffer.append("\t要求发货日期已过"+timeDifference+"的时间。\n");
                                    count--;
                                }else {//今天 > 要求发货日期+invalidDays，即不继续预警
                                    iEarlyWarning_xsckDao.setStatusToZeroById(earlyWarning_xsck.getId());//设置status为0，不预警状态
                                }
                            }
                        }
                    }
                    resBuffer.append("以上是预警消息，请做好相应的工作！\n");
                    if(count < 0){//表明需要=>添加消息、发送消息
                        //存储消息，并发消息到客户端
                        HashSet<UserInfo> allUserInfosHashSet = new HashSet<>();//需要从写方法
                        //说明：这里有权限3个，分别为UI_EWS_STORE仓库预警、UI_EWS_XSCK销售发货预警、UI_EWS_CGRK采购入库预警
                        Integer id = iPermissionDao.findIdByPermissionName("UI_EWS_XSCK");//查询所有拥有【销售出库预警权限】的角色
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
                                message.setMsg(resBuffer.toString());
                                message.setStatus(0);
                                message.setSendTime(new Date());
                                iMessageDao.saveNotHasMidAndReturnId(message);//保存信息并获取message的id到地址对象中
                                ObjectMapper mapper = new ObjectMapper();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}






















