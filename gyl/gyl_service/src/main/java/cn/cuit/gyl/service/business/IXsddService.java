package cn.cuit.gyl.service.business;


import cn.cuit.gyl.domain.business.Xsdd_zhub;
import cn.cuit.gyl.domain.business.Xsdd_zib;

import java.util.Date;
import java.util.List;

//销售订单业务层接口
public interface IXsddService {

    //功能：点击xsdd-add.jsp中的添加按钮触发请求，保存主表和子表
    void saveZhubAndZib(Xsdd_zhub xsdd_zhub) throws Exception;

    //功能：点击xsdd-query.jsp中查询部分的 “搜索” 按钮触发，模糊查询销售订单
    List<Xsdd_zhub> findByXsdd_zhub(Xsdd_zhub xsdd_zhub) throws Exception;

    //功能：点击xsdd-query.jsp中主表中的修改按钮触发，根据id查询销售订单主表信息
    Xsdd_zhub findXsdd_zhubById(Integer xsdd_zhub_id) throws Exception;

    //功能：点击xsdd-query.jsp中主表中模态框的修改按钮触发，根据id更新销售订单信息
    void updateXsdd_zhubById(Xsdd_zhub xsdd_zhub) throws Exception;

    //功能：点击xsdd-query.jsp中主表中的删除按钮，提示是否删除，确认删除后触发，根据id删除销售订单主表的信息
    void deleteXsdd_ZhubById(Integer xsdd_zhub_id) throws Exception;

    //功能：点击xsdd-query.jsp主表下面的删除按钮触发，根据多个id删除多个信息
    void deleteXsdd_ZhubByIds(String ids) throws Exception;

    //功能：点击xsdd-query.jsp主表模态框中的添加按钮触发，保存一个销售订单主表信息
    void saveXsdd_zhub(Xsdd_zhub xsdd_zhub) throws Exception;

    //功能：双击xsdd-query.jsp主表中的订单号ddh按钮触发，根据主表的id查询对应的索引子表信息
    List<Xsdd_zib> findXsdd_zibByZhubId(Integer xsdd_zhub_id) throws Exception;

    //功能：双击xsdd-query.jsp子表中的修改按钮触发，根据子表的id的查询信息
    Xsdd_zib findXsdd_zibById(Integer xsdd_zib_id) throws Exception;

    //功能：点击子表模态框中的修改按钮触发，更新子表信息
    void updateXsdd_zibById(Xsdd_zib xsdd_zib) throws Exception;

    //功能：点击子表中删除按钮触发，根据id删除信息
    void deleteXsdd_ZibById(Integer xsdd_zib_id) throws Exception;

    //功能：点击子表下面的添加按钮触发查询hh---》max hh
    Long getZib_hhByZhub_id(Integer xsdd_zhub_id) throws Exception;

    //功能：点击子表添加模态框中的添加按钮触发，保存子表信息
    void saveXsdd_zib(Xsdd_zib xsdd_zib) throws Exception;

    //功能：点击子表下面的删除按钮，删除子表信息
    void deleteXsdd_ZibByIds(String ids) throws Exception;

    //功能：点击xsdd-update.jsp中的 搜索按钮触发，查询 没有经过 审批即（sfsp = 0）的所有主表信息
    List<Xsdd_zhub> findByAllAndSfspIsZero(Xsdd_zhub xsdd_zhub) throws Exception;

    //功能：审批禁止功能 ： 单击子表下面的 审批禁止按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 0;
    void spForbidden(String ddh, String spr, Date sprq) throws Exception;

    //功能：审批通过功能 ： 单击子表下面的 审批通过按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 1;
    //若商品通过，则生成销售出库预警表
    void spAdopt(String ddh, String spr, Date sprq) throws Exception;
}
