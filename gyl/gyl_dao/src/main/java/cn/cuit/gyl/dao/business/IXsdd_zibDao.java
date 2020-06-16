package cn.cuit.gyl.dao.business;


import cn.cuit.gyl.domain.business.Xsdd_zib;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//销售订单子表dao
@Repository("iXsdd_zibDao")
public interface IXsdd_zibDao {

    //添加一条信息
    @Insert("insert into xsdd_zib " +
            "(hh,lyhh,spmc,spbm,type,jldw,count,rate,dpkl,wsdj,hsdj,wsje,hsje,se,zke,fhck,shdw,jhfhrq,yqshrq,zp,yfwcksl,ljfhsl,ljcksl,ljkpsl,ljyssl,sffhgb,sfckgb,sfkpgb,sfskgb,status,xsdd_zhub_id) " +
            "values " +
            "(#{hh},#{lyhh},#{spmc},#{spbm},#{type},#{jldw},#{count},#{rate},#{dpkl},#{wsdj},#{hsdj},#{wsje},#{hsje},#{se},#{zke},#{fhck},#{shdw},#{jhfhrq},#{yqshrq},#{zp},#{yfwcksl},#{ljfhsl},#{ljcksl},#{ljkpsl},#{ljyssl},#{sffhgb},#{sfckgb},#{sfkpgb},#{sfskgb},#{status},#{xsdd_zhub_id})")
    void save(Xsdd_zib xsdd_zib) throws Exception;

    //根据主表的id即子表外键来查询所有子表
    @Select("select * from xsdd_zib where xsdd_zhub_id=#{xsdd_zhub_id}")
    List<Xsdd_zib> findByZhubId(Integer xsdd_zhub_id) throws Exception;

    //根据id查询信息
    @Select("select * from xsdd_zib where xsdd_zib_id=#{xsdd_zib_id}")
    Xsdd_zib findById(Integer xsdd_zib_id) throws Exception;

    //根据id更新信息
    @Update("update xsdd_zib set " +
            "hh=#{hh}," +
            "lyhh=#{lyhh}," +
            "spbm=#{spbm}," +
            "spmc=#{spmc}," +
            "type=#{type}," +
            "jldw=#{jldw}," +
            "count=#{count}," +
            "rate=#{rate}," +
            "dpkl=#{dpkl}," +
            "wsdj=#{wsdj}," +
            "hsje=#{hsdj}," +
            "wsje=#{wsje}," +
            "hsje=#{hsje}," +
            "se=#{se}," +
            "zke=#{zke}," +
            "fhck=#{fhck}," +
            "shdw=#{shdw}," +
            "jhfhrq=#{jhfhrq}," +
            "yqshrq=#{yqshrq}," +
            "zp=#{zp}," +
            "yfwcksl=#{yfwcksl}," +
            "ljfhsl=#{ljfhsl}," +
            "ljcksl=#{ljcksl}," +
            "ljkpsl=#{ljkpsl}," +
            "ljyssl=#{ljyssl}," +
            "sffhgb=#{sffhgb}," +
            "sfckgb=#{sfckgb}," +
            "sfkpgb=#{sfkpgb}," +
            "sfskgb=#{sfskgb} where xsdd_zib_id=#{xsdd_zib_id}")
    void updateById(Xsdd_zib xsdd_zib) throws Exception;

    //根据id删除信息
    @Delete("delete from xsdd_zib where xsdd_zib_id=#{xsdd_zib_id}")
    void deleteById(Integer xsdd_zib_id) throws Exception;

    //根据外键主表id查询最大的行号hh
    @Select("select MAX(xsdd_zib.`hh`) from xsdd_zib where xsdd_zhub_id=#{xsdd_zhub_id}")
    Long findMaxHhByZhubId(Integer xsdd_zhub_id) throws Exception;

    //根据主表id和子表行号查询信息
    @Select("select * from xsdd_zib where xsdd_zhub_id=#{xsdd_zhub_id} and hh=#{hh}")
    Xsdd_zib findByZhubIdAndHh(@Param("xsdd_zhub_id") Integer xsdd_zhub_id, @Param("hh") Integer hh) throws Exception;
}
