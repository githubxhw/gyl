package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Cgddzhib;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("cgddzhidao")
public interface cgddzhidao {
    @Select("select * from cgzhib where zid = #{h}")
    @Results(id = "Cgddzhib",value = {
            @Result(id=true,column = "id",property = "cgddzhibid"),

    })
    List<Cgddzhib> findByzid(Long h);//通过主表id来寻找

    @Delete("delete from cgzhib where zid = #{zid}")
    void deleteCgddzhib(Long id);//通过主表id来删除
    @Delete("delete from cgzhib where id = #{id}")
    void deleteCgddzhibByid(Long id);//通过子表id删除
    @Insert("insert into cgzhib(id,hh,spbm,spmc,hgb,gbr,gbrq,gg,xh,sl,dw,hsdj,wsdj,shuilv,hsje,wsje,se,zp,lydj,ljthsl,hstatus,zid,shck,fhdw,jhfhrq,yqshrq,yfwrksl,ljdhsl,ljrksl,ljkpsl,ljyssl,sfdhgb,sfrkgb,sfkpgb,sffkgb)value(#{cgddzhibid},#{hh},#{spbm},#{spmc},#{hgb},#{gbr},#{gbrq},#{gg},#{xh},#{sl},#{dw},#{hsdj},#{wsdj},#{shuilv},#{hsje},#{wsje},#{se},#{zp},#{lydj},#{ljthsl},#{hstatus},#{zid},#{shck},#{fhdw},#{jhfhrq},#{yqshrq},#{yfwrksl},#{ljdhsl},#{ljrksl},#{ljkpsl},#{ljyssl},#{sfdhgb},#{sfrkgb},#{sfkpgb},#{sffkgb})")
    void addCgddzhib(Cgddzhib a);//添加
    @Select("select * from cgzhib where id = #{id}")
    @ResultMap("Cgddzhib")
    Cgddzhib findById(Long id);//通过子表id来查询
    @Select("select * from cgzhib where zid = #{zid} and hh = #{hh}")
    @ResultMap("Cgddzhib")
    Cgddzhib findByZIdAndHh(@Param("zid") long zid, @Param("hh") long hh);//通过主表id和行号来查询
    @Update("update cgzhib set hh=#{hh},spbm=#{spbm},spmc=#{spmc},hgb=#{hgb},gbr=#{gbr},gbrq=#{gbrq},gg=#{gg},xh=#{xh},sl=#{sl},dw=#{dw},hsdj=#{hsdj},wsdj=#{wsdj},shuilv=#{shuilv},hsje=#{hsje},wsje=#{wsje},se=#{se},zp=#{zp},lydj=#{lydj},ljthsl=#{ljthsl},hstatus=#{hstatus} ,zid = #{zid},shck=#{shck},fhdw=#{fhdw},jhfhrq=#{jhfhrq},yqshrq=#{yqshrq},yfwrksl=#{yfwrksl},ljdhsl=#{ljdhsl},ljrksl=#{ljrksl},ljkpsl=#{ljkpsl},ljyssl=#{ljyssl},sfdhgb=#{sfdhgb},sfrkgb=#{sfrkgb},sfkpgb=#{sfkpgb},sffkgb=#{sffkgb} where id = #{cgddzhibid}")
    void  updateCgddzhib(Cgddzhib a);//更新
}
