package cn.cuit.gyl.service.database.impl;

import cn.cuit.gyl.dao.database.KhDao;
import cn.cuit.gyl.domain.database.kh;
import cn.cuit.gyl.domain.database.pages.PageBean;
import cn.cuit.gyl.domain.database.pages.SearchKh;
import cn.cuit.gyl.service.database.KhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("KhService")
public class KhServiceImpl implements KhService {
    @Autowired
    @Qualifier("KhDao")
    KhDao khDao;

    @Override
    public PageBean<kh> findByPage(String _currentPage, String _rows, kh gys) throws Exception {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        SearchKh searchkh = new SearchKh();
        searchkh.setKh(gys);

        //3.调用dao查询总记录数
        int totalCount = khDao.findTotalCount(searchkh);

        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;

        if(currentPage > totalPage){
            currentPage = totalPage;
        }
        if(currentPage<0||currentPage == 0) {
            currentPage = 1;
        }
        //1.创建空的PageBean对象
        PageBean<kh> pb = new PageBean<kh>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        pb.setTotalCount(totalCount);
        //4.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;

        searchkh.setStart(start);
        searchkh.setRow(rows);
        searchkh.setKh(gys);
        List<kh> list = khDao.findByCondition(searchkh);
        pb.setList(list);
        //5.计算总页码
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public void Delete(String name) throws Exception {
        khDao.DeleteByName(name);
    }

    @Override
    public kh FindByName(String name) throws Exception {
        kh byId = khDao.findByName(name);
        return byId;
    }

    @Override
    public kh FindByFullName(String FullName) throws Exception {
        kh byFullName = khDao.findByFullName(FullName);
        return byFullName;
    }

    @Override
    public kh FindByZjm(String zjm) throws Exception {
        kh byZjm = khDao.findByZjm(zjm);
        return byZjm;
    }

    @Override
    public void Save(kh a) throws Exception {
        if (a.getFullname() == null){
            a.setFullname(a.getName());
        }
        khDao.Add(a);
    }

    @Override
    public void Update(kh a) throws Exception {
        khDao.Update(a);
    }
}
