package com.itxhw.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import javax.security.auth.callback.CallbackHandler;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        final ProduerImpl produer = new ProduerImpl();
//        produer.saleTransfer(1000);
        //使用动态代理接口
        /*Produer proxyProduer = (Produer) Proxy.newProxyInstance(produer.getClass().getClassLoader(), produer.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rtValue = null;
                if ("saleTransfer".equals(method.getName())){
                    Float m = (Float) args[0];
                    rtValue = method.invoke(produer, m*0.8f);
                }
                return rtValue;
            }
        });
        proxyProduer.saleTransfer(1000);*/

        ProduerImpl cglibProduerImpl = (ProduerImpl) Enhancer.create(produer.getClass(), produer.getClass().getInterfaces(), new MethodInterceptor() {
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object rtValue = null;
                if ("saleTransfer".equals(method.getName())) {
                    Float m = (Float) args[0];
                    rtValue = method.invoke(produer, m * 0.8f);
                }
                return rtValue;
            }
        });
        cglibProduerImpl.saleTransfer(1000);
    }
}
