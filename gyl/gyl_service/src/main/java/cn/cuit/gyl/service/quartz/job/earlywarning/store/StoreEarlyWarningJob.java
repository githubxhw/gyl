package cn.cuit.gyl.service.quartz.job.earlywarning.store;

import cn.cuit.gyl.dao.business.IEarlyWarning_StoreDao;
import cn.cuit.gyl.dao.database.IMessageDao;
import cn.cuit.gyl.dao.database.IProductDao;
import cn.cuit.gyl.dao.database.IStoreDao;
import cn.cuit.gyl.dao.database.IUserDao;
import cn.cuit.gyl.dao.privilege.IPermissionDao;
import cn.cuit.gyl.dao.privilege.IRoleDao;
import cn.cuit.gyl.domain.business.EarlyWarning_Store;
import cn.cuit.gyl.domain.database.Message;
import cn.cuit.gyl.domain.database.Product;
import cn.cuit.gyl.domain.database.UserInfo;
import cn.cuit.gyl.domain.others.Store_Product;
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
 * 该任务作用说明：
 * 仓库预警的任务类，按规定的corn表达式周期执行。
 * 遍历仓库预警表，根据信息验证出
 * 1、存货过期的到达天数
 * 2、是否存货数量超过上限数量
 * 3、是否存货数量低于下限数量
 * 验证完成后将需要预警的消息告知相关人员。
 */
public class StoreEarlyWarningJob implements Job {



    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            //System.out.println("任务开始执行...");
            //获取MyWebSocket对象，用于发消息
            MyWebSocket myWebSocket = (MyWebSocket)SpringUtils.getBean("myWebSocket");
            //获取dao，用于数据增删改查
            IEarlyWarning_StoreDao iEarlyWarning_storeDao = (IEarlyWarning_StoreDao)SpringUtils.getBean("iEarlyWarning_StoreDao");
            IStoreDao iStoreDao = (IStoreDao)SpringUtils.getBean("iStoreDao");
            IProductDao iProductDao = (IProductDao)SpringUtils.getBean("iProductDao");
            IMessageDao iMessageDao = (IMessageDao)SpringUtils.getBean("iMessageDao");
            IPermissionDao iPermissionDao = (IPermissionDao)SpringUtils.getBean("iPermissionDao");
            IRoleDao iRoleDao = (IRoleDao)SpringUtils.getBean("iRoleDao");
            IUserDao iUserDao = (IUserDao)SpringUtils.getBean("iUserDao");
            //HttpSession session = (HttpSession)SpringUtils.getBean(HttpSession.class);//获取当前正在会话的session

            //查询所有需要的预警的信息，即status为1
            List<EarlyWarning_Store> earlyWarning_stores = iEarlyWarning_storeDao.findAllWhereStatusIsTrue();
            if(earlyWarning_stores!=null){
                Iterator<EarlyWarning_Store> iterator = earlyWarning_stores.iterator();
                ObjectMapper mapper = new ObjectMapper();
                while (iterator.hasNext()){
                    //System.out.println("-------------------------");
                    EarlyWarning_Store earlyWarning_store = iterator.next();
                    Integer storeId = earlyWarning_store.getStoreId();//仓库id
                    String productNum = earlyWarning_store.getProductNum();//存货编码
                    Integer checkExpDays = earlyWarning_store.getCheckExp();//检查过期时间的提前天数（整数）
                    //System.out.println(checkExpDays);
                    Long upperLimit = earlyWarning_store.getUpperLimit();//上限数量
                    Long lowerLimit = earlyWarning_store.getLowerLimit();//下限数量

                    Store_Product store_product = iStoreDao.findByStoreIdAndpNum(storeId, productNum);
                    StringBuffer buffer = new StringBuffer("在ID为"+storeId+"的仓库中，编码为"+productNum+"的存货预警消息：\n");//用于返回消息
                    int count = 0;//如果count<0，说明有消息要存储与发送
                    //1、检查存货过期的到达天数
                    if(checkExpDays != null){
                        Date today = new Date();
                        //System.out.println("today:"+today);
                        Product product = iProductDao.findByPnum(productNum);
                        Date exp = product.getExp();
                        //System.out.println("exp:"+exp);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(exp);
                        calendar.add(Calendar.DATE, -checkExpDays);
                        Date earlyWarningTime = calendar.getTime();
                        //System.out.println("earlyWarningTime:"+earlyWarningTime);
                        boolean before = today.before(earlyWarningTime);//判断今天是否到了预警的最近日期
                        //System.out.println(before);
                        if(before == false){//需要添加预警消息
                            count--;
                            if(today.before(exp)){//未过期
                                String timeDifference = TimeUtils.getTimeDifference(today,exp);
                                buffer.append("\t距离存货的失效日期还有"+timeDifference+"的时间。\n");
                            }else {//过期
                                String timeDifference = TimeUtils.getTimeDifference(exp,today);
                                buffer.append("\t超过存货失效日期已有"+timeDifference+"的时间。\n");
                            }
                        }else {//不用添加
                            //...
                        }
                    }
                    //2、是否存货数量超过上限数量
                    if(upperLimit < store_product.getStockNumber()){
                        count--;
                        buffer.append("\t存货的数量为"+store_product.getStockNumber()+"，已经超过上限数量"+upperLimit+"。\n");
                    }
                    //3、是否存货数量低于下限数量
                    if(lowerLimit > store_product.getStockNumber()){
                        count--;
                        buffer.append("\t存货的数量为"+store_product.getStockNumber()+"，已经低于下限数量"+lowerLimit+"。\n");
                    }
                    buffer.append("以上是预警消息，请做好相应的工作！\n");

                    //存储消息，并发消息到客户端
                    if(count < 0){//有消息要存储与发送
                        HashSet<UserInfo> allUserInfosHashSet = new HashSet<>();//需要从写方法
                        //说明：这里有权限3个，分别为UI_EWS_STORE仓库预警、UI_EWS_XSCK销售发货预警、UI_EWS_CGRK采购入库预警
                        Integer id = iPermissionDao.findIdByPermissionName("UI_EWS_STORE");//查询所有拥有【仓库预警权限】的角色
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //System.out.println("任务执行完成...");
    }
}
