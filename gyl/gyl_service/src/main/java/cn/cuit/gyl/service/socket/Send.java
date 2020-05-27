package cn.cuit.gyl.service.socket;

import org.springframework.web.socket.WebSocketMessage;

public interface Send {

    //发送消息接口
    public void sendMessage(String username, WebSocketMessage<?> message, Object...args) throws Exception;

}
