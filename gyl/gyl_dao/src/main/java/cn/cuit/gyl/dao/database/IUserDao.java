package cn.cuit.gyl.dao.database;

import cn.cuit.gyl.domain.database.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("iUserDao")
public interface IUserDao {

    //查询所有用户
    @Select("select * from user")
    List<UserInfo> findAll() throws Exception;

    //添加一个用户
    @Insert("insert into user (username,password,phone,email,status,sex) values (#{username},#{password},#{phone},#{email},#{status},#{sex})")
    void save(UserInfo userInfo);

    //通过id删除用户
    @Delete("delete from user where id = #{id}")
    void deleteById(Integer id);

    //根据id查询用户
    @Select("select * from user where id = #{id}")
    UserInfo findById(Integer id) throws Exception;

    //根据id更新用户
    @Update("update user set username=#{username},password=#{password},sex=#{sex},phone=#{phone},email=#{email},status=#{status} where id=#{id}")
    void updateById(UserInfo userInfo);

    //根据用户姓名查询用户信息
    @Select("select * from user where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "email",column = "email"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "cn.cuit.gyl.dao.privilege.IRoleDao.findByUserId"))
    })
    UserInfo findByName(String username) throws Exception;

    //根据role的id查询出所有拥有该角色的用户s
    @Select("select * from user where id in (select user_id from user_role where role_id=#{id})")
    List<UserInfo> findByRoleId(Integer id) throws Exception;
}
