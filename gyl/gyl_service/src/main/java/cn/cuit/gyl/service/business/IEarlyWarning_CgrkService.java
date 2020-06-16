package cn.cuit.gyl.service.business;

import cn.cuit.gyl.domain.business.Cgddzhib;
import cn.cuit.gyl.domain.business.EarlyWarning_Cgrk;
import cn.cuit.gyl.utils.PageInfo;

import java.util.List;

public interface IEarlyWarning_CgrkService {

    //分页查询预警信息
    List<EarlyWarning_Cgrk> findEWckByPage(Integer pageNum, Integer pageSize) throws Exception;

    //根据ID来查询预警信息
    EarlyWarning_Cgrk findEWckById(Long id) throws Exception;

    //根据Djh来查询预警信息
    EarlyWarning_Cgrk findEWckByDjh(String djh) throws Exception;

    //分页查询预警信息
    List<EarlyWarning_Cgrk> findEWckByDjhOrHH(String djh, Long hh, Integer pageNum, Integer pageSize) throws Exception;

    //修改预警信息
    PageInfo updateEWck(EarlyWarning_Cgrk earlyWarning_cgrk) throws Exception;

    //添加预警的信息
    PageInfo SaveEWc(EarlyWarning_Cgrk earlyWarning_cgrk) throws Exception;

    //删除预警的信息
    void deleteEWcById(Long id) throws Exception;

    //批量的删除预警的信息
    void deleteEWcsByIds(String ids) throws Exception;

    //得到最大的ID
    Long getEWCIdToUI() throws Exception;

    //检查单据号
    PageInfo CheckDjh(String djh) throws Exception;

    //检查行号
    PageInfo CheckHh(String djh, Long hh) throws Exception;

    //填充商品编码 名字 要求的到货日期
    Cgddzhib PutValue(String djh, Long hh) throws Exception;
}
