package cn.cuit.gyl.service.business;


import cn.cuit.gyl.domain.business.Xsfhd_zhub;
import cn.cuit.gyl.domain.business.Xsfhd_zib;
import cn.cuit.gyl.utils.PageInfo;

import java.util.Date;
import java.util.List;

//销售发货单的业务层dao接口
public interface IXsfhdService {

    //功能：在xsfhd-add.jsp中单击保存按钮触发。保存子表和主表信息。
    PageInfo saveZhubAndZib(Xsfhd_zhub xsfhd_zhub) throws Exception;

    //功能：点击xsfhd-query.jsp中的查询按钮触发，根据信息查询满足所有的销售发货单
    List<Xsfhd_zhub> findByXsfhd_zhub(Xsfhd_zhub xsfhd_zhub) throws Exception;

    //功能：点击xsfhd-query.jsp主表中的修改按钮触发，根据主表id查询信息并返回
    Xsfhd_zhub findXsfhd_zhubById(Integer xsfhd_zhub_id) throws Exception;

    //功能：点击xsfhd-query.jsp主表中的模态框修改按钮触发，根据id修改信息
    void updateXsfhd_zhubById(Xsfhd_zhub xsfhd_zhub) throws Exception;

    //功能：点击xsfhd-query.jsp主表中的删除按钮触发，根据主表id删除信息
    void deleteXsfhd_ZhubById(Integer xsfhd_zhub_id) throws Exception;

    //功能：主点击xsfhd-query.jsp主表添加模态框的添加按钮触发，添加主表信息
    void saveXsfhd_zhub(Xsfhd_zhub xsfhd_zhub) throws Exception;

    //功能：主点击xsfhd-query.jsp主表下面的删除按钮触发，根据ids删除信息
    void deleteXsfhd_ZhubByIds(String ids) throws Exception;

    //功能：双击 xsfhd-query.jsp主表中的ddh按钮触发，根据在主表id（外键）查询所有的子表信息
    List<Xsfhd_zib> findXsfhd_zibByZhubId(Integer xsfhd_zhub_id) throws Exception;

    //功能：双击 xsfhd-query.jsp子表中的修改按钮触发，根据子表id进行查询信息
    Xsfhd_zib findXsfhd_zibById(Integer xsfhd_zib_id) throws Exception;

    //功能：单击 xsfhd-query.jsp子表中的删除按钮触发，根据子表id删除子表信息
    void deleteXsfhd_ZibById(Integer xsfhd_zib_id) throws Exception;

    //功能：单击 xsfhd-query.jsp子表下面中的删除按钮触发，根据子表ids删除子表信息
    void deleteXsfhd_ZibByIds(String ids) throws Exception;

    //功能：单击xsfhd-query.jsp中子表下面的添加按钮触发,根据主表查询出max行号+1
    Integer getZib_hh(Integer xsfhd_zhub_id) throws Exception;

    //功能：单击xsfhd-query.jsp中子表模态框中的添加按钮触发,保存一个子表
    void saveXsfhd_zib(Xsfhd_zib xsfhd_zib) throws Exception;

    //功能：单击xsfhd-update.jsp中搜索按钮，搜索 未审批的发货单
    List<Xsfhd_zhub> findAllAndSfspIsZero(Xsfhd_zhub xsfhd_zhub) throws Exception;

    //功能：审批禁止功能 ： 单击子表下面的 审批禁止按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 0;
    void spForbidden(String ddh, String spr, Date sprq) throws Exception;

    //功能：审批通过功能 ： 单击子表下面的 审批通过按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 1;
    void spAdopt(String ddh, String spr, Date sprq) throws Exception;

    //功能：单机子表下面的 确认发货按钮，根据ids将选择的所有子表中的status修改为1
    void updateZibStatusByIds(String ids,String xgr,Date xgsj) throws Exception;
}
