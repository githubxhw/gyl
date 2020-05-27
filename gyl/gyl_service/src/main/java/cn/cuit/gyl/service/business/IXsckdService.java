package cn.cuit.gyl.service.business;

import cn.cuit.gyl.domain.business.Xsckd_zhub;
import cn.cuit.gyl.domain.business.Xsckd_zib;
import cn.cuit.gyl.utils.PageInfo;

import java.util.Date;
import java.util.List;

//销售出库单业务层接口
public interface IXsckdService {

    //根据主表的多个属性值查询满足条件的所有主表
    List<Xsckd_zhub> findZhubByMany(Xsckd_zhub xsckd_zhub) throws Exception;

    //根据主表的id查询对应所有子表
    List<Xsckd_zib> findZibsByZhubId(Integer xsckd_zhub_id) throws Exception;

    //添加销售出库单 主表和子表s
    PageInfo saveZhubAndZib(Xsckd_zhub xsckd_zhub) throws Exception;

    //查询没有审批 和其它主表信息 的所有主表s
    List<Xsckd_zhub> findAllAndNotSh(Xsckd_zhub xsckd_zhub) throws Exception;

    ////根据主表id查询信息
    Xsckd_zhub findXsckd_zhubById(Integer xsckd_zhub_id) throws Exception;

    //根据主表id修改信息
    void updateXsckd_zhubById(Xsckd_zhub xsckd_zhub) throws Exception;

    //根据主表id删除主表信息
    void deleteXsckd_zhubById(Integer xsckd_zhub_id) throws Exception;

    //根据多个id删除主表信息
    void deleteXsckd_ZhubByIds(String ids) throws Exception;

    //根据子表id查询子表信息
    Xsckd_zib findXsckd_zibById(Integer xsckd_zib_id) throws Exception;

    //根据子表id更新子表信息
    void updateXsckd_zibById(Xsckd_zib xsckd_zib) throws Exception;

    //根据子表id删除子表
    void deleteXsckd_ZibById(Integer xsckd_zib_id) throws Exception;

    //根据多个子表id删除多个子表
    void deleteXsckd_ZibByIds(String ids) throws Exception;

    ////获取一个子表的行号hh
    Integer getZibHhByZhubId(Integer xsckd_zhub_id) throws Exception;

    ////添加一个子表信息
    void saveXsckd_zib(Xsckd_zib xsckd_zib) throws Exception;

    //功能：审批禁止功能 ： 单击子表下面的 审批禁止按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 0;
    void spForbidden(String djh, String spr, Date shrq) throws Exception;

    //功能：审批通过功能 ： 单击子表下面的 审批通过按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 1;
    void spAdopt(String djh, String spr, Date shrq) throws Exception;

    //功能：确认出库，修改单据状态status为结束1，并回写信息到有关表中
    void updateZibStatusByIds(String ids, String xgr, Date xgrq) throws Exception;
}
