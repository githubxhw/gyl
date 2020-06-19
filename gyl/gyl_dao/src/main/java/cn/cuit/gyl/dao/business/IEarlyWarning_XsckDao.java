package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.EarlyWarning_Xsck;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//发货预警表的dao
@Repository("iEarlyWarning_XsckDao")
public interface IEarlyWarning_XsckDao {

    //查询所有
    @Select("select * from earlywarning_xsck")
    List<EarlyWarning_Xsck> findAll() throws Exception;

    //根据单据号和行号查询预警消息
    @Select("select * from earlywarning_xsck where ddh=#{ddh} and hh=#{hh}")
    EarlyWarning_Xsck findByDjhAndHh(@Param("ddh") String ddh,@Param("hh") Integer hh) throws Exception;

    //根据id查询预警信息
    @Select("select * from earlywarning_xsck where id=#{id}")
    EarlyWarning_Xsck findById(Long id) throws Exception;

    //根据id修改预警消息
    @Update("update earlywarning_xsck set " +
            "ddh=#{ddh},hh=#{hh},productNum=#{productNum},productName=#{productName}," +
            "yqfhrq=#{yqfhrq},checkDays=#{checkDays},invalidDays=#{invalidDays},status=#{status} " +
            "where id=#{id}")
    void updateById(EarlyWarning_Xsck earlyWarning_xsck) throws Exception;

    //查询最大的id
    @Select("select MAX(`id`) from earlywarning_xsck")
    Long findMaxId() throws Exception;

    //添加一条记录有id
    @Insert("insert into earlywarning_xsck " +
            "(id,ddh,hh,productNum,productName,yqfhrq,checkDays,invalidDays,status) " +
            "values " +
            "(#{id},#{ddh},#{hh},#{productNum},#{productName},#{yqfhrq},#{checkDays},#{invalidDays},#{status})")
    void saveEWXHasId(EarlyWarning_Xsck earlyWarning_xsck) throws Exception;

    //根据id删除消息
    @Delete("delete from earlywarning_xsck where id=#{id}")
    void deleteById(Long id) throws Exception;

    //查询所有status为1的预警消息
    @Select("select * from earlywarning_xsck where status=1")
    List<EarlyWarning_Xsck> findAllAndStatusNotClosed() throws Exception;

    //设置status属性为0
    @Update("update earlywarning_xsck set status=0 where id=#{id}")
    void setStatusToZeroById(Long id) throws Exception;

    //添加一条数据没有id
    @Insert("insert into earlywarning_xsck " +
            "(ddh,hh,productNum,productName,yqfhrq,checkDays,invalidDays,status) " +
            "values " +
            "(#{ddh},#{hh},#{productNum},#{productName},#{yqfhrq},#{checkDays},#{invalidDays},#{status})")
    void saveEWXNotHasId(EarlyWarning_Xsck earlyWarning_xsck) throws Exception;

    //查询所有status=0的销售出库预警s
    @Select("select * from earlywarning_xsck where status=0")
    List<EarlyWarning_Xsck> findAllWhereStatusIsFalse() throws Exception;
}
