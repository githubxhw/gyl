package cn.cuit.gyl.utils;

public class Reback<T>  extends PageInfo{
    private T backResult;

    public T getBackResult() {
        return backResult;
    }

    public void setBackResult(T backResult) {
        this.backResult = backResult;
    }

    @Override
    public String toString() {
        return "Reback{" +
                "backResult=" + backResult +
                '}';
    }
}
