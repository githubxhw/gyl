package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Xsckd_zib;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//销售出库单子表dao 接口
@Repository("iXsckd_zibDao")
public interface IXsckd_zibDao {

    //根据主表id查询所有子表
    @Select("select * from xsckd_zib where xsckd_zhub_id=#{xsckd_zhub_id}")
    List<Xsckd_zib> findByZhubId(Integer xsckd_zhub_id) throws Exception;

    //添加一条信息
    @Insert("insert into xsckd_zib " +
            "(hh,spbm,spmc,type,dw,scrq,sxrq,yfsl,sfsl,dj,je,ckrq,zp,ytdjh,ythh,lydjh,lyhh,ljcksl,status,xsckd_zhub_id) " +
            "values " +
            "(#{hh},#{spbm},#{spmc},#{type},#{dw},#{scrq},#{sxrq},#{yfsl},#{sfsl},#{dj},#{je},#{ckrq},#{zp},#{ytdjh},#{ythh},#{lydjh},#{lyhh},#{ljcksl},#{status},#{xsckd_zhub_id})")
    void save(Xsckd_zib xsckd_zib) throws Exception;

    //根据id查询信息
    @Select("select * from xsckd_zib where xsckd_zib_id=#{xsckd_zib_id}")
    Xsckd_zib findById(Integer xsckd_zib_id) throws Exception;

    //根据id更新信息
    @Update("update xsckd_zib set " +
            "hh=#{hh},spbm=#{spbm},spmc=#{spmc}," +
            "type=#{type},dw=#{dw},scrq=#{scrq}," +
            "sxrq=#{sxrq},yfsl=#{yfsl},sfsl=#{sfsl}," +
            "dj=#{dj},je=#{je},ckrq=#{ckrq}," +
            "zp=#{zp},ytdjh=#{ytdjh},ythh=#{ythh}," +
            "lydjh=#{lydjh},lyhh=#{lyhh},ljcksl=#{ljcksl}," +
            "status=#{status},xsckd_zhub_id=#{xsckd_zhub_id} " +
            "where xsckd_zib_id=#{xsckd_zib_id}")
    void updateById(Xsckd_zib xsckd_zib) throws Exception;

    @Delete("delete from xsckd_zib where xsckd_zib_id=#{xsckd_zib_id}")
    void deleteById(Integer xsckd_zib_id) throws Exception;

    @Select("select MAX(xsckd_zib.`hh`) from xsckd_zib where xsckd_zhub_id=#{xsckd_zhub_id}")
    Integer findMaxHhByZhubId(Integer xsckd_zhub_id) throws Exception;

    @Select("select * from xsckd_zib where lydjh=#{lydjh} and lyhh=#{lyhh}")
    List<Xsckd_zib> findByLydjhAndLyhh(@Param("lydjh") String lydjh,@Param("lyhh") Integer lyhh) throws Exception;
}
