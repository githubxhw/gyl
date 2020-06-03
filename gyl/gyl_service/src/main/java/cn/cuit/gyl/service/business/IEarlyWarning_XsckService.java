package cn.cuit.gyl.service.business;

import cn.cuit.gyl.domain.business.EarlyWarning_Xsck;
import cn.cuit.gyl.utils.PageInfo;

import java.util.List;

//销售出库业务层
public interface IEarlyWarning_XsckService {

    //根据单据号和行号查询出库预警信息
    EarlyWarning_Xsck findEWXByDjhAndHh(String ddh,Integer hh) throws Exception;

    //分页查询销售出库预警信息
    List<EarlyWarning_Xsck> findEWXsByPage(Integer pageNum, Integer pageSize) throws Exception;

    //单据预警id查询预警消息
    EarlyWarning_Xsck findEWXById(Long id) throws Exception;

    //更新预警消息
    PageInfo updateEWX(EarlyWarning_Xsck earlyWarning_xsck) throws Exception;

    //查询出最大的id+1
    Long getMaxId() throws Exception;

    //保存一个预警消息
    PageInfo saveEWX(EarlyWarning_Xsck earlyWarning_xsck) throws Exception;

    //根据ids删除预警消息
    void deleteEWXsByIds(String ids) throws Exception;
}
