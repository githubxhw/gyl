package cn.cuit.gyl.dao.database;

import cn.cuit.gyl.domain.database.kh;
import cn.cuit.gyl.domain.database.pages.SearchKh;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("KhDao")
public interface KhDao {
    @Select("select * from kh")
    List<kh> findAll() throws Exception;//查询所有

    @Select({"<script>",
            "select count(*) from kh",
            "<where>",
            "<if test='kh.name != null and kh.name != \"\"'> and name like '%${kh.name}%'</if> ",
            "<if test='kh.fullname != null and kh.fullname != \"\"'> and fullname like '%${kh.fullname}%'</if> ",
            "<if test='kh.zjm != null and kh.zjm != \"\"'> and zjm like '%${kh.zjm}%'</if> ",
            "<if test='kh.jc != null and kh.jc != \"\"'> and jc like '%${kh.jc}%'</if> ",
            "<if test='kh.dz != null and kh.dz != \"\"'> and dz like '%${kh.dz}%'</if> ",
            "<if test='kh.status != null '> and status = #{kh.status}</if> ",
            "<if test='kh.qy != null and kh.qy != \"\"'> and qy like '%${kh.qy}%'</if> ",
            "<if test='kh.hy != null and kh.hy != \"\"'> and hy like '%${kh.hy}%'</if> ",
            "<if test='kh.lxr != null and kh.lxr != \"\"'> and lxr like '%${kh.lxr}%'</if> ",
            "<if test='kh.dh != null and kh.dh != \"\"'> and dh like '%${kh.dh}%'</if> ",
            "<if test='kh.mdh != null and kh.mdh != \"\"'> and mdh like '%${kh.mdh}%'</if> ",
            "<if test='kh.cz != null and kh.cz != \"\"'> and cz like '%${kh.cz}%'</if> ",
            "<if test='kh.yb != null and kh.yb != \"\"'> and yb like '%${kh.yb}%'</if> ",
            "<if test='kh.email != null and kh.email != \"\"'> and email like '%${kh.email}%'</if> ",
            "<if test='kh.khyh != null and kh.khyh != \"\"'> and khyh like '%${kh.khyh}%'</if> ",
            "<if test='kh.yhzh != null and kh.yhzh != \"\"'> and yhzh like '%${kh.yhzh}%'</if> ",
            "<if test='kh.swdjh != null and kh.swdjh != \"\"'> and swdjh like '%${kh.swdjh}%'</if> ",
            "<if test='kh.sfyygl != null'> and sfyygl = #{kh.sfyygl}</if> ",
            "<if test='kh.xsms != null and kh.xsms != \"\"'> and xsms like '%${kh.xsms}%'</if> ",
            "<if test='kh.zzsl != null'> and zzsl = #{kh.zzsl}</if> ",
            "<if test='kh.city != null and kh.city != \"\"'> and city like '%${kh.city}%'</if> ",
            "<if test='kh.sf != null and kh.sf != \"\"'> and sf like '%${kh.sf}%'</if> ",
            "<if test='kh.gj != null and kh.gj != \"\"'> and gj like '%${kh.gj}%'</if> ",
            "</where>",
            "</script>"})
    int findTotalCount(SearchKh a) throws Exception;//统计查询的个数

    @Select({"<script>",
            "select * from kh",
            "<where>",
            "<if test='kh.id != null'> and id = #{kh.id}</if> ",
            "<if test='kh.name != null and kh.name != \"\"'> and name like '%${kh.name}%'</if> ",
            "<if test='kh.fullname != null and kh.fullname != \"\"'> and fullname like '%${kh.fullname}%'</if> ",
            "<if test='kh.zjm != null and kh.zjm != \"\"'> and zjm like '%${kh.zjm}%'</if> ",
            "<if test='kh.jc != null and kh.jc != \"\"'> and jc like '%${kh.jc}%'</if> ",
            "<if test='kh.dz != null and kh.dz != \"\"'> and dz like '%${kh.dz}%'</if> ",
            "<if test='kh.status != null'> and status = #{kh.status}</if> ",
            "<if test='kh.qy != null and kh.qy != \"\"'> and qy like '%${kh.qy}%'</if> ",
            "<if test='kh.hy != null and kh.hy != \"\"'> and hy like '%${kh.hy}%'</if> ",
            "<if test='kh.lxr != null and kh.lxr != \"\"'> and lxr like '%${kh.lxr}%'</if> ",
            "<if test='kh.dh != null and kh.dh != \"\"'> and dh like '%${kh.dh}%'</if> ",
            "<if test='kh.mdh != null and kh.mdh != \"\"'> and mdh like '%${kh.mdh}%'</if> ",
            "<if test='kh.cz != null and kh.cz != \"\"'> and cz like '%${kh.cz}%'</if> ",
            "<if test='kh.yb != null and kh.yb != \"\"'> and yb like '%${kh.yb}%'</if> ",
            "<if test='kh.email != null and kh.email != \"\"'> and email like '%${kh.email}%'</if> ",
            "<if test='kh.khyh != null and kh.khyh != \"\"'> and khyh like '%${kh.khyh}%'</if> ",
            "<if test='kh.yhzh != null and kh.yhzh != \"\"'> and yhzh like '%${kh.yhzh}%'</if> ",
            "<if test='kh.swdjh != null and kh.swdjh != \"\"'> and swdjh like '%${kh.swdjh}%'</if> ",
            "<if test='kh.sfyygl != null'> and sfyygl = #{kh.sfyygl}</if> ",
            "<if test='kh.xsms != null and kh.xsms != \"\"'> and xsms like '%${kh.xsms}%'</if> ",
            "<if test='kh.zzsl != null'> and zzsl = #{kh.zzsl}</if> ",
            "<if test='kh.city != null and kh.city != \"\"'> and city like '%${kh.city}%'</if> ",
            "<if test='kh.sf != null and kh.sf != \"\"'> and sf like '%${kh.sf}%'</if> ",
            "<if test='kh.gj != null and kh.gj != \"\"'> and gj like '%${kh.gj}%'</if> ",
            "</where>",
            "limit #{start},#{row}",
            "</script>"})
    List<kh> findByCondition(SearchKh a) throws Exception;//条件查询

    @Update("update kh set sfyygl = #{sfyygl},xsms=#{xsms},city=#{city},sf=#{sf},fullname = #{fullname},zjm = #{zjm},jc = #{jc},dz=#{dz},status=#{status},qy=#{qy},hy=#{hy},lxr=#{lxr},dh=#{dh},mdh=#{mdh},cz=#{cz},yb=#{yb},email=#{email},khyh=#{khyh},yhzh=#{yhzh},swdjh=#{swdjh},zzsl=#{zzsl},gj=#{gj} where name=#{name}")
    void Update(kh a) throws Exception;//修改


    @Select("select * from kh where id=#{aa}")
    kh findById(Long id) throws  Exception;//根据ID查询

    @Select("select * from kh where name=#{aa}")
    kh findByName(String name) throws  Exception;//根据名字查询

    @Select("select * from kh where fullname=#{aa}")
    kh findByFullName(String FullName) throws  Exception;//根据全名查询

    @Select("select * from kh where zjm=#{aa}")
    kh findByZjm(String zjm) throws  Exception;//根据助记码查询

    @Delete("delete from kh where name = #{aa}")
    void DeleteByName(String name) throws Exception;//根据名字删除


    @Select("insert into kh (name,fullname,zjm,jc,dz,status,qy,hy,lxr,dh,mdh,cz,yb,email,khyh,yhzh,swdjh,zzsl,gj,sfyygl,xsms,city,sf) values (#{name},#{fullname},#{zjm},#{jc},#{dz},#{status},#{qy},#{hy},#{lxr},#{dh},#{mdh},#{cz},#{yb},#{email},#{khyh},#{yhzh},#{swdjh},#{zzsl},#{gj},#{sfyygl},#{xsms},#{city},#{sf})")
    void Add(kh a)throws Exception;//添加
}
