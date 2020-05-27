package cn.cuit.gyl.controller.database;

import cn.cuit.gyl.service.database.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    public HttpSession session = null;

    @Autowired
    @Qualifier("messageServiceImpl")
    private IMessageService service = null;

    //根据id更新消息是状态为已读
    @RequestMapping("/updateMessageStatusByMid")
    @ResponseBody
    public void updateMessageStatusByMid(Long mid,Integer status) throws Exception{
        /*System.out.println(mid);
        System.out.println(status);*/
        service.updateMessageStatusByMid(mid,status,session);
        return;
    }

    //根据id删除消息
    @RequestMapping("/deleteMsgByMid")
    @ResponseBody
    public void deleteMsgByMid(Long mid) throws Exception{
        /*System.out.println(mid);*/
        service.deleteMsgByMid(mid,session);
        return;
    }

    //根据mid把对应的消息存取到session中
    @RequestMapping("/saveMsgToSessionByMid")
    @ResponseBody
    public void saveMsgToSessionByMid(Long mid) throws Exception{
        //System.out.println("正在存取msg到session里面...");
        service.saveMsgToSessionByMid(mid,session);
        return;
    }

    //测试发送消息到客户端
    @RequestMapping("/sendMsg")
    @ResponseBody
    public void sendMsg() throws Exception{
        service.sendMsg(session);
        return;
    }
}
