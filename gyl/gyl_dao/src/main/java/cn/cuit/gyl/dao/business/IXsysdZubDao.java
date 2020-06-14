package cn.cuit.gyl.dao.business;


import cn.cuit.gyl.domain.business.Xsysdzhub;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("iXsysdZubDao")
public interface IXsysdZubDao {
    //添加一条信息
    @Insert("insert into xsysd_zhub " +
            "(ddh,gs,rq,qsrq,ks,bm,ywy,sxbz,zdr,zdrq,sher,shrq,qzr,qzrq,xgr,xgrq) " +
            "values " +
            "(#{ddh},#{gs},#{rq},#{qsrq},#{ks},#{bm},#{ywy},#{sxbz},#{zdr},#{zdrq},#{sher},#{shrq},#{qzr},#{qzrq},#{xgr},#{xgrq})")
    void save(Xsysdzhub xsysdzhub) throws Exception;

    //根据订单号ddh查询信息
    @Select("select * from xsysd_zhub where ddh=#{ddh}")
    Xsysdzhub findByDdh(String ddh) throws Exception;

    //根据有的主表信息进行满足要求查询
    @Select({
            "<script>" +
                    "select * from xsysd_zhub where 1=1 " +
                    "<if test='ddh!=null and ddh!=\"\"'>and ddh=#{ddh}</if>" +
                    "<if test='gs!=null and gs!=\"\"'>and gs like '%${gs}%'</if>" +
                    "<if test='rq!=null'>and rq=#{rq}</if>" +
                    "<if test='qsrq!=null'>and qsrq=#{qsrq}</if>" +
                    "<if test='ks!=null and ks!=\"\"'>and ks like '%${ks}%'</if>" +
                    "<if test='bm!=null and bm!=\"\"'>and bm like '%${bm}%'</if>" +
                    "<if test='ywy!=null and ywy!=\"\"'>and ywy like '%${ywy}%'</if>" +
                    "<if test='sxbz!=null '>and sxbz = #{sxbz}</if>" +
                    "<if test='zdr!=null and zdr!=\"\"'>and zdr=#{zdr}</if>" +
                    "<if test='zdrq!=null'>and zdrq=#{zdrq}</if>" +
                    "<if test='sher !=null and sher != \"\"'>and sher=#{sher}</if>" +
                    "<if test='shrq!=null'>and shrq=#{shrq}</if>" +
                    "<if test='qzr!=null and qzr!=\"\"'>and qzr=#{qzr}</if>" +
                    "<if test='qzrq!=null'>and qzrq=#{qzrq}</if>" +
                    "<if test='xgr!=null and xgr!=\"\"'>and xgr=#{xgr}</if>" +
                    "<if test='xgrq!=null'>and xgrq=#{xgrq}</if>" +
                    "</script>"
    })
    List<Xsysdzhub> findByAll(Xsysdzhub xsysdzhub) throws Exception;

    //根据id查询信息
    @Select("select * from xsysd_zhub where xsysdzhubid=#{xsdd_zhub_id}")
    @Results(id = "xsysdzhub",value = {
            @Result(id=true,column = "xsysdzhubid",property = "xsysdzhubid"),
            @Result(property = "xsysdzhibs",column = "xsysdzhubid",
                    many = @Many(select = "cn.cuit.gyl.dao.business.IXsysdZhibDao.findByZid",
                            fetchType = FetchType.LAZY)),
    })
    Xsysdzhub findById(Long xsysdzhub_id) throws Exception;

    //根据id更新信息
    @Update("update xsysd_zhub set " +
            "ddh=#{ddh}," +
            "gs=#{gs}," +
            "rq=#{rq}," +
            "qsrq=#{qsrq}," +
            "ywy=#{ywy}," +
            "ks=#{ks}," +
            "bm=#{bm}," +
            "sxbz=#{sxbz}," +
            "zdr=#{zdr}," +
            "zdrq=#{zdrq}," +
            "xgr=#{xgr}," +
            "xgrq=#{xgrq}," +
            "sher=#{sher}," +
            "shrq=#{shrq}," +
            "qzr=#{qzr}," +
            "qzrq=#{qzrq} " +
            "where xsysdzhubid = #{xsysdzhubid}")
    void updateById(Xsysdzhub xsysdzhub) throws Exception;

    //根据id删除信息
    @Delete("delete from xsysd_zhub where xsysdzhubid=#{xsysdzhubid}")
    void deleteById(Long xsysd_zhub_id) throws Exception;

}

