package cn.cuit.gyl.dao.database;

import cn.cuit.gyl.domain.database.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RoleDao")
public interface IRoleDao {

    //查询所有的角色
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    //保存添加一个角色的信息
    @Select("insert into role (role.`id`,role.`role_name`,role.`role_desc`) values (#{id},#{role_name},#{role_desc})")
    void save(Role newRole) throws Exception;

    //查询最大id
    @Select("select MAX(`id`) from role")
    Integer findMaxId() throws Exception;

    //根据id删除角色
    @Delete("delete from role where id = #{id}")
    void deleteById(Integer id) throws Exception;

    //根据id更新角色
    @Update("update role set role.`role_name`=#{role_name},role.`role_desc`=#{role_desc} where id=#{id}")
    void updateById(Role role) throws Exception;

    //根据一个id查询一个角色
    @Select("select * from role where id = #{id}")
    Role findById(Integer id);
}