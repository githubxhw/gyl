package cn.cuit.gyl.controller.privilege;

import cn.cuit.gyl.domain.privilege.Permission;
import cn.cuit.gyl.domain.privilege.Role;
import cn.cuit.gyl.service.privilege.IPrivilegeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/privilege")
public class PrivilegeController {

    @Autowired
    @Qualifier("privilegeServiceImpl")
    private IPrivilegeService service = null;

    //分页查询所有的角色信息
    @RequestMapping("/findAllRoles")
    public String findAllRoles(HttpServletRequest request, @RequestParam(name = "pageNum",required = true,defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize",required = true,defaultValue = "6") Integer pageSize) throws Exception{
        List<Role> roles = service.findAllRoles(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(roles);
        request.setAttribute("pageInfo", pageInfo);
        return "forward:/pages/privilege/role-list.jsp";
    }

    //根据名称查询角色信息
    @RequestMapping("/findRoleByName")
    public String findRoleByName(String role_name,HttpServletRequest request, @RequestParam(name = "pageNum",required = true,defaultValue = "1") Integer pageNum,@RequestParam(name = "pageSize",required = true,defaultValue = "6") Integer pageSize) throws Exception{
        List<Role> roles = service.findRoleByName(role_name);
        PageInfo pageInfo = new PageInfo(roles);
        request.setAttribute("pageInfo", pageInfo);
        return "forward:/pages/privilege/role-list.jsp";
    }

    //根据角色id查询所以的权限并返回
    @RequestMapping("/findPrivilegesByRoleId")
    public String findPrivilegesByRoleId(HttpServletRequest request,Integer roleId) throws Exception{
        Role role = service.findRoleByRoleId(roleId);
        /*System.out.println(role);*/
        List<Permission> permissions = service.findPrivilegesByRoleId(roleId);
        /*for (Permission permission:permissions) {
            System.out.println(permission);
        }*/
        request.setAttribute("role",role);
        request.setAttribute("permissions",permissions);
        return "forward:/pages/privilege/configure_permissions.jsp";
    }

    //根据ids修改该角色的权限：注意，需要处理ids里面一个-1的值？
    @RequestMapping("/configPermission")
    public String configPermission(Integer[] ids,Integer roleId) throws Exception{
        service.configPermission(ids,roleId);
        return "forward:/privilege/findPrivilegesByRoleId?roleId="+roleId;
    }

    //分页查询所有的权限s
    @RequestMapping("/findAllPrivileges")
    public String findAllPrivileges(HttpServletRequest request, @RequestParam(name = "pageNum",required = true,defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize",required = true,defaultValue = "10") Integer pageSize) throws Exception{
        List<Permission> permissions = service.findAllPrivileges(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(permissions);
        request.setAttribute("pageInfo", pageInfo);
        return "forward:/pages/privilege/permission-list.jsp";
    }

    //根据权限id查询所有拥有的角色s
    @RequestMapping("/findRolesByPermissionId")
    public String findRolesByPermissionId(HttpServletRequest request,Integer permissionId) throws Exception{
        List<Role> roles = service.findRolesByPermissionId(permissionId);
        Permission permission = service.findPermissionById(permissionId);
        /*for (Role role:roles) {
            System.out.println(role);
        }
        System.out.println(permission);*/
        request.setAttribute("roles", roles);
        request.setAttribute("permission", permission);
        return "forward:/pages/privilege/permission_roles.jsp";
    }
}
