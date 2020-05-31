package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Cgddzhub;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("cgdddao")
public interface cgdddao {
    @Select("select * from cgzb")
    @Results(id = "cgddzhub",value = {
            @Result(id=true,column = "id",property = "cgddzhubid"),
            @Result(property = "cgddzhibs",column = "id",
                    many = @Many(select = "cn.cuit.gyl.dao.business.cgddzhidao.findByzid",
                            fetchType = FetchType.LAZY)),
    })
    List<Cgddzhub> findAllDd();//寻找所有的订单信息


    @Select({"<script>",
            "select * from cgzb",
            "<where>",
            "<if test='cgddzhubid != null and cgddzhubid != \"\"'> and id = #{cgddzhubid}</if> ",
            "<if test='gs != null and gs != \"\"'> and gs like '%${gs}%'</if> ",
            "<if test='djh != null and djh != \"\"'> and djh like '%${djh}%'</if> ",
            "<if test='gys != null and gys != \"\"'> and gys like '%${gys}%'</if> ",
            "<if test='cgbm != null and cgbm != \"\"'> and cgbm like '%${cgbm}%'</if> ",
            "<if test='cgr != null and cgr != \"\"'> and cgr like '%${cgr}%'</if> ",
            "<if test='isth != null '> and isth =#{isth}</if> ",
            "<if test='jdr != null and jdr != \"\"'> and jdr like '%${jdr}%'</if> ",
            "<if test='ddrq != null '> and ddrq= #{ddrq}</if> ",
            "<if test='status != null'> and status=#{status}</if> ",
            "<if test='bz != null and bz != \"\"'> and bz like '%${bz}%'</if> ",
            "<if test='zdsl != null '> and zdsl =#{zdsl}</if> ",
            "<if test='djzt != null '> and djzt =#{djzt}</if> ",
            "<if test='spr != null and spr != \"\"'> and spr like '%${spr}%'</if> ",
            "<if test='sprq != null '> and sprq =#{sprq}</if> ",
            "<if test='issp != null '> and issp = #{issp}</if> ",
            "<if test='spsftg != null '> and spsftg =#{spsftg}</if> ",
            "<if test='zdr != null and zdr != \"\"'> and zdr like '%${zdr}%'</if> ",
            "<if test='zdrq != null '> and zdrq =#{zdrq}</if> ",
            "<if test='xgr != null and xgr != \"\"'> and xgr like '%${xgr}%'</if> ",
            "<if test='xgrq != null'> and xgrq = #{xgrq}</if> ",
            "<if test='sxrq != null and sxrq != \"\"'> and sxrq like '%${sxrq}%'</if> ",
            "<if test='ywy != null and ywy != \"\"'> and ywy like '%${ywy}%'</if> ",
            "<if test='zdshj != null and zdshj != \"\"'> and zdshj like '%${zdshj}%'</if> ",
            "<if test='dhbz != null '> and dhbz =#{dhbz}</if> ",
            "<if test='rkbz != null '> and rkbz =#{rkbz}</if> ",
            "<if test='kpbz != null '> and kpbz =#{kpbz}</if> ",
            "<if test='kpdw != null and kpdw != \"\"'> and kpdw like '%${kpdw}%'</if> ",
            "<if test='dhdq != null and dhdq != \"\"'> and dhdq like '%${dhdq}%'</if> ",
            "<if test='dhdz != null and dhdz != \"\"'> and dhdz like '%${dhdz}%'</if> ",
            "<if test='ysbz != null '> and ysbz =#{ysbz}</if> ",
            "</where>",
            "</script>"})
    @ResultMap("cgddzhub")
    List<Cgddzhub> findByPage(Cgddzhub searchCgddzhub);//条件加上模糊查询

    @Insert("insert into cgzb(gs,djh,gys,cgbm,cgr,isth,jdr,ddrq,status,bz,zdsl,djzt,spr,sprq,issp,spsftg,zdr,zdrq,xgr,xgrq,sxrq,ywy,zdshj,dhbz,rkbz,kpbz,kpdw,dhdq,dhdz,ysbz )value(#{gs},#{djh},#{gys},#{cgbm},#{cgr},#{isth},#{jdr},#{ddrq},#{status},#{bz},#{zdsl},#{djzt},#{spr},#{sprq},#{issp},#{spsftg},#{zdr},#{zdrq},#{xgr},#{xgrq},#{sxrq},#{ywy},#{zdshj},#{dhbz},#{rkbz},#{kpbz},#{kpdw},#{dhdq},#{dhdz},#{ysbz} )")
    void addCgddzhub(Cgddzhub a);//添加
    @Delete("delete from cgzb where id = #{id}")
    void deleteCgddzhub(Long id);//删除
    @Select("select * from cgzb where id = #{id}")
    @ResultMap("cgddzhub")
    Cgddzhub findById(Long id);//通过id来寻找
    @Select("select * from cgzb where djh = #{id}")
    @ResultMap("cgddzhub")
    Cgddzhub findByDjh(String id);//通过djh寻找
    @Update("update cgzb set gs = #{gs},djh = #{djh},gys = #{gys},cgbm = #{cgbm},cgr = #{cgr},isth = #{isth},jdr = #{jdr},ddrq = #{ddrq},status = #{status},bz = #{bz},zdsl = #{zdsl},djzt = #{djzt} ,spr=#{spr},sprq=#{sprq},issp=#{issp},spsftg=#{spsftg},zdr=#{zdr},zdrq=#{zdrq},xgr=#{xgr},xgrq=#{xgrq},sxrq=#{sxrq},ywy=#{ywy},zdshj=#{zdshj},dhbz=#{dhbz},rkbz=#{rkbz},kpbz=#{kpbz},kpdw=#{kpdw},dhdq=#{dhdq},dhdz=#{dhdz},ysbz=#{ysbz} where id = #{cgddzhubid}")
    void  updateCgddzhub(Cgddzhub a);//更新
}
