package cn.cuit.gyl.dao.business;


import cn.cuit.gyl.domain.business.Xsdd_zhub;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

//销售订单主表dao
@Repository("iXsdd_zhubDao")
public interface IXsdd_zhubDao {

    //添加一条信息
    @Insert("insert into xsdd_zhub " +
            "(ddh,dhrq,sxrq,khmc,xsbm,ywy,spr,sprq,sfsp,spsftg,zdr,zdrq,xgr,xgrq,zdks,kpdw,shdq,shdz,zdshj,sxkje,lydjh,thbz,fhbz,kpbz,ckbz,ysbz,status) " +
            "values " +
            "(#{ddh},#{dhrq},#{sxrq},#{khmc},#{xsbm},#{ywy},#{spr},#{sprq},#{sfsp},#{spsftg},#{zdr},#{zdrq},#{xgr},#{xgrq},#{zdks},#{kpdw},#{shdq},#{shdz},#{zdshj},#{sxkje},#{lydjh},#{thbz},#{fhbz},#{kpbz},#{ckbz},#{ysbz},#{status})")
    void save(Xsdd_zhub xsdd_zhub) throws Exception;

    //根据订单号ddh查询信息
    @Select("select * from xsdd_zhub where ddh=#{ddh}")
    Xsdd_zhub findByDdh(String ddh) throws Exception;

    //根据有的主表信息进行满足要求查询
    @Select({
            "<script>" +
                    "select * from xsdd_zhub where 1=1 " +
                    "<if test='ddh!=null and ddh!=\"\"'>and ddh=#{ddh}</if>" +
                    "<if test='dhrq!=null'>and dhrq=#{dhrq}</if>" +
                    "<if test='sxrq!=null'>and sxrq=#{sxrq}</if>" +
                    "<if test='khmc!=null and khmc!=\"\"'>and khmc=#{khmc}</if>" +
                    "<if test='xsbm!=null and xsbm!=\"\"'>and xsbm=#{xsbm}</if>" +
                    "<if test='ywy!=null and ywy!=\"\"'>and ywy=#{ywy}</if>" +
                    "<if test='spr!=null and spr!=\"\"'>and spr=#{spr}</if>" +
                    "<if test='sprq!=null'>and sprq=#{sprq}</if>" +
                    "<if test='sfsp!=null'>and sfsp=#{sfsp}</if>" +
                    "<if test='spsftg!=null'>and spsftg=#{spsftg}</if>" +
                    "<if test='zdr!=null and zdr!=\"\"'>and zdr=#{zdr}</if>" +
                    "<if test='zdrq!=null'>and zdrq=#{zdrq}</if>" +
                    "<if test='xgr!=null and xgr!=\"\"'>and xgr=#{xgr}</if>" +
                    "<if test='xgrq!=null'>and xgrq=#{xgrq}</if>" +
                    "<if test='zdks!=null'>and zdks=#{zdks}</if>" +
                    "<if test='kpdw!=null and kpdw!=\"\"'>and kpdw=#{kpdw}</if>" +
                    "<if test='shdq!=null and shdq!=\"\"'>and shdq=#{shdq}</if>" +
                    "<if test='shdz!=null and shdz!=\"\"'>and shdz=#{shdz}</if>" +
                    "<if test='zdshj!=null'>and zdshj=#{zdshj}</if>" +
                    "<if test='sxkje!=null'>and sxkje=#{sxkje}</if>" +
                    "<if test='lydjh!=null and lydjh!=\"\"'>and lydjh=#{lydjh}</if>" +
                    "<if test='thbz!=null'>and thbz=#{thbz}</if>" +
                    "<if test='fhbz!=null'>and fhbz=#{fhbz}</if>" +
                    "<if test='kpbz!=null'>and kpbz=#{kpbz}</if>" +
                    "<if test='ckbz!=null'>and ckbz=#{ckbz}</if>" +
                    "<if test='ysbz!=null'>and ysbz=#{ysbz}</if>" +
                    "<if test='status!=null'>and status=#{status}</if>" +
            "</script>"
    })
    List<Xsdd_zhub> findByAll(Xsdd_zhub xsdd_zhub) throws Exception;

    //根据id查询信息
    @Select("select * from xsdd_zhub where xsdd_zhub_id=#{xsdd_zhub_id}")
    Xsdd_zhub findById(Integer xsdd_zhub_id) throws Exception;

    //根据id更新信息
    @Update("update xsdd_zhub set " +
            "dhrq=#{dhrq}," +
            "sxrq=#{sxrq}," +
            "khmc=#{khmc}," +
            "xsbm=#{xsbm}," +
            "ywy=#{ywy}," +
            "spr=#{spr}," +
            "sprq=#{sprq}," +
            "sfsp=#{sfsp}," +
            "spsftg=#{spsftg}," +
            "zdr=#{zdr}," +
            "zdrq=#{zdrq}," +
            "xgr=#{xgr}," +
            "xgrq=#{xgrq}," +
            "zdks=#{zdks}," +
            "kpdw=#{kpdw}," +
            "shdq=#{shdq}," +
            "shdz=#{shdz}," +
            "zdshj=#{zdshj}," +
            "sxkje=#{sxkje}," +
            "lydjh=#{lydjh}," +
            "thbz=#{thbz}," +
            "fhbz=#{fhbz}," +
            "kpbz=#{kpbz}," +
            "ckbz=#{ckbz}," +
            "ysbz=#{ysbz}," +
            "status=#{status} " +
            "where xsdd_zhub_id=#{xsdd_zhub_id}")
    void updateById(Xsdd_zhub xsdd_zhub) throws Exception;

    //根据id删除信息
    @Delete("delete from xsdd_zhub where xsdd_zhub_id=#{xsdd_zhub_id}")
    void deleteById(Integer xsdd_zhub_id) throws Exception;

    //根据 sfsp = 0 和其他信息查询信息
    @Select("<script>" +
            "select * from xsdd_zhub where sfsp=0 " +
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
            "<if test='zdks!=null'>and zdks=#{zdks}</if>" +
            "<if test='kpdw!=null and kpdw!=\"\"'>and kpdw=#{kpdw}</if>" +
            "<if test='shdq!=null and shdq!=\"\"'>and shdq=#{shdq}</if>" +
            "<if test='shdz!=null and shdz!=\"\"'>and shdz=#{shdz}</if>" +
            "<if test='zdshj!=null'>and zdshj=#{zdshj}</if>" +
            "<if test='sxkje!=null'>and sxkje=#{sxkje}</if>" +
            "<if test='lydjh!=null and lydjh!=\"\"'>and lydjh=#{lydjh}</if>" +
            "<if test='thbz!=null'>and thbz=#{thbz}</if>" +
            "<if test='fhbz!=null'>and fhbz=#{fhbz}</if>" +
            "<if test='kpbz!=null'>and kpbz=#{kpbz}</if>" +
            "<if test='ckbz!=null'>and ckbz=#{ckbz}</if>" +
            "<if test='ysbz!=null'>and ysbz=#{ysbz}</if>" +
            "<if test='status!=null'>and status=#{status}</if>" +
            "</script>"
    )
    List<Xsdd_zhub> findByAllAndSfspIsZero(Xsdd_zhub xsdd_zhub) throws Exception;
}
