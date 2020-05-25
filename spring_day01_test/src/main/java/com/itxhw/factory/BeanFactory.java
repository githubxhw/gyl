package com.itxhw.factory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 该工厂用于生产dao和service曾
 */
public class BeanFactory {

    //定义配置文件变量
    private static Properties properties;
    //定义用于储存dao和service对象的容器
    private static Map<String,Object> map;
    //初始化:加载配置文件，封装对象并储存容器
    static {
        try {
            map = new HashMap<String,Object>();
            properties = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("spring.properties");
            properties.load(in);
            Set<Object> keys = properties.keySet();
            for (Object keyObj:keys) {
                String key = (String)keyObj;
//                System.out.println("key:  "+key);
                String value = (String)properties.get(keyObj);
//                System.out.println("value:  "+value);
                Object bean = Class.forName(value).newInstance();
//                System.out.println("bean  :"+bean);
                map.put(key,bean);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据名字获取对应的bean
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return map.get(beanName);
    }
}
