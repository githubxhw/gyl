package cn.cuit.gyl.service.privilege.impl;

import cn.cuit.gyl.dao.privilege.IPermissionDao;
import cn.cuit.gyl.dao.privilege.IRoleDao;
import cn.cuit.gyl.domain.privilege.Permission;
import cn.cuit.gyl.domain.privilege.Role;
import cn.cuit.gyl.service.privilege.IPrivilegeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("privilegeServiceImpl")
public class PrivilegeServiceImpl implements IPrivilegeService {

    @Autowired
    @Qualifier("iRoleDao")
    private IRoleDao iRoleDao = null;

    @Autowired
    @Qualifier("iPermissionDao")
    private IPermissionDao iPermissionDao = null;

    @Override
    public List<Role> findAllRoles(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Role> roles = iRoleDao.findAll();
        return roles;
    }

    @Override
    public List<Role> findRoleByName(String role_name) throws Exception {
        List<Role> roles = new ArrayList<>();
        Role role = iRoleDao.findByName(role_name);
        roles.add(role);
        return roles;
    }

    @Override
    public List<Permission> findPrivilegesByRoleId(Integer roleId) throws Exception {
        List<Permission> permissions = iPermissionDao.findByRoleId(roleId);
        return permissions;
    }

    @Override
    public Role findRoleByRoleId(Integer roleId) throws Exception {
        Role role = iRoleDao.findById(roleId);
        return role;
    }

    @Override
    public void configPermission(Integer[] ids, Integer roleId) throws Exception {
        //1,删除roleId的所有权限
        iRoleDao.deletePermissionByRoleId(roleId);
        //遍历添ids加权限
        for (Integer permissionId:ids) {
            if(permissionId!=null && permissionId!=-1){
                iRoleDao.addPermissionByRoleId(roleId,permissionId);
            }
        }

    }

    @Override
    public List<Permission> findAllPrivileges(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Permission> permissions = iPermissionDao.findAll();
        return permissions;
    }

    @Override
    public List<Role> findRolesByPermissionId(Integer permissionId) throws Exception {
        List<Role> roles = iRoleDao.findByPermissionId(permissionId);
        return roles;
    }

    @Override
    public Permission findPermissionById(Integer permissionId) throws Exception {
        Permission permission = iPermissionDao.findById(permissionId);
        return permission;
    }
}
