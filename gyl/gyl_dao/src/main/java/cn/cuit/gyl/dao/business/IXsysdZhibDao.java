package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Xsysdzhib;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("iXsysdZhibDao")
public interface IXsysdZhibDao {
    @Select("select * from xsysd_zhib where zid = #{h}")
    @Results(id = "xsysdzhib",value = {
            @Result(id=true,column = "xsysdzhibid",property = "xsysdzhibid"),

    })
    List<Xsysdzhib> findByZid(Long zid);//通过主表id来寻找

    @Select("select * from xsysd_zhib where xsysdzhibid = #{h}")
    Xsysdzhib findById(Long id);//通过主表id来寻找

    @Delete("delete from xsysd_zhib where zid = #{zid}")
    void deleteByZid(Long zid);//通过主表id来删除
    @Delete("delete from xsysd_zhib where xsysdzhibid = #{id}")
    void deleteById(Long id);//通过子表id删除
    //根据id更新信息
    @Update("update xsysd_zhib set " +
            "sl=#{sl}," +
            "hh=#{hh}," +
            "spmc=#{spmc}," +
            "spbm=#{spbm}," +
            "dw=#{dw}," +
            "hsje=#{hsje}," +
            "se=#{se}," +
            "wsje=#{wsje}," +
            "lydjh=#{lydjh}," +
            "lyhh=#{lyhh}," +
            "ytdjh=#{ytdjh}," +
            "ythh=#{ythh}," +
            "zid=#{zid}," +
            "dj=#{dj}," +
            "ljyssl=#{ljyssl}," +
            "isysgb=#{isysgb} " +
            "where xsysdzhibid = #{xsysdzhibid}")
    void updateById(Xsysdzhib xsysdzhib) throws Exception;

    @Insert("insert into xsysd_zhib " +
            "(sl,hh,spmc,spbm,dw,hsje,se,wsje,lydjh,lyhh,ytdjh,ythh,dj,ljyssl,isysgb,zid) " +
            "values " +
            "(#{sl},#{hh},#{spmc},#{spbm},#{dw},#{hsje},#{se},#{wsje},#{lydjh},#{lyhh},#{ytdjh},#{ythh},#{dj},#{ljyssl},#{isysgb},#{zid})")
    void save(Xsysdzhib xsysdzhib) throws Exception;//添加
}
