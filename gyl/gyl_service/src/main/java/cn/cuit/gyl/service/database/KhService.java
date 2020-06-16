package cn.cuit.gyl.service.database;

import cn.cuit.gyl.domain.database.kh;
import cn.cuit.gyl.domain.database.pages.PageBean;

public interface KhService {
    PageBean<kh> findByPage(String _currentPage, String _rows, kh gys) throws Exception;//分页
    void Delete(String name) throws Exception;//删除
    kh FindByName(String name) throws Exception;//根据名字查询
    kh FindByFullName(String FullName) throws Exception;//根据全名查询
    kh FindByZjm(String zjm) throws Exception;//根据助记码查询
    void Save(kh a) throws Exception;//保存
    void Update(kh a) throws Exception;//更新
}
