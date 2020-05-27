package cn.cuit.gyl.exception;

public class MyException extends Exception {

    private Exception e;
    private String msg;

    public MyException(){
    }

    public MyException(String msg){
        this.msg = msg;
    }

    public MyException(Exception e){
        this.e = e;
    }

    public Exception getE() {
        return e;
    }

    public void setE(Exception e) {
        this.e = e;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
