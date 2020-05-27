package cn.cuit.gyl.init;

import cn.cuit.gyl.domain.database.Message;
import cn.cuit.gyl.service.database.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * 登录成功后处理方法
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    @Qualifier("messageServiceImpl")
    private IMessageService service = null;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("登录成功后处理方法执行......");
        HttpSession session = request.getSession();
        User user = (User)authentication.getPrincipal();
        try {
            getMessagesForUser(session,user.getUsername());
        } catch (Exception e) {
            System.out.println("在getMessagesForUser方法中出现错误......");
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

    /**
     * 根据用户名称获取用户的所有信息
     * @param session 当前会话
     * @param username 用户名称
     * @throws Exception
     */
    private void getMessagesForUser(HttpSession session,String username) throws Exception{
        List<Message> messages = service.getMessagesByName(username);
        if (messages!=null){
            /*for (Message message:messages){
                System.out.println(message);
            }*/
            session.setAttribute("messages",messages);
        }
    }
}
