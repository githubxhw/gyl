package cn.cuit.gyl.controller.database;

import cn.cuit.gyl.domain.database.Role;
import cn.cuit.gyl.service.database.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    @Qualifier("RoleServiceImpl")
    private RoleService service = null;

    //查询所有的角色
    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request, @RequestParam(name = "pageNum",required = true,defaultValue = "1") Integer pageNum,@RequestParam(name = "pageSize",required = true,defaultValue = "6") Integer pageSize) throws Exception{
        List<Role> roles = service.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(roles);
        request.setAttribute("pageInfo", pageInfo);
        return "forward:/pages/basedata/role-list.jsp";
    }

    //添加角色信息
    @RequestMapping("/save")
    public String save(@RequestParam(name = "role_name") String role_name,@RequestParam(name = "role_desc") String role_desc) throws Exception{
        Role newRole = new Role();
        newRole.setRole_name(role_name);
        newRole.setRole_desc(role_desc);
        service.save(newRole);
        return "redirect:/role/findAll";
    }

    //通过多个id删除角色信息
    @RequestMapping("/deleteByIds")
    public String deleteByIds(@RequestParam(name = "ids") Integer[] ids) throws Exception{
        service.deleteByIds(ids);
        return "redirect:/role/findAll";
    }

    //通过一个id删除角色信息
    @RequestMapping("/deleteById")
    public String deleteById(@RequestParam(name = "id") Integer id) throws Exception{
        service.deleteById(id);
        return "redirect:/role/findAll";
    }

    //通过id查询一个角色并显示其信息到页面
    @RequestMapping("/findById")
    public String findById(@RequestParam(name = "id") Integer id, HttpServletRequest request) throws Exception{
        Role role = service.findById(id);
        request.setAttribute("role", role);
        return "forward:/pages/basedata/role-update.jsp";
    }

    //更新一个角色信息
    @RequestMapping("/updateById")
    public String updateById(Role role) throws Exception{
        service.updateById(role);
        return "redirect:/role/findById?id="+role.getId();
    }

    //模糊查询角色
    @RequestMapping("/findByFuzzyName")
    public String findByFuzzyName(@RequestParam(name = "fuzzyName") String fuzzyName){
        return "";
    }

}