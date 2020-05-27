package cn.cuit.gyl.domain.test;

import java.util.Date;

public class vo {

    private String id;
    //private Date dateTime;

    /*@Override
    public String toString() {
        return "vo{" +
                "id='" + id + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }*/

    @Override
    public String toString() {
        return "vo{" +
                "id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /*public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }*/
}
