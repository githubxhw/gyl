package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Xsydd_zhub;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

//销售预订单主表dao
@Repository("iXsydd_zhubDao")
public interface IXsydd_zhubDao {

    //根据id查询信息
    @Select("select * from xsydd_zhub where xsydd_zhub_id=#{xsydd_zhub_id}")
    Xsydd_zhub findById(Integer xsydd_zhub_id) throws Exception;

    //查询所有的销售预订单主表信息：不必包括子表
    @Select("select * from xsydd_zhub")
    List<Xsydd_zhub> findAll() throws Exception;

    //根据销售预订单的一些信息查询出所有满足要求的所有销售预订单信息
    @Select({
            "<script>" +
                    "select * from xsydd_zhub where 1=1 " +
                    "<if test=' ddh!=null and ddh!=\"\" '>and ddh=#{ddh}</if>" +
                    "<if test=' dhrq!=null '>and dhrq=#{dhrq}</if>" +
                    "<if test=' sxrq!=null '>and sxrq=#{sxrq}</if>" +
                    "<if test=' khmc!=null and khmc!=\"\" '>and khmc=#{khmc}</if>" +
                    "<if test=' xsbm!=null and xsbm!=\"\" '>and xsbm=#{xsbm}</if>" +
                    "<if test='ywy!=null and ywy!=\"\" '>and ywy=#{ywy}</if>" +
                    "<if test='spr!=null and spr!=\"\" '>and spr=#{spr}</if>" +
                    "<if test='sprq!=null'>and sprq=#{sprq}</if>" +
                    "<if test='sfsp!=null'>and sfsp=#{sfsp}</if>" +
                    "<if test='spsftg!=null'>and spsftg=#{spsftg}</if>" +
                    "<if test='zdr!=null and zdr!=\"\" '>and zdr=#{zdr}</if>" +
                    "<if test='zdrq!=null'>and zdrq=#{zdrq}</if>" +
                    "<if test='xgr!=null and xgr!=\"\" '>and xgr=#{xgr}</if>" +
                    "<if test='xgrq!=null'>and xgrq=#{xgrq}</if>" +
                    "<if test='status!=null'>and status=#{status}</if>" +
                    "</script>"
    })
    List<Xsydd_zhub> findByXsydd_zhub(Xsydd_zhub xsydd_zhub) throws Exception;

    //一个销售预订单的信息
    @Insert("insert into xsydd_zhub (ddh,dhrq,sxrq,khmc,xsbm,ywy,spr,sprq,sfsp,spsftg,zdr,zdrq,xgr,xgrq,status) values (#{ddh},#{dhrq},#{sxrq},#{khmc},#{xsbm},#{ywy},#{spr},#{sprq},#{sfsp},#{spsftg},#{zdr},#{zdrq},#{xgr},#{xgrq},#{status})")
    void save(Xsydd_zhub xsydd_zhub) throws Exception;

    //根据id删除主表信息
    @Delete("delete from xsydd_zhub where xsydd_zhub_id=#{xsydd_zhub_id}")
    void deleteById(Integer xsydd_zhub_id) throws Exception;

    //根据id更新所有信息
    @Update("update xsydd_zhub set " +
            "xsydd_zhub.`dhrq`=#{dhrq}," +
            "xsydd_zhub.`sxrq`=#{sxrq}," +
            "xsydd_zhub.`khmc`=#{khmc}," +
            "xsydd_zhub.`xsbm`=#{xsbm}," +
            "xsydd_zhub.`ywy`=#{ywy}," +
            "xsydd_zhub.`spr`=#{spr}," +
            "xsydd_zhub.`sprq`=#{sprq}," +
            "xsydd_zhub.`sfsp`=#{sfsp}," +
            "xsydd_zhub.`spsftg`=#{spsftg}," +
            "xsydd_zhub.`zdr`=#{zdr}," +
            "xsydd_zhub.`zdrq`=#{zdrq}," +
            "xsydd_zhub.`xgr`=#{xgr}," +
            "xsydd_zhub.`xgrq`=#{xgrq}," +
            "xsydd_zhub.`status`=#{status} " +
            "where xsydd_zhub_id=#{xsydd_zhub_id}")
    void updateById(Xsydd_zhub xsydd_zhub) throws Exception;

    //根据ddh查询主表信息
    @Select("select * from xsydd_zhub where ddh=#{ddh}")
    Xsydd_zhub findByDdh(String ddh) throws Exception;

    //根据 sfsp = 0 和其他信息查询信息
    @Select("<script>" +
            "select * from xsydd_zhub where sfsp=0 " +
            "<if test='ddh!=null and ddh!=\"\"'>and ddh=#{ddh}</if>" +
            "<if test='dhrq!=null'>and dhrq=#{dhrq}</if>" +
            "<if test='sxrq!=null'>and sxrq=#{sxrq}</if>" +
            "<if test='khmc!=null and khmc!=\"\"'>and khmc=#{khmc}</if>" +
            "<if test='xsbm!=null and xsbm!=\"\"'>and xsbm=#{xsbm}</if>" +
            "<if test='ywy!=null and ywy!=\"\"'>and ywy=#{ywy}</if>" +
            "<if test='spr!=null and spr!=\"\"'>and spr=#{spr}</if>" +
            "<if test='sprq!=null'>and sprq=#{sprq}</if>" +
            "<if test='spsftg!=null'>and spsftg=#{spsftg}</if>" +
            "<if test='zdr!=null and zdr!=\"\"'>and zdr=#{zdr}</if>" +
            "<if test='zdrq!=null'>and zdrq=#{zdrq}</if>" +
            "<if test='xgr!=null and xgr!=\"\"'>and xgr=#{xgr}</if>" +
            "<if test='xgrq!=null'>and xgrq=#{xgrq}</if>" +
            "<if test='status!=null'>and status=#{status}</if>" +
            "</script>"
    )
    List<Xsydd_zhub> findByAllAndSfspIsZero(Xsydd_zhub xsydd_zhub) throws Exception;
}
