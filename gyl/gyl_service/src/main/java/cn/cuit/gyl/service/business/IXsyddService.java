package cn.cuit.gyl.service.business;

import cn.cuit.gyl.domain.business.Xsydd_zhub;
import cn.cuit.gyl.domain.business.Xsydd_zib;

import java.util.Date;
import java.util.List;

public interface IXsyddService {

    //根据相关信息进行预订单主表（不包括子表）查询
    List<Xsydd_zhub> findXsydd_zhub(Xsydd_zhub xsydd_zhub) throws Exception;

    //根据主表id查询所有的子表信息
    List<Xsydd_zib> findXsydd_zibByZhubId(Integer xsydd_zhub_id) throws Exception;

    //添加一个主表信息
    void saveZhub(Xsydd_zhub xsydd_zhub) throws Exception;

    //根据主表id删除主表信息以及子表信息
    void deleteZhubById(Integer xsydd_zhub_id) throws Exception;

    //根据主表 ids 来删除多个主表
    void deleteZhubByIds(String ids) throws Exception;

    //根据销售预订单主表id查询信息
    Xsydd_zhub findXsydd_zhubById(Integer xsydd_zhub_id) throws Exception;

    //点击模态框的修改按钮，发请求修改信息(通过id)，返回修改后的信息
    void updateXsydd_zhubById(Xsydd_zhub xsydd_zhub) throws Exception;

    //功能：子表：点击主表添加按钮触发，添加到模态框主表信息，查询出最大行号，行号添加是从1开始递增
    Long getZib_hhByZhub_id(Integer zhub_id) throws Exception;

    //功能：子表：点击子表添加模态框中的添加按钮，根据主表id添加一个子表信息
    void saveZib(Xsydd_zib xsydd_zib) throws Exception;

    //功能：子表：点击子表右边的删除按钮触发，根据id删除子表信息
    void deleteZibById(Integer xsydd_zib_id) throws Exception;

    //功能：子表：点击子表下面的删除按钮触发，根据多个ids删除多个子表
    void deleteZibByIds(String ids) throws Exception;

    //功能：子表：点击子表右边的修改按钮触发，根据id查询该条信息
    Xsydd_zib findXsydd_zibById(Integer xsydd_zib_id) throws Exception;

    //功能：子表：点击子表模态框中的修改按钮触发，根据id修改信息
    void updateXsydd_zibById(Xsydd_zib xsydd_zib) throws Exception;

    //功能：在xsydd-add.jsp保存主表和子表信息
    void saveZhubAndZib(Xsydd_zhub xsydd_zhub) throws Exception;

    //功能：点击xsdd-update.jsp中的 搜索按钮触发，查询 没有经过 审批即（sfsp = 0）的所有主表信息
    List<Xsydd_zhub> findByAllAndSfspIsZero(Xsydd_zhub xsydd_zhub) throws Exception;

    //功能：审批禁止功能 ： 单击子表下面的 审批禁止按钮 触发，给已经选择的预购单修改信息
    //在服务器 判断是否该预购单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 0;
    void spForbidden(String ddh, String spr, Date sprq) throws Exception;

    //功能：审批通过功能 ： 单击子表下面的 审批通过按钮 触发，给已经选择的预购单修改信息
    //在服务器 判断是否该预购单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 1;
    void spAdopt(String ddh, String spr, Date sprq) throws Exception;
}
