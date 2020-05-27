package cn.cuit.gyl.domain.system;

import cn.cuit.gyl.utils.ConverterUtils;

import java.io.Serializable;
import java.util.Date;

public class SysLog implements Serializable {

    private Long id;//访问日志id
    private String username;//访问的用户名称
    private Date visit_time;//访问时间
    private String visit_timeStr;
    private String ip;//访问的用户设备的ip
    private String url;//访问的url
    private String method;//访问的方法
    private Long execution_time;//访问该方法的执行时长

    @Override
    public String toString() {
        return "SysLog{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", visit_time=" + visit_time +
                ", visit_timeStr='" + visit_timeStr + '\'' +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", execution_time=" + execution_time +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(Date visit_time) {
        if(visit_time != null){
            this.visit_timeStr = ConverterUtils.dateToString(visit_time, "yyyy-MM-dd HH:mm:ss");
        }
        this.visit_time = visit_time;
    }

    public String getVisit_timeStr() {
        return visit_timeStr;
    }

    public void setVisit_timeStr(String visit_timeStr) {
        this.visit_timeStr = visit_timeStr;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Long getExecution_time() {
        return execution_time;
    }

    public void setExecution_time(Long execution_time) {
        this.execution_time = execution_time;
    }
}
