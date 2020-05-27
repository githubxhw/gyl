package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Xsydd_zib;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

//销售预订单子表dao

@Repository("iXsydd_zibDao")
public interface IXsydd_zibDao {

    //根据主表id查询所有的子表信息
    @Select("select * from xsydd_zib where xsydd_zhub_id = #{xsydd_zhub_id}")
    List<Xsydd_zib> findXsydd_zibByZhubId(Integer xsydd_zhub_id) throws Exception;

    //根据主表id查询所有的数量
    @Select("select count(*) from xsydd_zib where xsydd_zhub_id = #{zhub_id}")
    Long findCountByZhub_id(Integer zhub_id) throws Exception;

    //添加一个子表信息
    @Insert("insert into xsydd_zib (hh,spmc,spbh,type,jldw,count,rate,dpkl,wsdj,hsdj,wsje,hsje,se,zke,shdw,xsydd_zhub_id) values (#{hh},#{spmc},#{spbh},#{type},#{jldw},#{count},#{rate},#{dpkl},#{wsdj},#{hsje},#{wsje},#{hsje},#{se},#{zke},#{shdw},#{xsydd_zhub_id})")
    void save(Xsydd_zib xsydd_zib) throws Exception;

    //删除一个子表信息
    @Delete("delete from xsydd_zib where xsydd_zib_id = #{xsydd_zib_id}")
    void deleteById(Integer xsydd_zib_id) throws Exception;

    //根据id查询信息
    @Select("select * from xsydd_zib where xsydd_zib_id = #{xsydd_zib_id}")
    Xsydd_zib findById(Integer xsydd_zib_id) throws Exception;

    //根据id修改信息
    @Update("update xsydd_zib set " +
            "hh=#{hh}, " +
            "spmc=#{spmc}, " +
            "spbh=#{spbh}, " +
            "type=#{type}, " +
            "jldw=#{jldw}, " +
            "count=#{count}, " +
            "rate=#{rate}, " +
            "dpkl=#{dpkl}, " +
            "wsdj=#{wsdj}, " +
            "hsdj=#{hsdj}, " +
            "wsje=#{wsje}, " +
            "hsje=#{hsje}, " +
            "se=#{se}, " +
            "zke=#{zke}, " +
            "shdw=#{shdw}, " +
            "xsydd_zhub_id=#{xsydd_zhub_id} " +
            "where xsydd_zib_id=#{xsydd_zib_id}")
    void updateById(Xsydd_zib xsydd_zib) throws Exception;

    //根据主表id查询出最大的hh
    @Select("select MAX(xsydd_zib.`hh`) from xsydd_zib where xsydd_zhub_id=#{zhub_id}")
    Long findMaxOfhh(Integer zhub_id) throws Exception;
}
