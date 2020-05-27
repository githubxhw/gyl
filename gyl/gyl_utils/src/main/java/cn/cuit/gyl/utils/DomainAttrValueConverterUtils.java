package cn.cuit.gyl.utils;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 此类将某一个实体类的属性值 判断-1后满足条件后 进行 值改变null
 */
public class DomainAttrValueConverterUtils<T> {

    //任意类型变量
    private T obj = null;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    //无参构造
    public DomainAttrValueConverterUtils(){
    }

    //有参构造
    public DomainAttrValueConverterUtils(T t){
        this.obj = t;
    }

    /**
     * 判断是否为-1，是即把属性值设置为null
     * @param attrList 属性名称，多个或者一个
     * @param val 要转换的值
     * @return
     * @throws Exception
     */
    public T handler(List<String> attrList, Integer val) throws Exception{
        //获取字节码
        Class<?> clazz = obj.getClass();
        for (int i = 0; i < attrList.size(); i++) {
            //获取名称为status的字段
            Field field = clazz.getDeclaredField(attrList.get(i));
            //打开私有访问
            field.setAccessible(true);
            //获取值
            Object value = field.get(obj);
            //判断
            if((Integer)value == -1){
                field.set(obj,val);
            }
        }
        return obj;
    }

    public T handler(Integer val,String ...attrs) throws Exception{
        //获取字节码
        Class<?> clazz = obj.getClass();
        for (int i = 0; i < attrs.length; i++) {
            //获取名称为status的字段
            Field field = clazz.getDeclaredField(attrs[i]);
            //打开私有访问
            field.setAccessible(true);
            //获取值
            Object value = field.get(obj);
            //判断
            if((Integer)value == -1){
                field.set(obj,val);
            }
        }
        return obj;
    }
}
