package cn.cuit.gyl.dao.system;

import cn.cuit.gyl.domain.system.SysLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

//访问系统日志的dao
@Repository("iSysLogDao")
public interface ISysLogDao {

    //插入一条日志记录
    @Insert("insert into syslog (username,visit_time,ip,url,method,execution_time) values (#{username},#{visit_time},#{ip},#{url},#{method},#{execution_time})")
    void save(SysLog sysLog) throws Exception;

    //查询指定start和end时间之内的所以日志记录，并降序排列
    @Select("select * from syslog where visit_time BETWEEN #{arg0} AND #{arg1} ORDER BY visit_time DESC")
    List<SysLog> findAllBetweenStartAndEndTimeOrderByTimeDesc(Date startTime, Date endTime) throws Exception;

    //根据sysLog信息查询满足的日志s
    @Select({"<script>" +
            "select * from syslog where 1=1 " +
            "<if test='username!=null and username!=\"\"'>and username=#{username} </if>" +
            "<if test='visit_time!=null'>and visit_time=#{visit_time} </if>" +
            "<if test='ip!=null and ip!=\"\"'>and ip=#{ip} </if>" +
            "<if test='url!=null and url!=\"\"'>and url=#{url} </if>" +
            "<if test='method!=null and method!=\"\"'>and method=#{method} </if>" +
            "<if test='execution_time!=null'>and execution_time=#{execution_time} </if>" +
            "</script>"})
    List<SysLog> findBySysLog(SysLog sysLog) throws Exception;

    @Delete("delete from syslog where id=#{id}")
    void deleteById(Long id) throws Exception;
}
