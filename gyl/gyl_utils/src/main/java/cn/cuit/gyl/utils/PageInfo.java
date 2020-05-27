package cn.cuit.gyl.utils;

import java.util.ArrayList;
import java.util.List;

public class PageInfo {

    private String resFlag = "0"; //0 代表失败 1 代表成功
    //页面提示信息
    private List<String> msgList = new ArrayList<>();

    public String getResFlag() {
        return resFlag;
    }

    public void setResFlag(String resFlag) {
        this.resFlag = resFlag;
    }

    public List<String> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<String> msgList) {
        this.msgList = msgList;
    }

    public void add(String msg){
        msgList.add(msg);
    }

    public PageInfo(){
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "resFlag=" + resFlag +
                ", msgList=" + msgList +
                '}';
    }
}
