package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Cgdhd_zib;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//销售发货单子表dao接口
@Repository("iCgdhd_zibDao")
public interface ICgdhd_zibDao {

    //添加一条信息
    @Insert("insert into cgdhd_zib " +
            "(hh,dhrq,spbm,spmc,type,dw,scrq,sxrq,ydsl,sdsl,dj,je,zp,ytdjh,ythh,lydjh,lyhh,ljdhsl,sfrkjs,status,cgdhd_zhub_id) " +
            "values (#{hh},#{dhrq},#{spbm},#{spmc},#{type},#{dw},#{scrq},#{sxrq},#{ydsl},#{sdsl},#{dj},#{je},#{zp},#{ytdjh},#{ythh},#{lydjh},#{lyhh},#{ljdhsl},#{sfrkjs},#{status},#{cgdhd_zhub_id})")
    void save(Cgdhd_zib cgdhd_zib) throws Exception;
    @Select("select * from cgdhd_zib")
    List<Cgdhd_zib> getAllOfZib();

    //根据主表id查询所有的子表信息
    @Select("select * from cgdhd_zib where cgdhd_zhub_id=#{cgdhd_zhub_id}")
    List<Cgdhd_zib> findByZhubId(Integer cgdhd_zhub_id) throws Exception;

    //根据id查询信息
    @Select("select * from cgdhd_zib where cgdhd_zib_id=#{cgdhd_zib_id}")
    Cgdhd_zib findById(Integer cgdhd_zib_id) throws Exception;

    //根据子表id修改所有信息（除了id）
    @Update("update cgdhd_zib set " +
            "hh=#{hh},dhrq=#{dhrq}," +
            "spbm=#{spbm},spmc=#{spmc}," +
            "type=#{type},dw=#{dw}," +
            "scrq=#{scrq},sxrq=#{sxrq}," +
            "ydsl=#{ydsl},sdsl=#{sdsl}," +
            "dj=#{dj},je=#{je}," +
            "zp=#{zp},ytdjh=#{ytdjh}," +
            "ythh=#{ythh},lydjh=#{lydjh}," +
            "lyhh=#{lyhh},ljdhsl=#{ljdhsl}," +
            "sfrkjs=#{sfrkjs},"+
            "status=#{status},cgdhd_zhub_id=#{cgdhd_zhub_id} " +
            "where cgdhd_zib_id=#{cgdhd_zib_id}")
    void updateById(Cgdhd_zib cgdhd_zib) throws Exception;

    //根据 源头单据号 和 源头行号 查询所有的子表
    @Select("select * from cgdhd_zib where ytdjh=#{ytdjh} and ythh=#{ythh}")
    List<Cgdhd_zib> findByYtdjhAndYthh(@Param("ytdjh") String ytdjh, @Param("ythh") Integer ythh) throws Exception;

    //根据id删除信息
    @Delete("delete from cgdhd_zib where cgdhd_zib_id=#{cgdhd_zib_id}")
    void deleteById(Integer cgdhd_zib_id) throws Exception;

    //根据主表id查询最大行号hh
    @Select("select MAX(cgdhd_zib.`hh`) from cgdhd_zib where cgdhd_zhub_id=#{cgdhd_zhub_id}")
    Integer findMaxHhByZhubId(Integer cgdhd_zhub_id) throws Exception;

    //根据主表id和行号查询对应子表信息
    @Select("select * from cgdhd_zib where cgdhd_zhub_id=#{cgdhd_zhub_id} and hh=#{hh}")
    Cgdhd_zib findByzhubIdAndHh(@Param("cgdhd_zhub_id") Integer cgdhd_zhub_id, @Param("hh") Integer hh);
}