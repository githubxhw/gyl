package cn.cuit.gyl.service.business;

import cn.cuit.gyl.domain.business.Cgygdzhib;
import cn.cuit.gyl.domain.business.Cgygdzhub;
import cn.cuit.gyl.domain.database.gys;

import java.util.Date;
import java.util.List;

public interface CgygdService {
    List<Cgygdzhub> findByCondition(Cgygdzhub a) throws Exception;//查询主表
    List<Cgygdzhib> findCgYgZibByZid(Long zid) throws Exception;//根据主ID来查询子表
    void SaveCgYgZhuAndZiD(Cgygdzhub a) throws Exception;//保存子表和主表
    Long getHh(Long zid) throws  Exception;//得到行号
    void SaveZib(Cgygdzhib a) throws Exception;//保存子表
    Cgygdzhub findById(Long id) throws  Exception;//根据ID查询主表
    void UpdateZhuB(Cgygdzhub a) throws  Exception;//更新主表
    void DeleteZhuB(Long id) throws Exception;//根据ID删除主表
    void DeleteZhuBs(String ids) throws Exception;//批量删除主表
    Cgygdzhib findCgYgZibById(Long id) throws Exception;//根据ID来查询子表
    void UpdateZiB(Cgygdzhib a) throws  Exception;//更新子表
    void DeleteZhiB(Long id) throws Exception;//删除子表ByID
    void DeleteZhiBs(String ids) throws Exception;//批量的删除子表
    void spOk(String djh, String spr, Date sprq) throws Exception;//审批OK
    void spNo(String djh, String spr, Date sprq) throws Exception;//审批NO
    void YgBeDd(Cgygdzhub a) throws Exception;//预购单变订单
    gys FindByGName(String name) throws Exception;//验证供应商编码
}
