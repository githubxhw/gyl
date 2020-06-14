package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Xsfhd_zib;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//销售发货单子表dao接口
@Repository("iXsfhd_zibDao")
public interface IXsfhd_zibDao {

    //添加一条信息
    @Insert("insert into xsfhd_zib " +
            "(hh,fhrq,spbm,spmc,type,dw,scrq,sxrq,yfsl,sfsl,dj,je,zp,ytdjh,ythh,lydjh,lyhh,ljfhsl,ljcksl,ljkpsl,sfckjs,sfkpjs,status,xsfhd_zhub_id) " +
            "values (#{hh},#{fhrq},#{spbm},#{spmc},#{type},#{dw},#{scrq},#{sxrq},#{yfsl},#{sfsl},#{dj},#{je},#{zp},#{ytdjh},#{ythh},#{lydjh},#{lyhh},#{ljfhsl},#{ljcksl},#{ljkpsl},#{sfckjs},#{sfkpjs},#{status},#{xsfhd_zhub_id})")
    void save(Xsfhd_zib xsfhd_zib) throws Exception;

    //根据主表id查询所有的子表信息
    @Select("select * from xsfhd_zib where xsfhd_zhub_id=#{xsfhd_zhub_id}")
    List<Xsfhd_zib> findByZhubId(Integer xsfhd_zhub_id) throws Exception;

    //根据id查询信息
    @Select("select * from xsfhd_zib where xsfhd_zib_id=#{xsfhd_zib_id}")
    Xsfhd_zib findById(Integer xsfhd_zib_id) throws Exception;

    //根据子表id修改所有信息（除了id）
    @Update("update xsfhd_zib set " +
            "hh=#{hh},fhrq=#{fhrq}," +
            "spbm=#{spbm},spmc=#{spmc}," +
            "type=#{type},dw=#{dw}," +
            "scrq=#{scrq},sxrq=#{sxrq}," +
            "yfsl=#{yfsl},sfsl=#{sfsl}," +
            "dj=#{dj},je=#{je}," +
            "zp=#{zp},ytdjh=#{ytdjh}," +
            "ythh=#{ythh},lydjh=#{lydjh}," +
            "lyhh=#{lyhh},ljfhsl=#{ljfhsl},ljkpsl=#{ljkpsl}," +
            "ljcksl=#{ljcksl},sfckjs=#{sfckjs},sfkpjs=#{sfkpjs},"+
            "status=#{status},xsfhd_zhub_id=#{xsfhd_zhub_id} " +
            "where xsfhd_zib_id=#{xsfhd_zib_id}")
    void updateById(Xsfhd_zib xsfhd_zib) throws Exception;

    //根据 源头单据号 和 源头行号 查询所有的子表
    @Select("select * from xsfhd_zib where ytdjh=#{ytdjh} and ythh=#{ythh}")
    List<Xsfhd_zib> findByYtdjhAndYthh(@Param("ytdjh") String ytdjh, @Param("ythh") Integer ythh) throws Exception;

    //根据id删除信息
    @Delete("delete from xsfhd_zib where xsfhd_zib_id=#{xsfhd_zib_id}")
    void deleteById(Integer xsfhd_zib_id) throws Exception;

    //根据主表id查询最大行号hh
    @Select("select MAX(xsfhd_zib.`hh`) from xsfhd_zib where xsfhd_zhub_id=#{xsfhd_zhub_id}")
    Integer findMaxHhByZhubId(Integer xsfhd_zhub_id) throws Exception;

    //根据主表id和行号hh查询一条信息
    @Select("select * from xsfhd_zib where xsfhd_zhub_id=#{xsfhd_zhub_id} and hh=#{hh}")
    Xsfhd_zib findByZhubIdAndHh(@Param("xsfhd_zhub_id") Integer xsfhd_zhub_id, @Param("hh") Integer hh) throws Exception;

    @Select("select * from xsfhd_zib where lydjh=#{lydjh} and lyhh=#{lyhh}")
    List<Xsfhd_zib> findByLydjhAndLyhh(@Param("lydjh") String lydjh, @Param("lyhh") Integer lyhh) throws Exception;
}
