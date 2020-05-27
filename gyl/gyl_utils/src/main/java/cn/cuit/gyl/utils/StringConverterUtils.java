package cn.cuit.gyl.utils;

import org.apache.ibatis.annotations.Insert;

/**
 * 字符串的转化工具类
 */
public class StringConverterUtils {

    /**
     * 把字符串解析为Integer
     * @param resource 要解析的字符串 必须是由整数和分隔符构成，如：1,2,3
     * @param split 分隔符
     * @return
     * @throws Exception
     */
    public static Integer[] convertToInteger(String resource,String split) {
        Integer[] res = null;
        try {
            int count = (int)(resource.length()+1)/2;
            res = new Integer[count];
            String[] str = resource.split(split);
            for (int i = 0; i < str.length; i++) {
                res[i] = Integer.parseInt(str[i]);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 把字符串解析为Long
     * @param resource 要解析的字符串 必须是由整数和分隔符构成，如：1,2,3
     * @param split 分隔符
     * @return
     */
    public static Long[] convertToLong(String resource,String split) {
        Long[] res = null;
        try {
            int count = (int)(resource.length()+1)/2;
            res = new Long[count];
            String[] str = resource.split(split);
            for (int i = 0; i < str.length; i++) {
                res[i] = Long.parseLong(str[i]);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        String r = "1,2,3,4";
        Integer[] longs = StringConverterUtils.convertToInteger(r, ",");
        for (Integer rs:longs) {
            System.out.println(rs);
        }
    }
}
