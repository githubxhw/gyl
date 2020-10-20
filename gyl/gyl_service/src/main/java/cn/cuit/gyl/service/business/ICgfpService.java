package cn.cuit.gyl.service.business;

import cn.cuit.gyl.domain.business.*;
import cn.cuit.gyl.utils.Reback;

import java.util.Date;
import java.util.List;

//采购发票业务接口
public interface ICgfpService {
    //功能：点击cgfp-add.jsp中的添加按钮触发请求，保存主表和子表
    void saveZhubAndZib(Cgfp_zhub cgfp_zhub) throws Exception;

    //功能：点击cgfp-query.jsp中查询部分的 “搜索” 按钮触发，模糊查询采购发票
    List<Cgfp_zhub> findByCgfp_zhub(Cgfp_zhub cgfp_zhub) throws Exception;

    //功能：点击cgfp-query.jsp中主表中的修改按钮触发，根据id查询采购发票主表信息
    Cgfp_zhub findCgfp_zhubById(Integer cgfp_zhub_id) throws Exception;

    //功能：点击cgfp-query.jsp中主表中模态框的修改按钮触发，根据id更新采购发票信息
    void updateCgfp_zhubById(Cgfp_zhub cgfp_zhub) throws Exception;

    //功能：点击cgfp-query.jsp中主表中的删除按钮，提示是否删除，确认删除后触发，根据id删除采购发票主表的信息
    void deleteCgfp_ZhubById(Integer cgfp_zhub_id) throws Exception;

    //功能：点击cgfp-query.jsp主表下面的删除按钮触发，根据多个id删除多个信息
    void deleteCgfp_ZhubByIds(String ids) throws Exception;

    //功能：点击cgfp-query.jsp主表模态框中的添加按钮触发，保存一个采购发票主表信息
    void saveCgfp_zhub(Cgfp_zhub cgfp_zhub) throws Exception;

    //功能：双击cgfp-query.jsp主表中的订单号fph按钮触发，根据主表的id查询对应的索引子表信息
    List<Cgfp_zib> findCgfp_zibByZhubId(Integer cgfp_zhub_id) throws Exception;

    //功能：双击cgfp-query.jsp子表中的修改按钮触发，根据子表的id的查询信息
    Cgfp_zib findCgfp_zibById(Integer cgfp_zib_id) throws Exception;

    //功能：点击子表模态框中的修改按钮触发，更新子表信息
    void updateCgfp_zibById(Cgfp_zib cgfp_zib) throws Exception;

    //功能：点击子表中删除按钮触发，根据id删除信息
    void deleteCgfp_ZibById(Integer cgfp_zib_id) throws Exception;

    //功能：点击子表下面的添加按钮触发查询:hh-->max hh
    Long getZib_hhByZhub_id(Integer cgfp_zhub_id) throws Exception;

    //功能：点击子表添加模态框中的添加按钮触发，保存子表信息
    void saveCgfp_zib(Cgfp_zib cgfp_zib) throws Exception;

    //功能：点击子表下面的删除按钮，删除子表信息
    void deleteCgfp_ZibByIds(String ids) throws Exception;

    //==============================================================
    //功能：单击cgrkd-update.jsp中搜索按钮，搜索 未审批的发货单
    List<Cgfp_zhub> findAllAndSfshIsZero(Cgfp_zhub cgfp_zhub) throws Exception;

    //功能：审批禁止功能 ： 单击子表下面的 审批禁止按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 0;
    void spForbidden(String ddh, String spr, Date sprq) throws Exception;

    //功能：审批通过功能 ： 单击子表下面的 审批通过按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 1;
    void spAdopt(String ddh, String spr, Date sprq) throws Exception;

    //功能：单机子表下面的 确认入库按钮，根据ids将选择的所有子表中的status修改为1
    void updateZibStatusByIds(String ids, String xgr, Date xgsj) throws Exception;

    //=================================================================
    //获取采购订单（cgdd）主表的所有的东西
    List<Cgddzhub> getAllOfCgddZhub();

    //获取采购订单（cgddzib）子表的所有的东西
    List<Cgddzhib> getAllOfCgddZib();
    //获取采购到货单子表
    List<Cgdhd_zib> getAllOfCgdhdZib();
    //获取采购预购单子表
    List<Cgygdzhib> getAllOfCgygdZib();

    Reback<Cgdhd_zib> BlanksByLy(String lydjh, Integer lyhh);

    Reback<Cgddzhib> BlanksByYt(String ytdjh, Integer ythh);
}
