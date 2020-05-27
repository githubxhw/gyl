package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Xsfhd_zhub;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

//销售发货单主表dao接口
@Repository("iXsfhd_zhubDao")
public interface IXsfhd_zhubDao {

    //保存一条信息
    @Insert("insert into xsfhd_zhub " +
            "(ddh,fhrq,ck,kgy,bm,kh,zdr,zdsj,spr,spsj,sfsp,spsftg,xgr,xgsj,sfth,sfckjs,sfkpjs,status) " +
            "values " +
            "(#{ddh},#{fhrq},#{ck},#{kgy},#{bm},#{kh},#{zdr},#{zdsj},#{spr},#{spsj},#{sfsp},#{spsftg},#{xgr},#{xgsj},#{sfth},#{sfckjs},#{sfkpjs},#{status})")
    void save(Xsfhd_zhub xsfhd_zhub) throws Exception;

    //根据订单号ddh查询出销售发货单信息
    @Select("select * from xsfhd_zhub where ddh=#{ddh}")
    Xsfhd_zhub findByDdh(String ddh) throws Exception;

    //根据主表信息查询
    @Select({
            "<script>" +
                    "select * from xsfhd_zhub where 1=1 " +
                    "<if test='ddh!=null and ddh!=\"\"'>and ddh=#{ddh}</if>" +
                    "<if test='fhrq!=null'>and fhrq=#{fhrq}</if>" +
                    "<if test='ck!=null and ck!=\"\"'>and ck=#{ck}</if>" +
                    "<if test='kgy!=null and kgy!=\"\"'>and kgy=#{kgy}</if>" +
                    "<if test='bm!=null and bm!=\"\"'>and bm=#{bm}</if>" +
                    "<if test='kh!=null and kh!=\"\"'>and kh=#{kh}</if>" +
                    "<if test='zdr!=null and zdr!=\"\"'>and zdr=#{zdr}</if>" +
                    "<if test='zdsj!=null'>and zdsj=#{zdsj}</if>" +
                    "<if test='spr!=null and spr!=\"\"'>and spr=#{spr}</if>" +
                    "<if test='spsj!=null'>and spsj=#{spsj}</if>" +
                    "<if test='sfsp!=null'>and sfsp=#{sfsp}</if>" +
                    "<if test='spsftg!=null'>and spsftg=#{spsftg}</if>" +
                    "<if test='xgr!=null and xgr!=\"\"'>and xgr=#{xgr}</if>" +
                    "<if test='xgsj!=null'>and xgsj=#{xgsj}</if>" +
                    "<if test='sfth!=null'>and sfth=#{sfth}</if>" +
                    "<if test='sfckjs!=null'>and sfckjs=#{sfckjs}</if>" +
                    "<if test='sfkpjs!=null'>and sfkpjs=#{sfkpjs}</if>" +
                    "<if test='status!=null'>and status=#{status}</if>" +
                    "</script>"
    })
    List<Xsfhd_zhub> findByZhub(Xsfhd_zhub xsfhd_zhub) throws Exception;

    //根据id查询信息
    @Select("select * from xsfhd_zhub where xsfhd_zhub_id=#{xsfhd_zhub_id}")
    Xsfhd_zhub findById(Integer xsfhd_zhub_id) throws Exception;

    //根据id更新信息
    @Update("update xsfhd_zhub set " +
            "fhrq=#{fhrq},ck=#{ck},kgy=#{kgy},bm=#{bm},kh=#{kh},zdr=#{zdr},zdsj=#{zdsj},spr=#{spr},spsj=#{spsj},sfsp=#{sfsp},spsftg=#{spsftg},xgr=#{xgr},xgsj=#{xgsj},sfth=#{sfth},sfckjs=#{sfckjs},sfkpjs=#{sfkpjs},status=#{status} " +
            "where xsfhd_zhub_id=#{xsfhd_zhub_id}")
    void updateById(Xsfhd_zhub xsfhd_zhub) throws Exception;

    //根据id删除信息
    @Delete("delete from xsfhd_zhub where xsfhd_zhub_id=#{xsfhd_zhub_id}")
    void deleteById(Integer xsfhd_zhub_id) throws Exception;

    //根据 sfsp = 0 和其他信息进行查询信息
    @Select({
            "<script>" +
                    "select * from xsfhd_zhub where sfsp=0 " +
                    "<if test='ddh!=null and ddh!=\"\"'>and ddh=#{ddh}</if>" +
                    "<if test='fhrq!=null'>and fhrq=#{fhrq}</if>" +
                    "<if test='ck!=null and ck!=\"\"'>and ck=#{ck}</if>" +
                    "<if test='kgy!=null and kgy!=\"\"'>and kgy=#{kgy}</if>" +
                    "<if test='bm!=null and bm!=\"\"'>and bm=#{bm}</if>" +
                    "<if test='kh!=null and kh!=\"\"'>and kh=#{kh}</if>" +
                    "<if test='zdr!=null and zdr!=\"\"'>and zdr=#{zdr}</if>" +
                    "<if test='zdsj!=null'>and zdsj=#{zdsj}</if>" +
                    "<if test='spr!=null and spr!=\"\"'>and spr=#{spr}</if>" +
                    "<if test='spsj!=null'>and spsj=#{spsj}</if>" +
                    "<if test='spsftg!=null'>and spsftg=#{spsftg}</if>" +
                    "<if test='xgr!=null and xgr!=\"\"'>and xgr=#{xgr}</if>" +
                    "<if test='xgsj!=null'>and xgsj=#{xgsj}</if>" +
                    "<if test='sfth!=null'>and sfth=#{sfth}</if>" +
                    "<if test='sfckjs!=null'>and sfckjs=#{sfckjs}</if>" +
                    "<if test='sfkpjs!=null'>and sfkpjs=#{sfkpjs}</if>" +
                    "<if test='status!=null'>and status=#{status}</if>" +
                    "</script>"
    })
    List<Xsfhd_zhub> findAllAndSfspIsZero(Xsfhd_zhub xsfhd_zhub) throws Exception;
}
