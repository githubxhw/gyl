package cn.cuit.gyl.dao.business;


import cn.cuit.gyl.domain.business.Cgfp_zib;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("iCgfp_zibDao")
public interface ICgfp_zibDao {
    //添加一条信息
    @Insert("insert into cgfp_zib " +
            "(hh,chbm,chmc,gg,xh,wsdj,pc,fpsl,je,bz,hsdj,sl,se,wsje,lydjh,lyhh,ytdjd,ythh,status,cgfp_zhub_id,ljfpsl,ykpsl) " +
            "values " +
            "(#{hh},#{chbm},#{chmc},#{gg},#{xh},#{wsdj},#{pc},#{fpsl},#{je},#{bz},#{hsdj},#{sl},#{se},#{wsje},#{lydjh},#{lyhh},#{ytdjd},#{ythh},#{status},#{cgfp_zhub_id},#{ljfpsl},#{ykpsl})")
    void save(Cgfp_zib cgfp_zib) throws Exception;

    //根据主表的id即子表外键来查询所有子表
    @Select("select * from cgfp_zib where cgfp_zhub_id=#{cgfp_zhub_id}")
    List<Cgfp_zib> findByZhubId(Integer cgfp_zhub_id) throws Exception;

    //根据id查询信息
    @Select("select * from cgfp_zib where cgfp_zib_id=#{cgfp_zib_id}")
    Cgfp_zib findById(Integer cgfp_zib_id) throws Exception;

    //根据id更新信息
    @Update("update cgfp_zib set " +
            "hh=#{hh}," +
            "chbm=#{chbm}," +
            "chmc=#{chmc}," +
            "gg=#{gg}," +
            "xh=#{xh}," +
            "wsdj=#{wsdj}," +
            "pc=#{pc}," +
            "fpsl=#{fpsl}," +
            "je=#{je}," +
            "bz=#{bz}," +
            "hsdj=#{hsdj}," +
            "sl=#{sl}," +
            "se=#{se}," +
            "wsje=#{wsje}," +
            "lydjh=#{lydjh}," +
            "lyhh=#{lyhh}," +
            "ytdjd=#{ytdjd}," +
            "ythh=#{ythh},"+
            "ljfpsl=#{ljfpsl},"+
            "ykpsl=#{ykpsl},"+
            "status=#{status} where cgfp_zib_id=#{cgfp_zib_id}")
    void updateById(Cgfp_zib cgfp_zib) throws Exception;

    //根据id删除信息
    @Delete("delete from cgfp_zib where cgfp_zib_id=#{cgfp_zib_id}")
    void deleteById(Integer cgfp_zib_id) throws Exception;

    //根据外键主表id查询最大的行号hh
    @Select("select MAX(cgfp_zib.`hh`) from cgfp_zib where cgfp_zhub_id=#{cgfp_zhub_id}")
    Long findMaxHhByZhubId(Integer cgfp_zhub_id) throws Exception;

    //根据主表id和子表行号查询信息
    @Select("select * from cgfp_zib where cgfp_zhub_id=#{cgfp_zhub_id} and hh=#{hh}")
    Cgfp_zib findByZhubIdAndHh(@Param("cgfp_zhub_id") Integer cgfp_zhub_id, @Param("hh") Integer hh) throws Exception;
}
