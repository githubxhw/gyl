package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.Xskpd_zhub;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

//销售开票单主表的dao接口
@Repository("iXskpd_zhubDao")
public interface IXskpd_zhubDao {

    @Select({
            "<script>" +
                    "select * from xskpd_zhub where 1=1 " +
                    "<if test='fph!=null and fph!=\"\"'>and fph=#{fph} </if>" +
                    "<if test='kprq!=null'>and kprq=#{kprq} </if>" +
                    "<if test='fplx!=null and fplx!=\"\"'>and fplx=#{fplx} </if>" +
                    "<if test='kjnd!=null'>and kjnd=#{kjnd} </if>" +
                    "<if test='kh!=null and kh!=\"\"'>and kh=#{kh} </if>" +
                    "<if test='khdymc!=null and khdymc!=\"\"'>and khdymc=#{khdymc} </if>" +
                    "<if test='bm!=null and bm!=\"\"'>and bm=#{bm} </if>" +
                    "<if test='ywy!=null and ywy!=\"\"'>and ywy=#{ywy} </if>" +
                    "<if test='shdw!=null and shdw!=\"\"'>and shdw=#{shdw} </if>" +
                    "<if test='shdz!=null and shdz!=\"\"'>and shdz=#{shdz} </if>" +
                    "<if test='zdzk!=null'>and zdzk=#{zdzk} </if>" +
                    "<if test='ck!=null and ck!=\"\"'>and ck=#{ck} </if>" +
                    "<if test='bz!=null and bz!=\"\"'>and bz=#{bz} </if>" +
                    "<if test='fpzje!=null'>and fpzje=#{fpzje} </if>" +
                    "<if test='zdr!=null and zdr!=\"\"'>and zdr=#{zdr} </if>" +
                    "<if test='zdrq!=null'>and zdrq=#{zdrq} </if>" +
                    "<if test='spr!=null and spr!=\"\"'>and spr=#{spr} </if>" +
                    "<if test='sprq!=null'>and sprq=#{sprq} </if>" +
                    "<if test='sfsp!=null'>and sfsp=#{sfsp} </if>" +
                    "<if test='spsftg!=null'>and spsftg=#{spsftg} </if>" +
                    "<if test='xgr!=null and xgr!=\"\"'>and xgr=#{xgr} </if>" +
                    "<if test='xgrq!=null'>and xgrq=#{xgrq} </if>" +
                    "<if test='ysksfjs!=null'>and ysksfjs=#{ysksfjs} </if>" +
                    "<if test='status!=null'>and status=#{status} </if>" +
                    "</script>"
    })
    List<Xskpd_zhub> findByMany(Xskpd_zhub xskpd_zhub) throws Exception;

    //添加一条信息
    @Insert("insert into xskpd_zhub " +
            "(fph,kprq,fplx,kjnd,kh,khdymc,bm,ywy,shdw,shdz,zdzk,ck,bz,fpzje,zdr,zdrq,spr,sprq,sfsp,spsftg,xgr,xgrq,ysksfjs,status) " +
            "values " +
            "(#{fph},#{kprq},#{fplx},#{kjnd},#{kh},#{khdymc},#{bm},#{ywy},#{shdw},#{shdz},#{zdzk},#{ck},#{bz},#{fpzje},#{zdr},#{zdrq},#{spr},#{sprq},#{sfsp},#{spsftg},#{xgr},#{xgrq},#{ysksfjs},#{status})")
    void save(Xskpd_zhub xskpd_zhub) throws Exception;

    //根据fph发票号查询信息
    @Select("select * from xskpd_zhub where fph=#{fph}")
    Xskpd_zhub findByFph(String fph) throws Exception;

    //根据id查询信息
    @Select("select * from xskpd_zhub where xskpd_zhub_id=#{xskpd_zhub_id}")
    Xskpd_zhub findById(Integer xskpd_zhub_id) throws Exception;

    //根据id修改信息
    @Update("update xskpd_zhub set " +
            "fph=#{fph},kprq=#{kprq},fplx=#{fplx},kjnd=#{kjnd},kh=#{kh}," +
            "khdymc=#{khdymc},bm=#{bm},ywy=#{ywy},shdw=#{shdw},shdz=#{shdz}," +
            "zdzk=#{zdzk},ck=#{ck},bz=#{bz},fpzje=#{fpzje},zdr=#{zdr}," +
            "zdrq=#{zdrq},spr=#{spr},sprq=#{sprq},sfsp=#{sfsp},spsftg=#{spsftg}," +
            "xgr=#{xgr},xgrq=#{xgrq},ysksfjs=#{ysksfjs},status=#{status} " +
            "where xskpd_zhub_id=#{xskpd_zhub_id}")
    void updateById(Xskpd_zhub xskpd_zhub) throws Exception;

    //根据id删除信息
    @Delete("delete from xskpd_zhub where xskpd_zhub_id=#{xskpd_zhub_id}")
    void deleteById(Integer xskpd_zhub_id) throws Exception;
}
