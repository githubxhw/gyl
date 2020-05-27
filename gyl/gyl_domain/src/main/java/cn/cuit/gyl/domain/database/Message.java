package cn.cuit.gyl.domain.database;

import cn.cuit.gyl.utils.ConverterUtils;

import java.io.Serializable;
import java.util.Date;

//客户信息domain
public class Message implements Serializable {

    private Long mid;//信息的id
    private Integer type;//信息类型：1代表普通信息；2代表预警信息，等等
    private String msg;//信息内容：文本，不超过50个字
    private String sender;//发送人（名称唯一）
    private Date sendTime;//发送时间
    private String sendTimeStr;
    private String receiver;//接收人（名称唯一）
    private Integer status;//是否已读状态：1已读；0未读

    @Override
    public String toString() {
        return "Message{" +
                "mid=" + mid +
                ", type=" + type +
                ", msg='" + msg + '\'' +
                ", sender='" + sender + '\'' +
                ", sendTime=" + sendTime +
                ", sendTimeStr='" + sendTimeStr + '\'' +
                ", receiver='" + receiver + '\'' +
                ", status=" + status +
                '}';
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        if(sendTime != null){
            this.sendTimeStr = ConverterUtils.dateToString(sendTime, "yyyy-MM-dd HH:mm");
        }
        this.sendTime = sendTime;
    }

    public String getSendTimeStr() {
        return sendTimeStr;
    }

    public void setSendTimeStr(String sendTimeStr) {
        this.sendTimeStr = sendTimeStr;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
