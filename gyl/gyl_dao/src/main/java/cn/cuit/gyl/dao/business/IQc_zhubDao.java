package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Qc_zhub;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

//仓库 期初主表
@Repository("iQc_zhubDao")
public interface IQc_zhubDao {

    //根据主表属性值查询所有满足的主表s
    @Select({
            "<script>" +
                    "select * from qc_zhub where 1=1 " +
                    "<if test='djh!=null and djh!=\"\"'>and djh=#{djh} </if>" +
                    "<if test='gs!=null and gs!=\"\"'>and gs=#{gs} </if>" +
                    "<if test='djrq!=null'>and djrq=#{djrq} </if>" +
                    "<if test='ckbm!=null and ckbm!=\"\"'>and ckbm=#{ckbm} </if>" +
                    "<if test='kcy!=null and kcy!=\"\"'>and kcy=#{kcy} </if>" +
                    "<if test='bm!=null and bm!=\"\"'>and bm=#{bm} </if>" +
                    "<if test='zdr!=null and zdr!=\"\"'>and zdr=#{zdr} </if>" +
                    "<if test='zdrq!=null'>and zdrq=#{zdrq} </if>" +
                    "<if test='qzr!=null and qzr!=\"\"'>and qzr=#{qzr}</if>" +
                    "<if test='qzrq!=null'>and qzrq=#{qzrq} </if>" +
                    "<if test='sfsp!=null'>and sfsp=#{sfsp} </if>" +
                    "<if test='spsftg!=null'>and spsftg=#{spsftg} </if>" +
                    "<if test='xgr!=null and xgr!=\"\"'>and xgr=#{xgr} </if>" +
                    "<if test='xgrq!=null'>and xgrq=#{xgrq} </if>" +
                    "<if test='status!=null'>and status=#{status} </if>" +
                    "</script>"
    })
    List<Qc_zhub> findByMany(Qc_zhub qc_zhub1) throws Exception;

    //添加一条主表信息
    @Insert("insert into qc_zhub " +
            "(gs,djh,djrq,ckbm,kcy,bm,zdr,zdrq,qzr,qzrq,sfsp,spsftg,xgr,xgrq,status) " +
            "values " +
            "(#{gs},#{djh},#{djrq},#{ckbm},#{kcy},#{bm},#{zdr},#{zdrq},#{qzr},#{qzrq},#{sfsp},#{spsftg},#{xgr},#{xgrq},#{status})")
    void save(Qc_zhub qc_zhub) throws Exception;

    //根据单据号查询该主表信息
    @Select("select * from qc_zhub where djh=#{djh}")
    Qc_zhub findByDjh(String djh) throws Exception;

    //根据id查询信息
    @Select("select * from qc_zhub where qc_zhub_id=#{qc_zhub_id}")
    Qc_zhub findById(Long qc_zhub_id) throws Exception;

    //根据id更新主表信息
    @Update("update qc_zhub set " +
            "gs=#{gs},djh=#{djh},djrq=#{djrq},ckbm=#{ckbm}," +
            "kcy=#{kcy},bm=#{bm},zdr=#{zdr},zdrq=#{zdrq}," +
            "qzr=#{qzr},qzrq=#{qzrq},sfsp=#{sfsp},spsftg=#{spsftg}," +
            "xgr=#{xgr},xgrq=#{xgrq},status=#{status} " +
            "where qc_zhub_id=#{qc_zhub_id}")
    void updateById(Qc_zhub qc_zhub) throws Exception;

    //根据id删除主表信息
    @Delete("delete from qc_zhub where qc_zhub_id=#{qc_zhub_id}")
    void deleteById(Long qc_zhub_id) throws Exception;
}
