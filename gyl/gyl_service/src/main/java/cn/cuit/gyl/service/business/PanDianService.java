package cn.cuit.gyl.service.business;

import cn.cuit.gyl.domain.business.PanDian;
import cn.cuit.gyl.domain.business.PanDianZi;
import org.springframework.security.core.parameters.P;

import java.util.Date;
import java.util.List;

public interface PanDianService {
    List<PanDian> findByCondition(PanDian panDian) throws Exception;//条件查询
    List<PanDianZi> findZiByZid(Long zid) throws Exception;//根据主ID查询子表
    void Save(PanDian panDian) throws Exception;//保存主表
    Long getHh(Long zid) throws Exception;//得到行号
    void SaveZi(PanDianZi panDianZi) throws Exception;//保存子表
    PanDian findZhuById(Long id)throws Exception;//根据ID查询主表
    PanDianZi findZiById(Long id)throws Exception;//根据ID查询子表
    void UpdateZhuB(PanDian panDian)throws Exception;//更新主表
    void DeleteZhuB(Long id)throws Exception;//删除主表
    void DeleteZhuBs(String ids)throws Exception;//批量删除主表
    void UpdateZib(PanDianZi panDianZi, String xgr, Date xgrq) throws Exception;//更新子表
    void DeleteZib(Long id)throws Exception;//删除子表
    void DeleteZiBs(String ids)throws Exception;//批量删除子表
    void spNo(String djh, String spr, Date sprq)throws Exception;//审批no
    void spOk(String djh, String spr, Date sprq)throws Exception;//审批ok
    void PanD(PanDianZi panDianZi, String pdr, Date pdrq) throws Exception;//盘点
    void TiaoZ(PanDianZi panDianZi, String tzr, Date tzrq) throws Exception;//调整
}
