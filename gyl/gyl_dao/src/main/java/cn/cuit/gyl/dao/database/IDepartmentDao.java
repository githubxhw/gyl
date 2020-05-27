package cn.cuit.gyl.dao.database;

import cn.cuit.gyl.domain.database.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("iDepartmentDao")
public interface IDepartmentDao {

    //查询所有的部门
    @Select("select * from department")
    List<Department> findAll() throws Exception;

    //保存添加一个部门的信息
    @Select("insert into department (department.`name`,department.`desc`) values (#{name},#{desc})")
    void save(Department newDepartment) throws Exception;

    //根据id删除部门
    @Delete("delete from department where id = #{id}")
    void deleteById(Integer id) throws Exception;

    //根据id更新部门
    @Update("update department set department.`name`=#{name},department.`desc`=#{desc} where id=#{id}")
    void updateById(Department department) throws Exception;

    //根据一个id查询一个部门
    @Select("select * from department where id = #{id}")
    Department findById(Integer id);
}
