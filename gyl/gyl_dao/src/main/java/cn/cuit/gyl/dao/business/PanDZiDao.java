package cn.cuit.gyl.dao.business;


import cn.cuit.gyl.domain.business.PanDianZi;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PanDZiDao")
public interface PanDZiDao {
    @Select("select * from pandianzi where zid = #{h}")
    @Results(id = "pdz",value = {
            @Result(id=true,column = "id",property = "id"),

    })
    List<PanDianZi> findByZid(Long h);//根据主ID查询

    @Select("select * from pandianzi where id = #{h}")
    @ResultMap("pdz")
    PanDianZi FindById(Long id);//根据ID查询

    @Select("select * from pandianzi")
    List<PanDianZi> findAll();//查询所有

    @Delete("delete from pandianzi where zid = #{zid}")
    void DeleteByZid(Long zid);//根据主ID删除

    @Delete("delete from pandianzi where id = #{zid}")
    void DeleteById(Long id);//根据ID删除
    @Insert("insert into pandianzi(zid,hh,chbm,gg,xh,dw,pc,scrq,sxrq,zmsl,pdsl,cysl,sslv,tzsl)value(#{zid},#{hh},#{chbm},#{gg},#{xh},#{dw},#{pc},#{scrq},#{sxrq},#{zmsl},#{pdsl},#{cysl},#{sslv},#{tzsl})")
    void Add(PanDianZi panDianZi);//添加

    @Update("update pandianzi set zid = #{zid},hh = #{hh},gg = #{gg},xh = #{xh},dw = #{dw},pc = #{pc},scrq = #{scrq},sxrq = #{sxrq},zmsl=#{zmsl},pdsl=#{pdsl},cysl=#{cysl},tzsl=#{tzsl},sslv=#{sslv} where id = #{id}")
    void Update(PanDianZi panDianZi);//修改
}
