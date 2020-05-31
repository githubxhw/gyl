package cn.cuit.gyl.service.database;

import cn.cuit.gyl.domain.database.gys;
import cn.cuit.gyl.domain.database.pages.PageBean;

public interface GysService {
    //分页查询
    PageBean<gys> findByPage(String _currentPage, String _rows, gys gys) throws Exception;
    //删除
    void Delete(Long id) throws Exception;
    //根据ID查询
    gys FindById(long id) throws Exception;
    //根据名字查询
    gys FindByName(String name) throws Exception;
    //根据全名查询
    gys FindByFullName(String FullName) throws Exception;
    //根据助记码查询
    gys FindByZjm(String Zjm) throws Exception;
    //保存
    void Save(gys a)throws Exception;
    //更新
    void Update(gys a)throws Exception;
}
