package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Cgrkd_zhub;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository( )
public interface ICgrkd_zhubDao {
    //保存一条信息
    @Insert("insert into cgrkd_zhub " +
            "(djh,djrq,ck,kgy,bm,kh,zdr,zdrq,spr,shrq,sfsh,shsftg,xgr,xgrq,sfth,status) " +
            "values " +
            "(#{djh},#{djrq},#{ck},#{kgy},#{bm},#{kh},#{zdr},#{zdrq},#{spr},#{shrq},#{sfsh},#{shsftg},#{xgr},#{xgrq},#{sfth},#{status})")
    void save(Cgrkd_zhub cgrkd_zhub) throws Exception;

    //根据订单号djh查询出销售发货单信息
    @Select("select * from cgrkd_zhub where djh=#{djh}")
    Cgrkd_zhub findByDdh(String djh) throws Exception;

    //根据主表信息查询
    @Select({
            "<script>" +
                    "select * from cgrkd_zhub where 1=1 " +
                    "<if test='djh!=null and djh!=\"\"'>and djh=#{djh}</if>" +
                    "<if test='djrq!=null'>and djrq=#{djrq}</if>" +
                    "<if test='ck!=null and ck!=\"\"'>and ck=#{ck}</if>" +
                    "<if test='kgy!=null and kgy!=\"\"'>and kgy=#{kgy}</if>" +
                    "<if test='bm!=null and bm!=\"\"'>and bm=#{bm}</if>" +
                    "<if test='kh!=null and kh!=\"\"'>and kh=#{kh}</if>" +
                    "<if test='zdr!=null and zdr!=\"\"'>and zdr=#{zdr}</if>" +
                    "<if test='zdrq!=null'>and zdrq=#{zdrq}</if>" +
                    "<if test='spr!=null and spr!=\"\"'>and spr=#{spr}</if>" +
                    "<if test='shrq!=null'>and shrq=#{shrq}</if>" +
                    "<if test='sfsh!=null'>and sfsh=#{sfsh}</if>" +
                    "<if test='shsftg!=null'>and shsftg=#{shsftg}</if>" +
                    "<if test='xgr!=null and xgr!=\"\"'>and xgr=#{xgr}</if>" +
                    "<if test='xgrq!=null'>and xgrq=#{xgrq}</if>" +
                    "<if test='sfth!=null'>and sfth=#{sfth}</if>" +
                    "<if test='status!=null'>and status=#{status}</if>" +
                    "</script>"
    })
    List<Cgrkd_zhub> findByZhub(Cgrkd_zhub cgrkd_zhub) throws Exception;

    //根据id查询信息
    @Select("select * from cgrkd_zhub where cgrkd_zhub_id=#{cgrkd_zhub_id}")
    Cgrkd_zhub findById(Integer cgrkd_zhub_id) throws Exception;

    //根据id更新信息
    @Update("update cgrkd_zhub set " +
            "djrq=#{djrq},ck=#{ck},kgy=#{kgy},bm=#{bm},kh=#{kh},zdr=#{zdr},zdrq=#{zdrq},spr=#{spr},shrq=#{shrq},sfsh=#{sfsh},shsftg=#{shsftg},xgr=#{xgr},xgrq=#{xgrq},sfth=#{sfth},status=#{status} " +
            "where cgrkd_zhub_id=#{cgrkd_zhub_id}")
    void updateById(Cgrkd_zhub cgrkd_zhub) throws Exception;

    //根据id删除信息
    @Delete("delete from cgrkd_zhub where cgrkd_zhub_id=#{cgrkd_zhub_id}")
    void deleteById(Integer cgrkd_zhub_id) throws Exception;

    //根据 sfsh = 0 和其他信息进行查询信息
    @Select({
            "<script>" +
                    "select * from cgrkd_zhub where sfsh=0 " +
                    "<if test='djh!=null and djh!=\"\"'>and djh=#{djh}</if>" +
                    "<if test='djrq!=null'>and djrq=#{djrq}</if>" +
                    "<if test='ck!=null and ck!=\"\"'>and ck=#{ck}</if>" +
                    "<if test='kgy!=null and kgy!=\"\"'>and kgy=#{kgy}</if>" +
                    "<if test='bm!=null and bm!=\"\"'>and bm=#{bm}</if>" +
                    "<if test='kh!=null and kh!=\"\"'>and kh=#{kh}</if>" +
                    "<if test='zdr!=null and zdr!=\"\"'>and zdr=#{zdr}</if>" +
                    "<if test='zdrq!=null'>and zdrq=#{zdrq}</if>" +
                    "<if test='spr!=null and spr!=\"\"'>and spr=#{spr}</if>" +
                    "<if test='shrq!=null'>and shrq=#{shrq}</if>" +
                    "<if test='shsftg!=null'>and shsftg=#{shsftg}</if>" +
                    "<if test='xgr!=null and xgr!=\"\"'>and xgr=#{xgr}</if>" +
                    "<if test='xgrq!=null'>and xgrq=#{xgrq}</if>" +
                    "<if test='sfth!=null'>and sfth=#{sfth}</if>" +
                    "<if test='status!=null'>and status=#{status}</if>" +
                    "</script>"
    })
    List<Cgrkd_zhub> findAllAndSfshIsZero(Cgrkd_zhub cgrkd_zhub) throws Exception;
}
