package cn.cuit.gyl.domain.database.pages;


import cn.cuit.gyl.domain.database.gys;

import java.io.Serializable;

public class SearchGys implements Serializable {
    private gys gys;
    private Integer start = 0;
    private Integer row = 0;

    public gys getGys() {
        return gys;
    }

    public void setGys(gys gys) {
        this.gys = gys;
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
