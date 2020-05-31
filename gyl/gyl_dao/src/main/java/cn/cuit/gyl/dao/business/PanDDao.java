package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Cgddzhub;
import cn.cuit.gyl.domain.business.PanDian;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PanDDao")
public interface PanDDao {
    @Select("select * from pandianzhu")
    @Results(id = "pd",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(property = "panDianZis",column = "id",
                    many = @Many(select = "cn.cuit.gyl.dao.business.PanDZiDao.findByZid",
                            fetchType = FetchType.LAZY)),
    })
    List<PanDian> findAllDd();//查询所有

    @Select({"<script>",
            "select * from pandianzhu",
            "<where>",
            "<if test='id != null'> and id = #{id}</if> ",
            "<if test='gs != null and gs != \"\"'> and gs like '%${gs}%'</if> ",
            "<if test='djh != null and djh != \"\"'> and djh like '%${djh}%'</if> ",
            "<if test='pdrq != null'> and pdrq =#{pdrq}</if> ",
            "<if test='ck != null and ck != \"\"'> and ck like '%${ck}%'</if> ",
            "<if test='kcy != null and kcy != \"\"'> and kcy like '%${kcy}%'</if> ",
            "<if test='bm != null and bm != \"\"'> and bm like '%${bm}%'</if> ",
            "<if test='pdr != null and pdr != \"\"'> and pdr like '%${pdr}%'</if> ",
            "<if test='status != null'> and status=#{status}</if> ",
            "<if test='spr != null and spr != \"\"'> and spr like '%${spr}%'</if> ",
            "<if test='sprq != null '> and sprq =#{sprq}</if> ",
            "<if test='zdr != null and zdr != \"\"'> and zdr like '%${zdr}%'</if> ",
            "<if test='zdrq != null '> and zdrq =#{zdrq}</if> ",
            "<if test='xgr != null and xgr != \"\"'> and xgr like '%${xgr}%'</if> ",
            "<if test='xgrq != null'> and xgrq = #{xgrq}</if> ",
            "<if test='tzr != null and tzr != \"\"'> and tzr like '%${tzr}%'</if> ",
            "<if test='tzrq != null'> and tzrq = #{tzrq}</if> ",
            "</where>",
            "</script>"})
    @ResultMap("pd")
    List<PanDian> findByCondition(PanDian panDian);//条件查询

    @Insert("insert into pandianzhu(gs,djh,pdrq,ck,kcy,bm,pdr,status,zdrq,zdr,spr,sprq,xgr,xgrq,tzr,tzrq)value(#{gs},#{djh},#{pdrq},#{ck},#{kcy},#{bm},#{pdr},#{status},#{zdrq},#{zdr},#{spr},#{sprq},#{xgr},#{xgrq},#{tzr},#{tzrq} )")
    void Add(PanDian a);//增加

    @Delete("delete from pandianzhu where id = #{id}")
    void DeleteById(Long id);//根据ID删除

    @Select("select * from pandianzhu where id = #{id}")
    @ResultMap("pd")
    PanDian FindById(Long id);//根据ID查询

    @Select("select * from pandianzhu where djh = #{id}")
    @ResultMap("pd")
    PanDian FindByDjh(String djh);//根据单据号查询

    @Update("update pandianzhu set gs = #{gs},djh = #{djh},pdrq = #{pdrq},ck = #{ck},kcy = #{kcy},bm = #{bm},pdr = #{pdr},status = #{status},spr=#{spr},sprq=#{sprq},zdr=#{zdr},zdrq=#{zdrq},xgr=#{xgr},xgrq=#{xgrq},tzr = #{tzr},tzrq=#{tzrq} where id = #{id}")
    void Update(PanDian panDian);//修改

}
