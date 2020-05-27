package cn.cuit.gyl.service.business;

import cn.cuit.gyl.domain.business.EarlyWarning_Store;
import cn.cuit.gyl.utils.PageInfo;

import java.util.List;

public interface IEarlyWarning_StoreService {

    //分页查询预警信息
    List<EarlyWarning_Store> findEWSsByPage(Integer pageNum, Integer pageSize) throws Exception;

    //根据仓库id和商品编码查询预警信息
    List<EarlyWarning_Store> findEWSByStoreIdAndProductNum(Integer storeId, String productNum, Integer pageNum, Integer pageSize) throws Exception;

    //根据id查询，并将信息填充到修改modal
    EarlyWarning_Store findEWSByIdToXg_Modal(Long id) throws Exception;

    //根据id修改预警信息
    PageInfo updateEWSById(EarlyWarning_Store earlyWarning_store) throws Exception;

    //获取最大的id+1
    Long getEWSIdToUI() throws Exception;

    //添加一条预警消息记录
    PageInfo saveEWS(EarlyWarning_Store earlyWarning_store) throws Exception;

    //根据ids删除预警信息
    void deleteEWSsByIds(String ids) throws Exception;
}
