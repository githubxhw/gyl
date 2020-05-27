package cn.cuit.gyl.utils;

//字符串转换Integer包装类工具类
public class StringToIntegerUtils {

    /**
     * 把字符串解析为Integer
     * @param resource 要解析的字符串 必须是由整数和分隔符构成，如：1,2,3
     * @param split 分隔符
     * @return
     * @throws Exception
     */
    public static Integer[] converter(String resource,String split) throws Exception{
        int count = (resource.length()+1)/2;
        Integer[] res = new Integer[count];
        String[] str = resource.split(split);
        for (int i = 0; i < str.length; i++) {
            res[i] = Integer.parseInt(str[i]);
        }
        return res;
    }

    //测试
    public static void main(String[] args) throws Exception{
        Integer[] converter = StringToIntegerUtils.converter("1,2", ",");
        for (Integer c:converter) {
            System.out.println(c);
        }
    }
}
