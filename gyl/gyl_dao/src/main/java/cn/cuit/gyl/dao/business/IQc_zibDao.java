package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Qc_zib;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

//仓库 期初子表
@Repository("iQc_zibDao")
public interface IQc_zibDao {

    //根据主表id查询子表s
    @Select("select * from qc_zib where qc_zhub_id=#{qc_zhub_id}")
    List<Qc_zib> findByZhubId(Long qc_zhub_id) throws Exception;

    //添加一条子表信息
    @Insert("insert into qc_zib (hh,chbm,gg,xh,dw,pc,count,dj,je,rkrq,qc_zhub_id) values (#{hh},#{chbm},#{gg},#{xh},#{dw},#{pc},#{count},#{dj},#{je},#{rkrq},#{qc_zhub_id})")
    void save(Qc_zib qc_zib) throws Exception;

    //根据id查询信息
    @Select("select * from qc_zib where qc_zib_id=#{qc_zib_id}")
    Qc_zib findById(Long qc_zib_id) throws Exception;

    //根据子表id更新子表qc_zhub_id=#{qc_zhub_id}不用更新
    @Update("update qc_zib set hh=#{hh},chbm=#{chbm},gg=#{gg},xh=#{xh},dw=#{dw},pc=#{pc},count=#{count},dj=#{dj},je=#{je},rkrq=#{rkrq} where qc_zib_id=#{qc_zib_id}")
    void updateById(Qc_zib qc_zib) throws Exception;

    //根据id删除信息
    @Delete("delete from qc_zib where qc_zib_id=#{qc_zib_id}")
    void deleteById(Long qc_zib_id) throws Exception;

    //查询子表最大行号hh
    @Select("select MAX(`hh`) from qc_zib where qc_zhub_id=#{qc_zhub_id}")
    Integer findMaxHhByZhbId(Long qc_zhub_id) throws Exception;
}
