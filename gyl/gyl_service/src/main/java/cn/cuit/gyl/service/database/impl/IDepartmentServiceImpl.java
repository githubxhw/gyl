package cn.cuit.gyl.service.database.impl;

import cn.cuit.gyl.dao.database.IDepartmentDao;
import cn.cuit.gyl.domain.database.Department;
import cn.cuit.gyl.service.database.IDepartmentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iDepartmentServiceImpl")
public class IDepartmentServiceImpl implements IDepartmentService {

    @Autowired
    @Qualifier("iDepartmentDao")
    IDepartmentDao dao = null;

    @Override
    public List<Department> findAll(Integer pageNum,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Department> departments = dao.findAll();
        return departments;
    }

    @Override
    public void save(Department newDepartment) throws Exception {
        dao.save(newDepartment);
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
    public void updateById(Department department) throws Exception {
        dao.updateById(department);
    }

    @Override
    public Department findById(Integer id) throws Exception {
        Department department = dao.findById(id);
        return department;
    }
}
