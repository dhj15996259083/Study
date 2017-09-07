package proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by daihuijun on 2017/7/7.
 */
public class ProxyFactory {
    static class ProxyHandler implements InvocationHandler {
        public ProxyHandler(ProxyInterface proxyInterface){
            this.proxyInterface = proxyInterface;
        }
        private ProxyInterface proxyInterface;
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("处理开始");
            String value = proxyInterface.execute();
            System.out.println("处理结束");
            return "1111";
        }
    }



    public static Object createProxyFactory(ProxyInterface o) {
        InvocationHandler invocationHandler = new ProxyHandler(o);
        return Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(),o.getClass().getInterfaces(),invocationHandler);
    }
}
