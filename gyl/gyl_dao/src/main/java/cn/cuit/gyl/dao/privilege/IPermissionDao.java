package cn.cuit.gyl.dao.privilege;

import cn.cuit.gyl.domain.privilege.Permission;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("iPermissionDao")
public interface IPermissionDao {

    //根据role角色id查询permission权限
    @Select("select * from permission where id in (select permission_id from role_permission where role_id=#{roleId})")
    List<Permission> findByRoleId(Integer roleId) throws Exception;

    //查询所有的权限信息
    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    //根据id查询权限
    @Select("select * from permission where id=#{permissionId}")
    Permission findById(Integer permissionId) throws Exception;

    //根据权限名称查询对应的id
    @Select("select id from permission where permission_name=#{permissionName}")
    Integer findIdByPermissionName(String permissionName) throws Exception;
}
