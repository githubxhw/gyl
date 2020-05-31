package cn.cuit.gyl.dao.business;



import cn.cuit.gyl.domain.business.Cgygdzhib;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CgygzibDao")
public interface CgygzibDao {
    @Select("select * from cgqgdzhib where zid = #{h}")
    @Results(id = "Cgygzib",value = {
            @Result(id=true,column = "id",property = "cgqgdzhibid"),

    })
    List<Cgygdzhib> findByZid(Long h);

    @Delete("delete from cgqgdzhib where zid = #{zid}")
    void deleteCgYgdZib(Long zid);

    @Delete("delete from cgqgdzhib where id = #{id}")
    void deleteCgYgdZibById(Long id);

    @Insert("insert into cgqgdzhib(id,hh,spbm,spmc,gg,xh,sl,dw,hsdj,wsdj,shuilv,hsje,wsje,se,zid)value(#{cgqgdzhibid},#{hh},#{spbm},#{spmc},#{gg},#{xh},#{sl},#{dw},#{hsdj},#{wsdj},#{shuilv},#{hsje},#{wsje},#{se},#{zid})")
    void addCgYgdZib(Cgygdzhib a);

    @Select("select * from cgqgdzhib where id = #{id}")
    @ResultMap("Cgygzib")
    Cgygdzhib findById(Long id);

    @Update("update cgqgdzhib set hh=#{hh},spbm=#{spbm},spmc=#{spmc},gg=#{gg},xh=#{xh},sl=#{sl},dw=#{dw},hsdj=#{hsdj},wsdj=#{wsdj},shuilv=#{shuilv},hsje=#{hsje},wsje=#{wsje},se=#{se},zid = #{zid} where id = #{cgqgdzhibid}")
    void  updateCgYgdZib(Cgygdzhib a);

}
