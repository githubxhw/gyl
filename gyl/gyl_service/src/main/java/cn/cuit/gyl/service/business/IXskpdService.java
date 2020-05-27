package cn.cuit.gyl.service.business;

import cn.cuit.gyl.domain.business.Xskpd_zhub;
import cn.cuit.gyl.domain.business.Xskpd_zib;
import cn.cuit.gyl.utils.PageInfo;

import java.util.Date;
import java.util.List;

public interface IXskpdService {

    //根据Xskpd_zhub 的信息查询所以满足的主表s
    List<Xskpd_zhub> findZhubByMany(Xskpd_zhub xskpd_zhub) throws Exception;

    //根据主表id查询所以的子表s
    List<Xskpd_zib> findZibsByZhubId(Integer xskpd_zhub_id) throws Exception;

    //添加主表以及子表信息
    PageInfo saveZhubAndZib(Xskpd_zhub xskpd_zhub) throws Exception;

    //根据主表id查询信息
    Xskpd_zhub findZhubById(Integer xskpd_zhub_id) throws Exception;

    //根据主表id并修改主表信息
    void updateZhubById(Xskpd_zhub xskpd_zhub) throws Exception;

    //根据id删除主表信息
    void deleteZhubById(Integer xskpd_zhub_id) throws Exception;

    //根据多个id删除多个主表信息
    void deleteZhubsByIds(String ids) throws Exception;

    //根据子表id修改子表信息
    void updateZibById(Xskpd_zib xskpd_zib) throws Exception;

    //根据子表id查询子表信息
    Xskpd_zib findZibById(Integer xskpd_zib_id) throws Exception;

    //根据主表id，查询出最大行号，并+1
    Integer getZibHhByZhubId(Integer xskpd_zhub_id) throws Exception;

    //保存一个子表
    void saveZib(Xskpd_zib xskpd_zib) throws Exception;

    //根据子表id删除子表信息
    void deleteZibById(Integer xskpd_zib_id) throws Exception;

    //根据多个子表id删除多个子表
    void deleteZibsByIds(String ids) throws Exception;

    //审批禁止
    void spForbidden(String fph, String spr, Date sprq) throws Exception;

    //审批通过
    void spAdopt(String fph, String spr, Date sprq) throws Exception;

    //根据子表的ids来确认开票（行状态）
    void updateZibStatusByIds(String ids, String xgr, Date xgrq) throws Exception;
}
