package cn.cuit.gyl.service.database;

import cn.cuit.gyl.domain.database.UserInfo;

import java.util.List;

public interface IUserService {

    //查询所有用户UserInfo
    List<UserInfo> findAll(Integer pageNum, Integer pageSize) throws Exception;

    //添加一个用户
    void save(UserInfo userInfo) throws Exception;

    //通过多个id删除用户
    void deleteByIds(Integer[] ids) throws Exception;

    //通过一个id删除用户
    void deleteById(Integer id) throws Exception;

    //通过id查询一个用户信息
    UserInfo findById(Integer id) throws Exception;

    //通过id更新用户
    void updateById(UserInfo userInfo) throws Exception;

    //模糊查询
    List<UserInfo> findByFuzzyName(String fuzzyName, Integer pageNum, Integer pageSize);
}
