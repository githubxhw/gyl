package cn.cuit.gyl.service.database.impl;

import cn.cuit.gyl.dao.database.IMessageDao;
import cn.cuit.gyl.domain.database.Message;
import cn.cuit.gyl.service.database.IMessageService;

import cn.cuit.gyl.service.socket.MyWebSocket;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service("messageServiceImpl")
public class MessageServiceImpl implements IMessageService {

    @Autowired
    @Qualifier("myWebSocket")
    private MyWebSocket myWebSocket = null;

    @Autowired
    @Qualifier("iMessageDao")
    private IMessageDao iMessageDao = null;

    @Override
    public List<Message> getMessagesByName(String username) throws Exception {
        List<Message> messages = iMessageDao.findByName(username);
        return messages;
    }

    @Override
    public void updateMessageStatusByMid(Long mid, Integer status, HttpSession session) throws Exception {
        //1，先修改数据库中的消息状态1
        iMessageDao.updateStatusByMid(mid,status);
        //2, 修改session中当前message的状态
        List<Message> messages = (List)session.getAttribute("messages");
        if(messages!=null){
            for (Message message:messages) {
                if(message.getMid() == mid){
                    /*System.out.println(message);*/
                    message.setStatus(1);
                    break;
                }
            }
        }
        session.setAttribute("messages", messages);
    }

    @Override
    public void deleteMsgByMid(Long mid, HttpSession session) throws Exception {
        //根据mid删除消息
        iMessageDao.deleteByMid(mid);
        //删除session中值
        List<Message> messages = (List)session.getAttribute("messages");
        Iterator<Message> iterator = messages.iterator();
        while (iterator.hasNext()){
            Message next = iterator.next();
            if(next.getMid().equals(mid)){
                iterator.remove();
                break;
            }
        }
        session.setAttribute("messages", messages);
    }

    @Override
    public void saveMsgToSessionByMid(Long mid, HttpSession session) throws Exception{
        Message message = iMessageDao.findByMid(mid);
        //System.out.println(message);
        List<Message> messages = (List<Message>)session.getAttribute("messages");
        messages.add(message);
        session.setAttribute("messages", messages);
    }

    @Override
    //当时用于测试用的，不再使用了
    public void sendMsg(HttpSession session) throws Exception {
        Long maxMid = iMessageDao.findMaxMid();
        Message message = new Message();
        if(maxMid != null){
            message.setMid(maxMid+1);
        }else {
            message.setMid(1l);
        }
        message.setMsg("xxxxxxxxxxxxxxxxxxx");
        message.setReceiver("root");
        message.setSender("system");
        message.setType(2);
        message.setSendTime(new Date());
        message.setStatus(0);
        iMessageDao.save(message);
        List<Message> messages = (List<Message>)session.getAttribute("messages");
        messages.add(message);
        session.setAttribute("messages", messages);
        TextMessage textMessage = new TextMessage(new ObjectMapper().writeValueAsString(message));
        myWebSocket.sendMessage("root", textMessage);
    }

}
