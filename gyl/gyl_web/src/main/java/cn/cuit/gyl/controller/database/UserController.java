package cn.cuit.gyl.controller.database;


import cn.cuit.gyl.domain.database.UserInfo;
import cn.cuit.gyl.service.database.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private IUserService service = null;

    @RequestMapping("/findAll")
    public String finAll(HttpServletRequest request, @RequestParam(name = "pageNum",required = true,defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize",required = true,defaultValue = "6") Integer pageSize) throws Exception{
        List<UserInfo> users = service.findAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(users);
        request.setAttribute("pageInfo", pageInfo);
        return "forward:/pages/basedata/user-list.jsp";
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo) throws Exception{
        //System.out.println(userInfo);
        service.save(userInfo);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/deleteByIds")
    public String deleteByIds(@RequestParam(name = "ids") Integer[] ids) throws Exception{
        service.deleteByIds(ids);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/deleteById")
    public String deleteById(@RequestParam(name = "id") Integer id) throws Exception{
        service.deleteById(id);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/findById")
    public String findById(HttpServletRequest request,Integer id) throws Exception{
        UserInfo userInfo = service.findById(id);
        request.setAttribute("user", userInfo);
        return "forward:/pages/basedata/user-update.jsp";
    }

    @RequestMapping("/updateById")
    public String updateById(UserInfo userInfo) throws Exception{
        service.updateById(userInfo);
        return "redirect:/user/findById?id="+userInfo.getId();
    }

}
