package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Cgdhd_zhub;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

//采购到货单主表dao接口
@Repository("iCgdhd_zhubDao")
public interface ICgdhd_zhubDao {

    //保存一条信息
    @Insert("insert into cgdhd_zhub " +
            "(ddh,dhrq,ck,kgy,bm,kh,zdr,zdsj,spr,spsj,sfsp,spsftg,xgr,xgsj,sfth,sfrkjs,status) " +
            "values " +
            "(#{ddh},#{dhrq},#{ck},#{kgy},#{bm},#{kh},#{zdr},#{zdsj},#{spr},#{spsj},#{sfsp},#{spsftg},#{xgr},#{xgsj},#{sfth},#{sfrkjs},#{status})")
    void save(Cgdhd_zhub cgdhd_zhub) throws Exception;

    //根据订单号ddh查询出销售发货单信息
    @Select("select * from cgdhd_zhub where ddh=#{ddh}")
    Cgdhd_zhub findByDdh(String ddh) throws Exception;

    //根据主表信息查询
    @Select({
            "<script>" +
                    "select * from cgdhd_zhub where 1=1 " +
                    "<if test='ddh!=null and ddh!=\"\"'>and ddh=#{ddh}</if>" +
                    "<if test='dhrq!=null'>and dhrq=#{dhrq}</if>" +
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
                    "<if test='sfrkjs!=null'>and sfrkjs=#{sfrkjs}</if>" +
                    "<if test='status!=null'>and status=#{status}</if>" +
                    "</script>"
    })
    List<Cgdhd_zhub> findByZhub(Cgdhd_zhub cgdhd_zhub) throws Exception;

    //根据id查询信息
    @Select("select * from cgdhd_zhub where cgdhd_zhub_id=#{cgdhd_zhub_id}")
    Cgdhd_zhub findById(Integer cgdhd_zhub_id) throws Exception;

    //根据id更新信息
    @Update("update cgdhd_zhub set " +
            "dhrq=#{dhrq},ck=#{ck},kgy=#{kgy},bm=#{bm},kh=#{kh},zdr=#{zdr},zdsj=#{zdsj},spr=#{spr},spsj=#{spsj},sfsp=#{sfsp},spsftg=#{spsftg},xgr=#{xgr},xgsj=#{xgsj},sfth=#{sfth},sfrkjs=#{sfrkjs},status=#{status} " +
            "where cgdhd_zhub_id=#{cgdhd_zhub_id}")
    void updateById(Cgdhd_zhub cgdhd_zhub) throws Exception;

    //根据id删除信息
    @Delete("delete from cgdhd_zhub where cgdhd_zhub_id=#{cgdhd_zhub_id}")
    void deleteById(Integer cgdhd_zhub_id) throws Exception;

    //根据 sfsp = 0 和其他信息进行查询信息
    @Select({
            "<script>" +
                    "select * from cgdhd_zhub where sfsp=0 " +
                    "<if test='ddh!=null and ddh!=\"\"'>and ddh=#{ddh}</if>" +
                    "<if test='dhrq!=null'>and dhrq=#{dhrq}</if>" +
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
                    "<if test='sfrkjs!=null'>and sfrkjs=#{sfrkjs}</if>" +
                    "<if test='status!=null'>and status=#{status}</if>" +
                    "</script>"
    })
    List<Cgdhd_zhub> findAllAndSfspIsZero(Cgdhd_zhub cgdhd_zhub) throws Exception;
}