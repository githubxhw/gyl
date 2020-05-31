package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Cgrkd_zib;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository( )
public interface ICgrkd_zibDao {
    //添加一条信息
    @Insert("insert into cgrkd_zib " +
            "(hh,rkrq,spbm,spmc,type,dw,scrq,sxrq,ydsl,sdsl,dj,je,zp,ytdjh,ythh,lydjh,lyhh,ljrksl,status,cgrkd_zhub_id) " +
            "values (#{hh},#{rkrq},#{spbm},#{spmc},#{type},#{dw},#{scrq},#{sxrq},#{ydsl},#{sdsl},#{dj},#{je},#{zp},#{ytdjh},#{ythh},#{lydjh},#{lyhh},#{ljrksl},#{status},#{cgrkd_zhub_id})")
    void save(Cgrkd_zib cgrkd_zib) throws Exception;

    //根据主表id查询所有的子表信息
    @Select("select * from cgrkd_zib where cgrkd_zhub_id=#{cgrkd_zhub_id}")
    List<Cgrkd_zib> findByZhubId(Integer cgrkd_zhub_id) throws Exception;

    //根据id查询信息
    @Select("select * from cgrkd_zib where cgrkd_zib_id=#{cgrkd_zib_id}")
    Cgrkd_zib findById(Integer cgrkd_zib_id) throws Exception;

    //根据子表id修改所有信息（除了id）
    @Update("update cgrkd_zib set " +
            "hh=#{hh},rkrq=#{rkrq}," +
            "spbm=#{spbm},spmc=#{spmc}," +
            "type=#{type},dw=#{dw}," +
            "scrq=#{scrq},sxrq=#{sxrq}," +
            "ydsl=#{ydsl},sdsl=#{sdsl}," +
            "dj=#{dj},je=#{je}," +
            "zp=#{zp},ytdjh=#{ytdjh}," +
            "ythh=#{ythh},lydjh=#{lydjh}," +
            "lyhh=#{lyhh},ljrksl=#{ljrksl}," +
            "status=#{status},cgrkd_zhub_id=#{cgrkd_zhub_id} " +
            "where cgrkd_zib_id=#{cgrkd_zib_id}")
    void updateById(Cgrkd_zib cgrkd_zib) throws Exception;

    //根据 源头单据号 和 源头行号 查询所有的子表
    @Select("select * from cgrkd_zib where ytdjh=#{ytdjh} and ythh=#{ythh}")
    List<Cgrkd_zib> findByYtdjhAndYthh(@Param("ytdjh") String ytdjh, @Param("ythh") Integer ythh) throws Exception;

    //根据id删除信息
    @Delete("delete from cgrkd_zib where cgrkd_zib_id=#{cgrkd_zib_id}")
    void deleteById(Integer cgrkd_zib_id) throws Exception;

    //根据主表id查询最大行号hh
    @Select("select MAX(cgrkd_zib.`hh`) from cgrkd_zib where cgrkd_zhub_id=#{cgrkd_zhub_id}")
    Integer findMaxHhByZhubId(Integer cgrkd_zhub_id) throws Exception;
}
