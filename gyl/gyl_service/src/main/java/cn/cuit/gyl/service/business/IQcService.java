package cn.cuit.gyl.service.business;

import cn.cuit.gyl.domain.business.Qc_zhub;
import cn.cuit.gyl.domain.business.Qc_zib;
import cn.cuit.gyl.utils.PageInfo;

import java.util.Date;
import java.util.List;

//仓库期初业务层
public interface IQcService {

    //根据期初主表内容查询满足的所有主表s
    List<Qc_zhub> findZhubByMany(Qc_zhub qc_zhub) throws Exception;

    //根据主表id查询所有的子表s
    List<Qc_zib> findZibsByZhubId(Long qc_zhub_id) throws Exception;

    //保存主表和子表信息，并给出提示信息
    PageInfo saveZhubAndZib(Qc_zhub qc_zhub) throws Exception;

    //根据主表id查询主表信息
    Qc_zhub findZhubByZhuId(Long qc_zhub_id) throws Exception;

    //根据主表id更新主表信息
    void updateZhubByZhubId(Qc_zhub qc_zhub) throws Exception;

    //根据主表id删除主表
    void deleteZhubByZhubId(Long qc_zhub_id) throws Exception;

    //根据主表ids删除主表s
    void deleteZhubsByZhubIds(String ids) throws Exception;

    //根据子表id查询子表信息
    Qc_zib findZibByZibId(Long qc_zib_id) throws Exception;

    //根据子表id更新子表
    void updateZibByZibId(Qc_zib qc_zib) throws Exception;

    //根据子表id删除子表信息
    void deleteZibByZibId(Long qc_zib_id) throws Exception;

    //根据子表ids删除子表s信息
    void deleteZibsByZibIds(String ids) throws Exception;

    //根据主表id，查询子表下面最大的行号+1
    Integer getZibHhByZhubId(Long qc_zhub_id) throws Exception;

    //添加一条子表记录
    void saveZib(Qc_zib qc_zib) throws Exception;

    //功能：审批禁止功能 ： 单击子表下面的 审批禁止按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 0;
    void spForbidden(String djh, String spr, Date sprq) throws Exception;

    //功能：审批通过功能 ： 单击子表下面的 审批通过按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 1;
    void spAdopt(String djh, String spr, Date sprq) throws Exception;

    //查询该单据中的商品在仓库中是否已经存在，返回 0 1
    PageInfo checkProductInStore(String djh) throws Exception;

    /**
     * 该方法功能：确认期初单入库
     * @param djh
     * @throws Exception
     */
    void sureToStore(String djh,String xgr,Date xgrq) throws Exception;


}
