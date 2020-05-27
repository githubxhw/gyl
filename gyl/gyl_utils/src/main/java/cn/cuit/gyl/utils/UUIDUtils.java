package cn.cuit.gyl.utils;

import java.util.Date;
import java.util.UUID;

public class UUIDUtils {

    //获取主键
    public static String getPrimaryKey(){
        String res = UUID.randomUUID().toString().replace("-", "_").toLowerCase();
        return res;
    }

    //获取单号 12位
    public static String getOrderNumber(){
        String orderNumber = UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 12);
        return orderNumber;
    }

     /*public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String res = UUIDUtils.getOrderNumber();
            System.out.println(res+" :"+res.length());
        }
    }*/
}
