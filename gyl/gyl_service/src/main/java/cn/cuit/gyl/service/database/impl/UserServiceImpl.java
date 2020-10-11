package cn.cuit.gyl.service.database.impl;

import cn.cuit.gyl.dao.database.IUserDao;
import cn.cuit.gyl.domain.database.UserInfo;
import cn.cuit.gyl.service.database.IUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

    @Autowired
    @Qualifier("iUserDao")
    IUserDao dao = null;

    @Override
    public List<UserInfo> findAll(Integer pageNum,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<UserInfo> users = dao.findAll();
        return users;
    }

    @Override
    public void save(UserInfo userInfo) throws Exception{
        dao.save(userInfo);
    }

    @Override
    public void deleteByIds(Integer[] ids) throws Exception {
        for (int i = 0; i < ids.length; i++) {
            dao.deleteById(ids[i]);
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception{
        dao.deleteById(id);
    }

    @Override
    public UserInfo findById(Integer id) throws Exception {
        UserInfo userInfo = dao.findById(id);
        return userInfo;
    }

    @Override
    public void updateById(UserInfo userInfo) throws Exception {
        dao.updateById(userInfo);
    }

    @Override
    public List<UserInfo> findByFuzzyName(String fuzzyName, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return dao.findByFuzzyName(fuzzyName);
    }
}
