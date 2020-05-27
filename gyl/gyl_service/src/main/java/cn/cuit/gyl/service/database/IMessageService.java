package cn.cuit.gyl.service.database;

import cn.cuit.gyl.domain.database.Message;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IMessageService {

    //根据用户名称查询信息s
    List<Message> getMessagesByName(String username) throws Exception;

    //根据信息的id修改信息的状态为1 （已读），并修改session中的值
    void updateMessageStatusByMid(Long mid, Integer status, HttpSession session) throws Exception;

    //根据id删除消息，并删除session中的值
    void deleteMsgByMid(Long mid, HttpSession session) throws Exception;

    //测试发送消息到客户端
    void sendMsg(HttpSession session) throws Exception;

    //根据mid把对应的消息存取到session
    void saveMsgToSessionByMid(Long mid, HttpSession session) throws Exception;
}
