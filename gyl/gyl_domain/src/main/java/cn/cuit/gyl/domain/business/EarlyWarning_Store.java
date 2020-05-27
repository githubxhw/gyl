package cn.cuit.gyl.domain.business;

//仓库预警表domain
public class EarlyWarning_Store {

    private Long id;//仓库预警id
    private Integer storeId;//仓库id
    private String storeName;//仓库名称
    private String productNum;//商品编号
    private String productName;//商品名称
    private Integer checkExp;//检查过期时间的提前天数（整数）
    private Long upperLimit;//上限数量
    private Long lowerLimit;//下线数量
    private Integer status;//预警状态 1是 0否 需不需要系统进行预警

    @Override
    public String toString() {
        return "EarlyWarning_Store{" +
                "id=" + id +
                ", storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", checkExp=" + checkExp +
                ", upperLimit=" + upperLimit +
                ", lowerLimit=" + lowerLimit +
                ", status=" + status +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCheckExp() {
        return checkExp;
    }

    public void setCheckExp(Integer checkExp) {
        this.checkExp = checkExp;
    }

    public Long getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Long upperLimit) {
        this.upperLimit = upperLimit;
    }

    public Long getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(Long lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
