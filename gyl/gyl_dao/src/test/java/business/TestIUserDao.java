package business;

import cn.cuit.gyl.dao.database.IUserDao;
import cn.cuit.gyl.domain.database.UserInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestIUserDao {

    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
        IUserDao dao = (IUserDao) context.getBean("iUserDao");
        UserInfo admin = dao.findByName("root");
        System.out.println(admin);
    }
}
