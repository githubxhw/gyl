import cn.cuit.gyl.domain.database.UserInfo;
import cn.cuit.gyl.service.database.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestIUserService {

    /*public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-service.xml");
        IUserService service = (IUserService) context.getBean("userServiceImpl");
        List<UserInfo> users = service.findAll();
        for (UserInfo userInfo:users) {
            System.out.println(userInfo);
        }
    }*/
}
