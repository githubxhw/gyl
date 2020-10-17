package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Cgyfd_zhub;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository( )
public interface ICgyfd_zhubDao {

    @Insert("INSERT INTO cgyfd_zhub "+
            "(djh, gs, rq, qsrq, ks, bm, ywy, sxbz, zdr, zdsj, spr, spsj, qzr, qzsj, xgr, xgsj) " +
            "values (#{djh}, #{gs}, #{rq}, #{qsrq}, #{ks}, #{bm}, #{ywy}, #{sxbz}, #{zdr}, #{zdsj}, #{spr}, #{spsj}, #{qzr}, #{qzsj}, #{xgr}, #{xgsj})")
    void save(Cgyfd_zhub cgyfdZhub);

    @Select("SELECT * FROM cgyfd_zhub where djh = #{djh}")
    Cgyfd_zhub findZhubByDjh(String djh);

    @Select("SELECT * FROM cgyfd_zhub where cgyfd_zhu_id = #{cgyfd_zhu_id}")
    Cgyfd_zhub findZhubById(int cgyfd_zhu_id);

    @Select("<script>" +
            "select * from cgyfd_zhub where 1=1" +
            "<if test='djh!=null and djh!=\"\"'>and djh=#{djh}</if>" +
            "<if test='gs!=null and gs!=\"\"'>and gs=#{gs}</if>" +
            "<if test='rq!=null and rq!=\"\"'>and rq=#{rq}</if>" +
            "<if test='qsrq!=null and qsrq!=\"\"'>and qsrq=#{qsrq}</if>" +
            "<if test='ks!=null and ks!=\"\"'>and ks=#{ks}</if>" +
            "<if test='bm!=null and bm!=\"\"'>and bm=#{bm}</if>" +
            "<if test='ywy!=null and ywy!=\"\"'>and ywy=#{ywy}</if>" +
            "<if test='sxbz!=null and sxbz!=\"\"'>and sxbz=#{sxbz}</if>" +
            "<if test='zdr!=null and zdr!=\"\"'>and zdr=#{zdr}</if>" +
            "<if test='zdsj!=null and zdsj!=\"\"'>and zdsj=#{zdsj}</if>" +
            "<if test='spr!=null and spr!=\"\"'>and spr=#{spr}</if>" +
            "<if test='spsj!=null and spsj!=\"\"'>and spsj=#{spsj}</if>" +
            "<if test='qzr!=null and qzr!=\"\"'>and qzr=#{qzr}</if>" +
            "<if test='qzsj!=null and qzsj!=\"\"'>and qzsj=#{qzsj}</if>" +
            "<if test='xgr!=null and xgr!=\"\"'>and xgr=#{xgr}</if>" +
            "<if test='xgsj!=null and xgsj!=\"\"'>and xgsj=#{xgsj}</if>" +
            "</script>")
    ArrayList<Cgyfd_zhub> findByZhub(Cgyfd_zhub cgyfd_zhub);


    @Update("UPDATE cgyfd_zhub "+
            "SET djh = #{djh}, gs = #{gs}, rq = #{rq}, ks = #{ks}, bm = #{bm}, ywy = #{ywy}, sxbz = #{sxbz}, "+
            "zdr = #{zdr}, zdsj = #{zdsj}, spr = #{spr}, spsj = #{spsj}, qzr = #{qzr}, qzsj = #{qzsj}, "+
            "xgr = #{xgr}, xgsj = #{xgsj} WHERE cgyfd_zhu_id = #{cgyfd_zhu_id}")
    void updateById(Cgyfd_zhub cgyfd_zhub);


    @Delete("delete from cgyfd_zhub where cgyfd_zhu_id=#{cgyfd_zhu_id}")
    void deleteById(int cgyfd_zhu_id);

}
