package cn.cuit.gyl.dao.business;


import cn.cuit.gyl.domain.business.Cgddzhub;
import cn.cuit.gyl.domain.business.Cgygdzhub;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CgygDao")
public interface CgygDao {
    @Select("select * from cgqgdzb")
    @Results(id = "cgygzhub",value = {
            @Result(id=true,column = "id",property = "cgqgdzhubid"),
            @Result(property = "cgqgdzhibs",column = "id",
                    many = @Many(select = "cn.cuit.gyl.dao.business.CgygzibDao.findByZid",
                            fetchType = FetchType.LAZY)),
    })
    List<Cgygdzhub> findAllDd();

    @Select({"<script>",
            "select * from cgqgdzb",
            "<where>",
            "<if test='cgqgdzhubid != null and cgqgdzhubid != \"\"'> and id = #{cgqgdzhubid}</if> ",
            "<if test='gs != null and gs != \"\"'> and gs like '%${gs}%'</if> ",
            "<if test='djh != null and djh != \"\"'> and djh like '%${djh}%'</if> ",
            "<if test='qggys != null and qggys != \"\"'> and gys like '%${qggys}%'</if> ",
            "<if test='cgbm != null and cgbm != \"\"'> and cgbm like '%${cgbm}%'</if> ",
            "<if test='cgr != null and cgr != \"\"'> and cgr like '%${cgr}%'</if> ",
            "<if test='qgrq != null '> and qgrq= #{qgrq}</if> ",
            "<if test='status != null '> and status =#{status}</if> ",
            "<if test='bz != null and bz != \"\"'> and bz like '%${bz}%'</if> ",
            "<if test='zdsl != null '> and zdsl =#{zdsl}</if> ",
            "<if test='spr != null and spr != \"\"'> and spr like '%${spr}%'</if> ",
            "<if test='sprq != null '> and sprq =#{sprq}</if> ",
            "<if test='issp != null  '> and issp like '%${issp}%'</if> ",
            "<if test='spsftg != null '> and spsftg like '%${spsftg}%'</if> ",
            "<if test='zdr != null and zdr != \"\"'> and zdr like '%${zdr}%'</if> ",
            "<if test='zdrq != null '> and zdrq =#{zdrq}</if> ",
            "<if test='xgr != null and xgr != \"\"'> and xgr like '%${xgr}%'</if> ",
            "<if test='xgrq != null'> and xgrq = #{xgrq}</if> ",
            "</where>",
            "</script>"})
    @ResultMap("cgygzhub")
    List<Cgygdzhub> findByCondition(Cgygdzhub a);

    @Insert("insert into cgqgdzb(gs,djh,qggys,cgbm,cgr,qgrq,status,bz,zdsl,spr,sprq,issp,spsftg,zdr,zdrq,xgr,xgrq )value(#{gs},#{djh},#{qggys},#{cgbm},#{cgr},#{qgrq},#{status},#{bz},#{zdsl},#{spr},#{sprq},#{issp},#{spsftg},#{zdr},#{zdrq},#{xgr},#{xgrq} )")
    void SaveCgYgd(Cgygdzhub a);

    @Delete("delete from cgqgdzb where id = #{id}")
    void deleteCgYgdZhuB(Long id);

    @Select("select * from cgqgdzb where id = #{id}")
    @ResultMap("cgygzhub")
    Cgygdzhub findById(Long id);

    @Select("select * from cgqgdzb where djh = #{id}")
    @ResultMap("cgygzhub")
    Cgygdzhub findByDjh(String djh);

    @Update("update cgqgdzb set gs = #{gs},djh = #{djh},qggys = #{qggys},cgbm = #{cgbm},cgr = #{cgr},qgrq = #{qgrq},status = #{status},bz = #{bz},zdsl = #{zdsl},spr=#{spr},sprq=#{sprq},issp=#{issp},spsftg=#{spsftg},zdr=#{zdr},zdrq=#{zdrq},xgr=#{xgr},xgrq=#{xgrq} where id = #{cgqgdzhubid}")
    void  updateCgtgdzhub(Cgygdzhub a);
}
