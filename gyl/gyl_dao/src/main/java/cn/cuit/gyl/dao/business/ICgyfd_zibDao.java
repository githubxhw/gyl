package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Cgyfd_zib;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ICgyfd_zibDao {
    @Insert("INSERT INTO `gyl`.`cgyfd_zib`"+
            "(sl, hh, spmc, spbm, hsje, dw, se, wsje, lydjh, lyhh, ytdjh, ythh, dj, ljyfsl, status, zhu_id) "+
            "VALUES (#{sl}, #{ hh}, #{ spmc}, #{ spbm}, #{ hsje}, #{ dw}, #{ se}, #{ wsje}, #{ lydjh}, "+
            "#{ lyhh}, #{ ytdjh}, #{ ythh}, #{ dj}, #{ ljyfsl}, #{ status}, #{ zhu_id})")
    void save(Cgyfd_zib cgyfd_zib);

    @Select("SELECT * FROM cgyfd_zib where zhu_id = #{zhu_id}")
    ArrayList<Cgyfd_zib> findByZhuId(int zhu_id);

    @Select("SELECT * FROM cgyfd_zib where cgyfd_zib_id = #{id}")
    Cgyfd_zib findById(int id);

    @Select("SELECT * FROM cgyfd_zib where  ytdjh = #{ytdjh} and ythh = #{ythh}")
    ArrayList<Cgyfd_zib> findByYtdjhAndYthh(@Param("ytdjh") String ytdjh, @Param("ythh") int ythh);

    @Select("SELECT * FROM cgyfd_zib where lydjh = #{lydjh} and lyhh = #{lyhh}")
    ArrayList<Cgyfd_zib> findByLydjhAndLyhh(@Param("lydjh") String ytdjh, @Param("lyhh") int ythh);


    @Update("UPDATE cgyfd_zib SET sl = #{sl}, hh = #{hh}, spmc = #{spmc}, spbm = #{spbm}, hsje = #{hsje}, dw = #{dw}, se = #{se}, "+
            "wsje = #{wsje}, lydjh = #{lydjh}, lyhh = #{lyhh}, ytdjh = #{ytdjh}, ythh = #{ythh}, dj = #{dj},ljyfsl = #{ljyfsl}, status = #{status}, "+
            "zhu_id = #{zhu_id}  WHERE cgyfd_zib_id = #{cgyfd_zib_id}")
    void updateById(Cgyfd_zib cgyfd_zib);

    @Update("UPDATE cgyfd_zib SET ljyfsl = #{ljyfsl} WHERE cgyfd_zib_id = #{cgyfd_zib_id}")
    void updateLjyfslById(Cgyfd_zib cgyfd_zib);


    @Delete("DELETE FROM cgyfd_zib WHERE cgyfd_zib_id = #{id}")
    void deleteById(int id);

    @Delete("DELETE FROM cgyfd_zib WHERE zhu_id = #{zhu_id}")
    void deleteByZhuId(int zhu_id);


    @Select("SELECT MAX(cgyfd_zib.`hh`) FROM cgyfd_zib where zhu_id = #{zhu_id}")
    Integer findMaxHhByZhubId(int zhu_id);
}
