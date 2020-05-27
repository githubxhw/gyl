package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Xskpd_zib;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//销售开票单子表的dao接口
@Repository("iXskpd_zibDao")
public interface IXskpd_zibDao {

    //根据主表id查询信息
    @Select("select * from xskpd_zib where xskpd_zhub_id=#{xskpd_zhub_id}")
    List<Xskpd_zib> findByZhubId(Integer xskpd_zhub_id) throws Exception;

    //添加一条信息
    @Insert("insert into xskpd_zib " +
            "(hh,spbm,spmc,gg,dw,type,count,rate,dpzk,zdzk,fpzk,hsdj,wsdj,hsje,wsje,zke,ytdjh,ythh,lydjh,lyhh,zp,ck,shdw,ljkpsl,ljysksl,sfyskjs,status,xskpd_zhub_id) " +
            "values " +
            "(#{hh},#{spbm},#{spmc},#{gg},#{dw},#{type},#{count},#{rate},#{dpzk},#{zdzk},#{fpzk},#{hsdj},#{wsdj},#{hsje},#{wsje},#{zke},#{ytdjh},#{ythh},#{lydjh},#{lyhh},#{zp},#{ck},#{shdw},#{ljkpsl},#{ljysksl},#{sfyskjs},#{status},#{xskpd_zhub_id})")
    void save(Xskpd_zib xskpd_zib) throws Exception;

    //根据id修改信息
    @Update("update xskpd_zib set " +
            "hh=#{hh},spbm=#{spbm},spmc=#{spmc},gg=#{gg},dw=#{dw},type=#{type}," +
            "count=#{count},rate=#{rate},dpzk=#{dpzk},zdzk=#{zdzk},fpzk=#{fpzk}," +
            "hsdj=#{hsdj},wsdj=#{wsdj},hsje=#{hsje},wsje=#{wsje},zke=#{zke}," +
            "ytdjh=#{ytdjh},ythh=#{ythh},lydjh=#{lydjh},lyhh=#{lyhh},zp=#{zp}," +
            "ck=#{ck},shdw=#{shdw},ljkpsl=#{ljkpsl},ljysksl=#{ljysksl},sfyskjs=#{sfyskjs}," +
            "status=#{status},xskpd_zhub_id=#{xskpd_zhub_id} " +
            "where xskpd_zib_id=#{xskpd_zib_id}")
    void updateById(Xskpd_zib xskpd_zib) throws Exception;

    //根据id查询信息
    @Select("select * from xskpd_zib where xskpd_zib_id=#{xskpd_zib_id}")
    Xskpd_zib findById(Integer xskpd_zib_id) throws Exception;

    //根据主表id查询最大行号hh
    @Select("select MAX(xskpd_zib.`hh`) from xskpd_zib where xskpd_zhub_id=#{xskpd_zhub_id}")
    Integer findMaxHhByZhubId(Integer xskpd_zhub_id) throws Exception;

    //根据id删除信息
    @Delete("delete from xskpd_zib where xskpd_zib_id=#{xskpd_zib_id}")
    void deleteById(Integer xskpd_zib_id) throws Exception;

    @Select("select * from xskpd_zib where lydjh=#{lydjh} and lyhh=#{lyhh}")
    List<Xskpd_zib> findByLydjhAndLyhh(@Param("lydjh") String lydjh,@Param("lyhh") Integer lyhh) throws Exception;
}
