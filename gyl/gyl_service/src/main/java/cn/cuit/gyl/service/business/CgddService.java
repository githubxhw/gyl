package cn.cuit.gyl.service.business;

import cn.cuit.gyl.domain.business.Cgddzhib;
import cn.cuit.gyl.domain.business.Cgddzhub;
import cn.cuit.gyl.domain.database.gys;

import java.util.Date;
import java.util.List;

public interface CgddService {
    List<Cgddzhub> findAll();//查询所有
    List<Cgddzhub> findByCondition(Cgddzhub cgddzhub) throws Exception;//根据条件查询
    Cgddzhub findById(Long id);//根据ID查询
    Long getZiBHH(Long zid) throws  Exception;//得到子表的行号
    void updateById(Cgddzhub a) throws Exception;//根据ID修改主表
    void deleteById(Long id);//根据ID删除主表
    void deleteZiById(Long id);//根据ID删除子表
    void updateZiById(Cgddzhib a) throws Exception;//根据ID修改子表
    void deleteZhiByIds(String ids) throws Exception;//根据IDS来删除子表
    void deleteByIds(String ids) throws Exception;//根据IDS来删除主表
    void saveZib(Cgddzhib cgddzhib)throws Exception;//保存子表
    void saveCgddzhub(Cgddzhub cgddzhub);//保存主表
    void spOk(String djh, String spr, Date sprq) throws Exception;//审批OK
    void spNo(String djh, String spr, Date sprq) throws Exception;//审批NO
    List<Cgddzhib> findZibByZhuId(Long id);//通过主ID来查询子表
    void updateDj(Cgddzhub a) throws Exception;//更新冻结的状态
    Cgddzhib findZibByZiId(Long id);//通过ID来查询子表
    void saveCgddZhiAndZhu(Cgddzhub cgddzhub) throws Exception;//保存子表和主表
    List<Cgddzhub> findByAllAndSfspIsZero(Cgddzhub cgddzhub) throws Exception;//查询没有
    void SaveZhuAndZi(Cgddzhub cgdd_zhub) throws  Exception;//保存子表和主表
    void SaveZib(Cgddzhib a, String xgr, Date xgrq) throws  Exception;//保存子表（修改里面的添加）
    void UpdateZhiB(Cgddzhib cgddzhib, String xgr, Date xgrq) throws Exception;//修改子表
    gys FindByGName(String name) throws Exception;//验证供应商的编码
}
