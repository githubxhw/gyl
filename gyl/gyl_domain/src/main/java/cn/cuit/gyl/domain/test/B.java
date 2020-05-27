package cn.cuit.gyl.domain.test;

public class B implements BB {

    private String bStr;

    public String getbStr() {
        return bStr;
    }

    public void setbStr(String bStr) {
        this.bStr = bStr;
    }

    @Override
    public String toString() {
        return "B{" +
                "bStr='" + bStr + '\'' +
                '}';
    }
}
