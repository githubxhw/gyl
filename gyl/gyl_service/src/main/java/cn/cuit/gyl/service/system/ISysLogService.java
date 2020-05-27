package cn.cuit.gyl.service.system;

import cn.cuit.gyl.domain.system.SysLog;
import org.apache.ibatis.annotations.Insert;

import java.util.Date;
import java.util.List;

public interface ISysLogService {

    //添加一条访问日志信息
    void save(SysLog sysLog) throws Exception;

    /**syslog-list.jsp页面提交的所有情况3种
     * 1,若果：sysLog为null，此时startTime/endTime都不为null，则根据时间查询
     * 2,如果：sysLog不为null，此时startTime/endTime都为null，则根据sysLog查询
     * 3,如果：syslog和startTime/endTime都为null，则查询今天的日志
     * @param sysLog
     * @param startTime
     * @param endTime
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<SysLog> findAllBySysLogOrTime(SysLog sysLog, Date startTime, Date endTime, Integer pageNum, Integer pageSize) throws Exception;

    //根据id删除日志
    void deleteById(Long id) throws Exception;

    //根据多个id删除多条日志
    void deleteByIds(Long[] ids) throws Exception;
}
