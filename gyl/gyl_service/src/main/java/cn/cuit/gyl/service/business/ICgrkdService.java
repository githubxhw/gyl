package cn.cuit.gyl.service.business;



import cn.cuit.gyl.domain.business.Cgrkd_zhub;
import cn.cuit.gyl.domain.business.Cgrkd_zib;
import cn.cuit.gyl.utils.PageInfo;

import java.util.Date;
import java.util.List;

public interface ICgrkdService {
    //功能：在cgrkd-add.jsp中单击保存按钮触发。保存子表和主表信息。
    PageInfo saveZhubAndZib(Cgrkd_zhub cgrkd_zhub) throws Exception;

    //功能：点击cgrkd-query.jsp中的查询按钮触发，根据信息查询满足所有的销售发货单
    List<Cgrkd_zhub> findByCgrkd_zhub(Cgrkd_zhub cgrkd_zhub) throws Exception;

    //功能：点击cgrkd-query.jsp主表中的修改按钮触发，根据主表id查询信息并返回
    Cgrkd_zhub findCgrkd_zhubById(Integer cgrkd_zhub_id) throws Exception;

    //功能：点击cgrkd-query.jsp主表中的模态框修改按钮触发，根据id修改信息
    void updateCgrkd_zhubById(Cgrkd_zhub cgrkd_zhub) throws Exception;

    //功能：点击cgrkd-query.jsp主表中的删除按钮触发，根据主表id删除信息
    void deleteCgrkd_ZhubById(Integer cgrkd_zhub_id) throws Exception;

    //功能：主点击cgrkd-query.jsp主表添加模态框的添加按钮触发，添加主表信息
    void saveCgrkd_zhub(Cgrkd_zhub cgrkd_zhub) throws Exception;

    //功能：主点击cgrkd-query.jsp主表下面的删除按钮触发，根据ids删除信息
    void deleteCgrkd_ZhubByIds(String ids) throws Exception;

    //功能：双击 cgrkd-query.jsp主表中的ddh按钮触发，根据在主表id（外键）查询所有的子表信息
    List<Cgrkd_zib> findCgrkd_zibByZhubId(Integer cgrkd_zhub_id) throws Exception;

    //功能：双击 cgrkd-query.jsp子表中的修改按钮触发，根据子表id进行查询信息
    Cgrkd_zib findCgrkd_zibById(Integer cgrkd_zib_id) throws Exception;

    //功能：双击 cgrkd-query.jsp子表模态框中的修改按钮触发，根据子表id进行修改相关信息（如回写销售订单的数据等等步骤）
    void updateCgrkd_zibById(Cgrkd_zib cgrkd_zib) throws Exception;

    //功能：单击 cgrkd-query.jsp子表中的删除按钮触发，根据子表id删除子表信息
    void deleteCgrkd_ZibById(Integer cgrkd_zib_id) throws Exception;

    //功能：单击 cgrkd-query.jsp子表下面中的删除按钮触发，根据子表ids删除子表信息
    void deleteCgrkd_ZibByIds(String ids) throws Exception;

    //功能：单击cgrkd-query.jsp中子表下面的添加按钮触发,根据主表查询出max行号+1
    Integer getZib_hh(Integer cgrkd_zhub_id) throws Exception;

    //功能：单击cgrkd-query.jsp中子表模态框中的添加按钮触发,保存一个子表
    void saveCgrkd_zib(Cgrkd_zib cgrkd_zib) throws Exception;

    //功能：单击cgrkd-update.jsp中搜索按钮，搜索 未审批的发货单
    List<Cgrkd_zhub> findAllAndSfshIsZero(Cgrkd_zhub cgrkd_zhub) throws Exception;

    //功能：审批禁止功能 ： 单击子表下面的 审批禁止按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 0;
    void spForbidden(String ddh, String spr, Date sprq) throws Exception;

    //功能：审批通过功能 ： 单击子表下面的 审批通过按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 1;
    void spAdopt(String ddh, String spr, Date sprq) throws Exception;

    //功能：单机子表下面的 确认发货按钮，根据ids将选择的所有子表中的status修改为1
    void updateZibStatusByIds(String ids, String xgr, Date xgsj) throws Exception;

    /**
     * 根据源头单据号和源头行号来得到应入库数量和累计入库数量
     * @param ytdjh
     * @param ythh
     * @return
     */
    PageInfo getydsl(String ytdjh, Integer ythh);
}
