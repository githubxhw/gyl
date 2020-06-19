package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.EarlyWarning_Cgrk;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("IEarlyWarning_CgrkDao")
public interface IEarlyWarning_CgrkDao {
    //查询所有的预警信息
    @Select("select * from earlywarning_cgrk")
    List<EarlyWarning_Cgrk> findAll() throws Exception;

    //根据id查询信息
    @Select("select * from earlywarning_cgrk where id=#{id}")
    EarlyWarning_Cgrk findById(Long id) throws Exception;

    //根据单据号查询信息
    @Select("select * from earlywarning_cgrk where djh=#{djh}")
    EarlyWarning_Cgrk findByDjh(String djh) throws Exception;

    @Select({"<script>",
            "select * from earlywarning_cgrk",
            "<where>",
            "<if test='djh != null and djh != \"\"'> and djh =#{djh}</if> ",
            "<if test='hh != null '> and hh = #{hh}</if> ",
            "</where>",
            "</script>"})
    List<EarlyWarning_Cgrk> findByDjhOrHh(EarlyWarning_Cgrk earlyWarning_cgrk);

    //根据id修改信息
    @Update("update earlywarning_cgrk set " +
            "djh=#{djh},productNum=#{productNum}," +
            "productName=#{productName},hh=#{hh},yqdhrq=#{yqdhrq}," +
            "checkDays=#{checkDays},status=#{status},invalidDays=#{invalidDays} where id=#{id}")
    void updateById(EarlyWarning_Cgrk earlyWarning_cgrk) throws Exception;


    //添加一条预警消息
    @Insert("insert into earlywarning_cgrk " +
            "(djh,hh,productNum,productName,yqdhrq,checkDays,invalidDays,status) " +
            "values (#{djh},#{hh},#{productNum},#{productName},#{yqdhrq},#{checkDays},#{invalidDays},#{status})")
    void save(EarlyWarning_Cgrk earlyWarning_cgrk) throws Exception;

    //根据id删除信息
    @Delete("delete from earlywarning_cgrk where id=#{id}")
    void deleteById(Long id) throws Exception;

    //查询所有status为1的预警
    @Select("select * from earlywarning_cgrk where status = 1")
    List<EarlyWarning_Cgrk> findAllWhereStatusIsTrue() throws Exception;

    //查询所有status=0的采购入库预警s
    @Select("select * from earlywarning_cgrk where status = 0")
    List<EarlyWarning_Cgrk> findAllWhereStatusIsFalse() throws Exception;
}
