package cn.cuit.gyl.service.database.impl;

import cn.cuit.gyl.dao.database.GysDao;
import cn.cuit.gyl.domain.database.gys;
import cn.cuit.gyl.domain.database.pages.PageBean;
import cn.cuit.gyl.domain.database.pages.SearchGys;
import cn.cuit.gyl.service.database.GysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GysService")
public class GysServiceImpl implements GysService {
    @Autowired
    @Qualifier("GysDao")
    GysDao gysDao;


    @Override
    public PageBean<gys> findByPage(String _currentPage, String _rows, gys gys) throws Exception {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        SearchGys searchGys = new SearchGys();
        searchGys.setGys(gys);

        //3.调用dao查询总记录数
        int totalCount = gysDao.findTotalCount(searchGys);
        System.out.println("totalCount="+totalCount);
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        if(currentPage > totalPage){
            currentPage = totalPage;
        }
        if(currentPage <=0) {
            currentPage = 1;
        }
        //1.创建空的PageBean对象
        PageBean<gys> pb = new PageBean<gys>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        pb.setTotalCount(totalCount);
        //4.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        searchGys.setStart(start);
        searchGys.setRow(rows);
        searchGys.setGys(gys);
        List<gys> list = gysDao.findByCondition(searchGys);
        pb.setList(list);
        //5.计算总页码
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public void Delete(Long id) throws Exception {
        gysDao.DeleteById(id);
    }

    @Override
    public gys FindById(long id) throws Exception {
        gys byId = gysDao.findById(id);
        return byId;
    }

    @Override
    public gys FindByName(String name) throws Exception {
        gys byName = gysDao.findByName(name);
        return byName;
    }

    @Override
    public gys FindByFullName(String FullName) throws Exception {
        gys byFullName = gysDao.findByFullName(FullName);
        return byFullName;
    }

    @Override
    public gys FindByZjm(String Zjm) throws Exception {
        gys byZjm = gysDao.findByZjm(Zjm);
        return byZjm;
    }

    @Override
    public void Save(gys a) throws Exception {
        if (a.getFullname()==null){
            a.setFullname(a.getName());
        }
        gysDao.Add(a);
    }

    @Override
    public void Update(gys a) throws Exception {
        gysDao.Update(a);
    }
}
