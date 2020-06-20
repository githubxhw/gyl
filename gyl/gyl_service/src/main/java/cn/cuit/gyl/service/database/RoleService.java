package cn.cuit.gyl.service.database;

import cn.cuit.gyl.domain.database.Role;

import java.util.List;

public interface RoleService {

    //查询所有的角色
    List<Role> findAll(Integer pageNum, Integer pageSize) throws Exception;

    //保存一个角色
    void save(Role newRole) throws Exception;

    //通过多个id删除多个角色
    void deleteByIds(Integer[] ids) throws Exception;

    //通过一个id删除角色
    void deleteById(Integer id) throws Exception;

    //通过id更新角色
    void updateById(Role role) throws Exception;

    //根据一个id查询一个角色
    Role findById(Integer id) throws Exception;
}