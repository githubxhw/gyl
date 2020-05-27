package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Xsckd_zhub;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

////销售出库单主表dao 接口
@Repository("iXsckd_zhubDao")
public interface IXsckd_zhubDao {

    //根据主表信息查询满足的所有主表
    @Select({
            "<script>" +
                    "select * from xsckd_zhub where 1=1 " +
                    "<if test='djh!=null and djh!=\"\"'>and djh=#{djh} </if>" +
                    "<if test='djrq!=null'>and djrq=#{djrq} </if>" +
                    "<if test='ck!=null and ck!=\"\"'>and ck=#{ck} </if>" +
                    "<if test='kgy!=null and kgy!=\"\"'>and kgy=#{kgy} </if>" +
                    "<if test='bm!=null and bm!=\"\"'>and bm=#{bm} </if>" +
                    "<if test='kh!=null and kh!=\"\"'>and kh=#{kh} </if>" +
                    "<if test='zdr!=null and zdr!=\"\"'>and zdr=#{zdr} </if>" +
                    "<if test='zdrq!=null'>and zdrq=#{zdrq} </if>" +
                    "<if test='spr!=null and spr!=\"\"'>and spr=#{spr}</if>" +
                    "<if test='shrq!=null'>and shrq=#{shrq} </if>" +
                    "<if test='sfsh!=null'>and sfsh=#{sfsh} </if>" +
                    "<if test='shsftg!=null'>and shsftg=#{shsftg} </if>" +
                    "<if test='xgr!=null and xgr!=\"\"'>and xgr=#{xgr} </if>" +
                    "<if test='xgrq!=null'>and xgrq=#{xgrq} </if>" +
                    "<if test='sfth!=null'>and sfth=#{sfth} </if>" +
                    "<if test='status!=null'>and status=#{status} </if>" +
                    "</script>"
    })
    List<Xsckd_zhub> findByMany(Xsckd_zhub xsckd_zhub) throws Exception;

    //添加一条信息
    @Insert("insert into xsckd_zhub " +
            "(djh,djrq,ck,kgy,bm,kh,zdr,zdrq,spr,shrq,sfsh,shsftg,xgr,xgrq,sfth,status) " +
            "values " +
            "(#{djh},#{djrq},#{ck},#{kgy},#{bm},#{kh},#{zdr},#{zdrq},#{spr},#{shrq},#{sfsh},#{shsftg},#{xgr},#{xgrq},#{sfth},#{status})")
    void save(Xsckd_zhub xsckd_zhub) throws Exception;

    //根据单据号djh查询信息
    @Select("select * from xsckd_zhub where djh=#{djh}")
    Xsckd_zhub findByDjh(String djh) throws Exception;

    //查询没有审批 和其它主表信息 的所有主表信息
    @Select({"<script>" +
            "select * from xsckd_zhub where sfsh=0 " +
            "<if test='djh!=null and djh!=\"\"'>and djh=#{djh} </if>" +
            "<if test='djrq!=null'>and djrq=#{djrq} </if>" +
            "<if test='ck!=null and ck!=\"\"'>and ck=#{ck} </if>" +
            "<if test='kgy!=null and kgy!=\"\"'>and kgy=#{kgy} </if>" +
            "<if test='bm!=null and bm!=\"\"'>and bm=#{bm} </if>" +
            "<if test='kh!=null and kh!=\"\"'>and kh=#{kh} </if>" +
            "<if test='zdr!=null and zdr!=\"\"'>and zdr=#{zdr} </if>" +
            "<if test='zdrq!=null'>and zdrq=#{zdrq} </if>" +
            "<if test='spr!=null and spr!=\"\"'>and spr=#{spr}</if>" +
            "<if test='shrq!=null'>and shrq=#{shrq} </if>" +
            "<if test='shsftg!=null'>and shsftg=#{shsftg} </if>" +
            "<if test='xgr!=null and xgr!=\"\"'>and xgr=#{xgr} </if>" +
            "<if test='xgrq!=null'>and xgrq=#{xgrq} </if>" +
            "<if test='sfth!=null'>and sfth=#{sfth} </if>" +
            "<if test='status!=null'>and status=#{status} </if>" +
            "</script>"
    })
    List<Xsckd_zhub> findAllAndNotSh(Xsckd_zhub xsckd_zhub) throws Exception;

    //根据id查询信息
    @Select("select * from xsckd_zhub where xsckd_zhub_id=#{xsckd_zhub_id}")
    Xsckd_zhub findById(Integer xsckd_zhub_id) throws Exception;

    //根据id更新信息
    @Update("update xsckd_zhub set " +
            "djh=#{djh},djrq=#{djrq},ck=#{ck}," +
            "kgy=#{kgy},bm=#{bm},kh=#{kh}," +
            "zdr=#{zdr},zdrq=#{zdrq},spr=#{spr}," +
            "shrq=#{shrq},sfsh=#{sfsh},shsftg=#{shsftg}," +
            "xgr=#{xgr},xgrq=#{xgrq},sfth=#{sfth}," +
            "status=#{status} " +
            "where xsckd_zhub_id=#{xsckd_zhub_id}")
    void updateById(Xsckd_zhub xsckd_zhub) throws Exception;

    @Delete("delete from xsckd_zhub where xsckd_zhub_id=#{xsckd_zhub_id}")
    void deleteById(Integer xsckd_zhub_id) throws Exception;
}
