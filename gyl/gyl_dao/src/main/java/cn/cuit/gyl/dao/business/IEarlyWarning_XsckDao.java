package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.EarlyWarning_Xsck;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//发货预警表的dao
@Repository("iEarlyWarning_XsfhDao")
public interface IEarlyWarning_XsckDao {

    //查询所有
    @Select("select * from earlywarning_xsfck")
    List<EarlyWarning_Xsck> findAll() throws Exception;

    //根据单据号和行号查询预警消息
    @Select("select * from earlywarning_xsfck where ddh=#{ddh} and hh=#{hh}")
    EarlyWarning_Xsck findByDjhAndHh(@Param("ddh") String ddh,@Param("hh") Integer hh) throws Exception;

    //根据id查询预警信息
    @Select("select * from earlywarning_xsfck where id=#{id}")
    EarlyWarning_Xsck findById(Long id) throws Exception;

    //根据id修改预警消息
    @Update("update earlywarning_xsfck set " +
            "ddh=#{ddh},hh=#{hh},productNum=#{productNum},productName=#{productName}," +
            "yqfhrq=#{yqfhrq},checkDays=#{checkDays},invalidDays=#{invalidDays},status=#{status} " +
            "where id=#{id}")
    void updateById(EarlyWarning_Xsck earlyWarning_xsck) throws Exception;

    //查询最大的id
    @Select("select MAX(`id`) from earlywarning_xsfck")
    Long findMaxId() throws Exception;

    //添加一条记录
    @Insert("insert into earlywarning_xsfck " +
            "(id,ddh,hh,productNum,productName,yqfhrq,checkDays,invalidDays,status) " +
            "values " +
            "(#{id},#{ddh},#{hh},#{productNum},#{productName},#{yqfhrq},#{checkDays},#{invalidDays},#{status})")
    void saveEWXHasId(EarlyWarning_Xsck earlyWarning_xsck) throws Exception;

    //根据id删除消息
    @Delete("delete from earlywarning_xsfck where id=#{id}")
    void deleteById(Long id) throws Exception;
}
