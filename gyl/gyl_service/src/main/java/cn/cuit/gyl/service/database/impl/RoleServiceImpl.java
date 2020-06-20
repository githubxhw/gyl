package cn.cuit.gyl.service.database.impl;

import cn.cuit.gyl.dao.database.IRoleDao;
import cn.cuit.gyl.domain.database.Role;
import cn.cuit.gyl.service.database.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RoleServiceImpl")
public class RoleServiceImpl implements RoleService {

    @Autowired
    @Qualifier("RoleDao")
    IRoleDao dao = null;

    @Override
    public List<Role> findAll(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Role> roles = dao.findAll();
        return roles;
    }

    @Override
    public void save(Role newRole) throws Exception {
        newRole.setId(dao.findMaxId()+1);
        dao.save(newRole);
        return;
    }

    @Override
    public void deleteByIds(Integer[] ids) throws Exception {
        for (Integer id:ids) {
            dao.deleteById(id);
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        dao.deleteById(id);
    }

    @Override
    public void updateById(Role role) throws Exception {
        dao.updateById(role);
    }

    @Override
    public Role findById(Integer id) throws Exception {
        Role role = dao.findById(id);
        return role;
    }
}
