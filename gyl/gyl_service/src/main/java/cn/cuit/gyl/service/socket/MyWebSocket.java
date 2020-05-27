package cn.cuit.gyl.service.socket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.util.*;

//与客户端的会话服务器
@Component("myWebSocket")
public class MyWebSocket implements WebSocketHandler,Send {

    // key -> session id, value -> username用户名；
    public static Map<String,String> idAndUsernameMap = new HashMap();

    // key -> session id, value -> session用户名；
    public static Map<String,WebSocketSession> idAndSessionMap = new HashMap();

    //连接建立后处理事件
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //System.out.println("已经与客户端连接建立...");
        idAndUsernameMap.put(session.getId(), session.getPrincipal().getName());
        idAndSessionMap.put(session.getId(), session);
    }

    /**
     * 发送消息的方法
     * @param username 用户名称（唯一）
     * @param message 要发送的消息
     * @param args 其他参数
     * @throws Exception
     */
    public void sendMessage(String username,WebSocketMessage<?> message,Object...args) throws Exception{
        List<String> sessionIds = new ArrayList<>();//根据username找到所有的session的id
        if(idAndUsernameMap.size() > 0){
            Set<Map.Entry<String, String>> entries = idAndUsernameMap.entrySet();
            for (Map.Entry<String,String> entry:entries) {
                String userName = entry.getValue();
                if(username.equals(userName)){
                    sessionIds.add(entry.getKey());
                }
            }
        }
        if(sessionIds.size() > 0){
            for (String id:sessionIds) {
                WebSocketSession session = idAndSessionMap.get(id);//获取session
                if(session!=null){
                    session.sendMessage(message);//发消息
                }
            }
        }
    }

    //接收消息
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        //System.out.println("接收到客户端的消息...");
        /*System.out.println(session.getId());
        Principal principal = session.getPrincipal();
        String name = principal.getName();
        System.out.println(name);
        //System.out.println(principal);
        System.out.println("接收到客户端的消息...");
        String params = (String) message.getPayload();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm"));
        Vo vo1 = mapper.readValue(params, Vo.class);
        System.out.println(vo1);
        Vo vo = new Vo();
        vo.setA(1);
        vo.setB("123");
        vo.setC(new Date());
        String string = mapper.writeValueAsString(vo);
        System.out.println(string);*/
    }


    //连接关闭
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        //System.out.println("关闭连接处理中...");
        if(idAndUsernameMap.containsKey(session.getId())){
            //System.out.println("idAndUsernameMap存在该sessionId");
            idAndUsernameMap.remove(session.getId());
            //System.out.println("已经idAndUsernameMap删除");
        }
        if (idAndSessionMap.containsKey(session.getId())) {
            //System.out.println("idAndSessionMap存在该sessionId");
            idAndSessionMap.remove(session.getId());
            //System.out.println("已经在idAndSessionMap删除");
        }
    }

    //抛出异常时处理
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        //System.out.println("抛出异常时处理中...");
    }


    @Override
    public boolean supportsPartialMessages() {
        /*System.out.println("supportsPartialMessages");*/
        return false;
    }
}
