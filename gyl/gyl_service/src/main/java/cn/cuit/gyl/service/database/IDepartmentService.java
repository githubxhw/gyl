package cn.cuit.gyl.service.database;

import cn.cuit.gyl.domain.database.Department;

import java.util.List;

public interface IDepartmentService {

    //查询所有的部门
    List<Department> findAll(Integer pageNum,Integer pageSize) throws Exception;

    //保存一个部门
    void save(Department newDepartment) throws Exception;

    //通过多个id删除多个部门
    void deleteByIds(Integer[] ids) throws Exception;

    //通过一个id删除部门
    void deleteById(Integer id) throws Exception;

    //通过id更新部门
    void updateById(Department department) throws Exception;

    //根据一个id查询一个部门
    Department findById(Integer id) throws Exception;

    //根据部门名称，模糊分页查询部门信息
    List<Department> findByFuzzyName(String fuzzyName, Integer pageNum, Integer pageSize);
}
