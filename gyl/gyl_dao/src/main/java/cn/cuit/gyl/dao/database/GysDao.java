package cn.cuit.gyl.dao.database;

import cn.cuit.gyl.domain.database.gys;
import cn.cuit.gyl.domain.database.pages.SearchGys;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("GysDao")
public interface GysDao {
    @Select("select * from gys")
    List<gys> findAll() throws Exception;//查询所有

    @Select({"<script>",
            "select count(*) from gys",
            "<where>",
            "<if test='gys.id != null and gys.id != \"\"'> and id = #{gys.id}</if> ",
            "<if test='gys.name != null and gys.name != \"\"'> and name like '%${gys.name}%'</if> ",
            "<if test='gys.fullname != null and gys.fullname != \"\"'> and fullname like '%${gys.fullname}%'</if> ",
            "<if test='gys.zjm != null and gys.zjm != \"\"'> and zjm like '%${gys.zjm}%'</if> ",
            "<if test='gys.jc != null and gys.jc != \"\"'> and jc like '%${gys.jc}%'</if> ",
            "<if test='gys.dz != null and gys.dz != \"\"'> and dz like '%${gys.dz}%'</if> ",
            "<if test='gys.status != null '> and status = #{gys.status}</if> ",
            "<if test='gys.qy != null and gys.qy != \"\"'> and qy like '%${gys.qy}%'</if> ",
            "<if test='gys.hy != null and gys.hy != \"\"'> and hy like '%${gys.hy}%'</if> ",
            "<if test='gys.lxr != null and gys.lxr != \"\"'> and lxr like '%${gys.lxr}%'</if> ",
            "<if test='gys.dh != null and gys.dh != \"\"'> and dh like '%${gys.dh}%'</if> ",
            "<if test='gys.mdh != null and gys.mdh != \"\"'> and mdh like '%${gys.mdh}%'</if> ",
            "<if test='gys.cz != null and gys.cz != \"\"'> and cz like '%${gys.cz}%'</if> ",
            "<if test='gys.yb != null and gys.yb != \"\"'> and yb like '%${gys.yb}%'</if> ",
            "<if test='gys.email != null and gys.email != \"\"'> and email like '%${gys.email}%'</if> ",
            "<if test='gys.khyh != null and gys.khyh != \"\"'> and khyh like '%${gys.khyh}%'</if> ",
            "<if test='gys.yhzh != null and gys.yhzh != \"\"'> and yhzh like '%${gys.yhzh}%'</if> ",
            "<if test='gys.swdjh != null and gys.swdjh != \"\"'> and swdjh like '%${gys.swdjh}%'</if> ",
            "<if test='gys.zzsl != null'> and zzsl = #{gys.zzsl}</if> ",
            "<if test='gys.gj != null and gys.gj != \"\"'> and gj like '%${gys.gj}%'</if> ",
            "</where>",

            "</script>"})
    int findTotalCount(SearchGys a) throws Exception;//统计查询的个数
    @Select({"<script>",
            "select * from gys",
            "<where>",
            "<if test='gys.id != null'> and id = #{gys.id}</if> ",
            "<if test='gys.name != null and gys.name != \"\"'> and name like '%${gys.name}%'</if> ",
            "<if test='gys.fullname != null and gys.fullname != \"\"'> and fullname like '%${gys.fullname}%'</if> ",
            "<if test='gys.zjm != null and gys.zjm != \"\"'> and zjm like '%${gys.zjm}%'</if> ",
            "<if test='gys.jc != null and gys.jc != \"\"'> and jc like '%${gys.jc}%'</if> ",
            "<if test='gys.dz != null and gys.dz != \"\"'> and dz like '%${gys.dz}%'</if> ",
            "<if test='gys.status != null '> and status = #{gys.status}</if> ",
            "<if test='gys.qy != null and gys.qy != \"\"'> and qy like '%${gys.qy}%'</if> ",
            "<if test='gys.hy != null and gys.hy != \"\"'> and hy like '%${gys.hy}%'</if> ",
            "<if test='gys.lxr != null and gys.lxr != \"\"'> and lxr like '%${gys.lxr}%'</if> ",
            "<if test='gys.dh != null and gys.dh != \"\"'> and dh like '%${gys.dh}%'</if> ",
            "<if test='gys.mdh != null and gys.mdh != \"\"'> and mdh like '%${gys.mdh}%'</if> ",
            "<if test='gys.cz != null and gys.cz != \"\"'> and cz like '%${gys.cz}%'</if> ",
            "<if test='gys.yb != null and gys.yb != \"\"'> and yb like '%${gys.yb}%'</if> ",
            "<if test='gys.email != null and gys.email != \"\"'> and email like '%${gys.email}%'</if> ",
            "<if test='gys.khyh != null and gys.khyh != \"\"'> and khyh like '%${gys.khyh}%'</if> ",
            "<if test='gys.yhzh != null and gys.yhzh != \"\"'> and yhzh like '%${gys.yhzh}%'</if> ",
            "<if test='gys.swdjh != null and gys.swdjh != \"\"'> and swdjh like '%${gys.swdjh}%'</if> ",
            "<if test='gys.zzsl != null'> and zzsl = #{gys.zzsl}</if> ",
            "<if test='gys.gj != null and gys.gj != \"\"'> and gj like '%${gys.gj}%'</if> ",
            "</where>",
            "limit #{start},#{row}",
            "</script>"})
    List<gys> findByCondition(SearchGys a) throws Exception;//条件查询

    @Update("update gys set name = #{name},fullname = #{fullname},zjm = #{zjm},jc = #{jc},dz=#{dz},status=#{status},qy=#{qy},hy=#{hy},lxr=#{lxr},dh=#{dh},mdh=#{mdh},cz=#{cz},yb=#{yb},email=#{email},khyh=#{khyh},yhzh=#{yhzh},swdjh=#{swdjh},zzsl=#{zzsl},gj=#{gj} where id=#{id}")
    void Update(gys a) throws Exception;//修改
    @Select("select * from gys where id=#{aa}")
    gys findById(Long id) throws  Exception;//根据ID查询

    @Select("select * from gys where name=#{aa}")
    gys findByName(String name) throws  Exception;//根据名字查询

    @Select("select * from gys where fullname=#{aa}")
    gys findByFullName(String FullName) throws  Exception;//根据全称查询

    @Select("select * from gys where zjm=#{aa}")
    gys findByZjm(String Zjm) throws  Exception;//根据助记码查询

    @Delete("delete from gys where name = #{aa}")
    void DeleteByName(String name) throws Exception;//根据名字删除

    @Delete("delete from gys where id = #{aa}")
    void DeleteById(Long id) throws Exception;//根据ID删除

    @Select("insert into gys (name,fullname,zjm,jc,dz,status,qy,hy,lxr,dh,mdh,cz,yb,email,khyh,yhzh,swdjh,zzsl,gj) values (#{name},#{fullname},#{zjm},#{jc},#{dz},#{status},#{qy},#{hy},#{lxr},#{dh},#{mdh},#{cz},#{yb},#{email},#{khyh},#{yhzh},#{swdjh},#{zzsl},#{gj})")
    void Add(gys a)throws Exception;//添加
}
