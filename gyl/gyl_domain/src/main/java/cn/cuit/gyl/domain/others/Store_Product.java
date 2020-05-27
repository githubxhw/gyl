package cn.cuit.gyl.domain.others;

public class Store_Product {

    private Integer storeId;//仓库id
    private String pNum;//商品编码
    private Long stockNumber;//存货数量

    @Override
    public String toString() {
        return "Store_Product{" +
                "storeId=" + storeId +
                ", pNum='" + pNum + '\'' +
                ", stockNumber=" + stockNumber +
                '}';
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getpNum() {
        return pNum;
    }

    public void setpNum(String pNum) {
        this.pNum = pNum;
    }

    public Long getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Long stockNumber) {
        this.stockNumber = stockNumber;
    }
}
