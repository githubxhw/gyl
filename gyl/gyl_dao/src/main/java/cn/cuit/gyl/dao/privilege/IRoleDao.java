package cn.cuit.gyl.dao.privilege;

import cn.cuit.gyl.domain.privilege.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("iRoleDao")
public interface IRoleDao {

    //根据user用户id查询role角色
    @Select("select * from role where id in (select role_id from user_role where user_id=#{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "role_name",column = "role_name"),
            @Result(property = "role_desc",column = "role_desc"),
            @Result(property = "permissions",column = "id",javaType = List.class,many = @Many(select = "cn.cuit.gyl.dao.privilege.IPermissionDao.findByRoleId"))
    })
    List<Role> findByUserId(Integer userId) throws Exception;

    //查询所以role角色
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    //根据角色名称来查询role角色
    @Select("select * from role where role_name=#{role_name}")
    Role findByName(String role_name) throws Exception;

    //根据角色id查询role角色
    @Select("select * from role where id=#{id}")
    Role findById(Integer id) throws Exception;

    //根据roleId删除所有权限
    @Delete("delete from role_permission where role_id=#{roleId}")
    void deletePermissionByRoleId(Integer roleId) throws Exception;

    //根据roleId插入一条权限信息
    @Insert("insert into role_permission (role_id,permission_id) values (#{role_id},#{permission_id})")
    void addPermissionByRoleId(@Param("role_id") Integer roleId,@Param("permission_id") Integer permissionId) throws Exception;

    //根据权限id查询所有角色s
    @Select("select * from role where id in (select role_id from role_permission where permission_id=#{permissionId})")
    List<Role> findByPermissionId(Integer permissionId) throws Exception;
}
