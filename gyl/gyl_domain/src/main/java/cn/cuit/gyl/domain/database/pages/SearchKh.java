package cn.cuit.gyl.domain.database.pages;



import cn.cuit.gyl.domain.database.kh;

import java.io.Serializable;

public class SearchKh implements Serializable {
    private kh kh;
    private Integer start = 0;
    private Integer row = 0;


    public cn.cuit.gyl.domain.database.kh getKh() {
        return kh;
    }

    public void setKh(cn.cuit.gyl.domain.database.kh kh) {
        this.kh = kh;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }
}
