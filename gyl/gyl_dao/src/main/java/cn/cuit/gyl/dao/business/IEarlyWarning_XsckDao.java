package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.EarlyWarning_Xsck;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//发货预警表的dao
@Repository("iEarlyWarning_XsfhDao")
public interface IEarlyWarning_XsckDao {

    //查询所有
    @Select("select * from earlywarning_xsfck")
    List<EarlyWarning_Xsck> findAll() throws Exception;
}
