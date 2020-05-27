package cn.cuit.gyl.service.business;

import cn.cuit.gyl.domain.business.EarlyWarning_Xsck;

import java.util.List;

//销售出库业务层
public interface IEarlyWarning_XsckService {

    //分页查询销售出库预警
    List<EarlyWarning_Xsck> findEWXsByPage(Integer pageNum, Integer pageSize) throws Exception;
}
