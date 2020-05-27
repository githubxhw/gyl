package cn.cuit.gyl.domain.others;

//页面提示类
public class Tip {

    private Integer status;//状态码
    private String msg;//提示信息
    private boolean isRedirect;//是否提示跳转页面
    private String url;//提示跳转的页面地址 写法:路径localhost:8080/项目名/xx/xx.jsp --> url:xx/xx.jsp即可

    public boolean getIsRedirect() {
        return isRedirect;
    }

    public void setIsRedirect(boolean isRedirect) {
        this.isRedirect = isRedirect;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Tip{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", isRedirect='" + isRedirect + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
