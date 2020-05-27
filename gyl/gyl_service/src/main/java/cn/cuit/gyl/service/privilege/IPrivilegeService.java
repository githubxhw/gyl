package cn.cuit.gyl.service.privilege;

import cn.cuit.gyl.domain.privilege.Permission;
import cn.cuit.gyl.domain.privilege.Role;

import java.util.List;

public interface IPrivilegeService {

    //分页查询所有的角色信息
    List<Role> findAllRoles(Integer pageNum, Integer pageSize) throws Exception;

    //根据名称查询角色信息
    List<Role> findRoleByName(String role_name) throws Exception;

    //根据角色id查询出所有的权限
    List<Permission> findPrivilegesByRoleId(Integer roleId) throws Exception;

    //根据角色id查询该角色
    Role findRoleByRoleId(Integer roleId) throws Exception;

    //根据ids配置角色id=roleId的权限
    void configPermission(Integer[] ids, Integer roleId) throws Exception;

    //分页查询所有的权限s
    List<Permission> findAllPrivileges(Integer pageNum, Integer pageSize) throws Exception;

    //根据权限id查询所有拥有的角色s
    List<Role> findRolesByPermissionId(Integer permissionId) throws Exception;

    //根据权限id查询权限
    Permission findPermissionById(Integer permissionId) throws Exception;
}
