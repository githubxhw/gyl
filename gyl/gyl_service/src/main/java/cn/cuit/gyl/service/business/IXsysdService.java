package cn.cuit.gyl.service.business;

import cn.cuit.gyl.domain.business.Xsysdzhib;
import cn.cuit.gyl.domain.business.Xsysdzhub;
import cn.cuit.gyl.utils.PageInfo;

import java.util.Date;
import java.util.List;

public interface IXsysdService {
    //条件查询
    List<Xsysdzhub> findByCondition(Xsysdzhub xsysdzhub) throws Exception;
    //查询没有审核的
    List<Xsysdzhub> findByNoSh(Xsysdzhub xsysdzhub) throws Exception;
    //根据主ID查询子表
    List<Xsysdzhib> findZiByZid(Long zid) throws Exception;
    //根据ID查询子表
    Xsysdzhib findZiById(Long id) throws Exception;
    //查询生效了但是没签字的应收单
    List<Xsysdzhub> findBySxBzIsOne(Xsysdzhub xsysdzhub) throws Exception;
    //得到最大的行号
    Long getZib_hh(Long zid) throws Exception;
    //根据ID查询主表信息
    Xsysdzhub findZhuById(Long id) throws Exception;
    //修改应收单主表信息
    PageInfo UpdateXsYsZhuB(Xsysdzhub xsysdzhub)throws Exception;
    //根据ID删除应收单主表
    void DeleteXsYsZhuBByID(Long id) throws Exception;
    //删除多个应收单主表
    void DeleteXsYsZhuBByIDs(String ids) throws Exception;
    //添加应收单主表的信息
    PageInfo AddXsYsZhuB(Xsysdzhub xsysdzhub) throws Exception;
    //修改应收单子表信息
    PageInfo UpdateXsYsZhiB(String xgr, Date xgrq, Xsysdzhib xsysdzhib) throws Exception;
    //根据ID删除应收单子表的信息
    void DeleteXsYsZhiBByID(Long id) throws Exception;
    //删除多个应收单子表的信息
    void DeleteXsYsZhiBByIDs(String ids) throws Exception;
    //添加应收单子表的信息
    PageInfo AddXsYsZhiB(Xsysdzhib xsysdzhib, String xgr, Date xgrq) throws Exception;
    //审核通过
    PageInfo shOK(String shr, Date shrq, String ddh) throws Exception;
    //审核不通过
    PageInfo shNo(String shr, Date shrq, String ddh) throws Exception;
    //签字
    PageInfo qz(String qzr, Date qzrq, String ddh) throws Exception;
}
