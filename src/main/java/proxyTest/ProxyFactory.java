package proxyTest;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by daihuijun on 2017/7/7.
 */
public class ProxyFactory {
    // java动态代理
    public static Object createProxyFactory(final ProxyInterface o) {
        return Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), o.getClass().getInterfaces()
                , ((proxy, method, args) -> {
                    System.out.println("处理开始");
                    String value = o.execute();
                    System.out.println("处理结束");
                    return value;
                }));
    }

    // CGLib实现
    public static Object createProxyFactoryByCGLib(ProxyInterface o) {
        return new BookFacadeCglib().getInstance(o);
    }

    private static class BookFacadeCglib implements MethodInterceptor {
        private Object target;

        /**
         * 创建代理对象
         *
         * @param target
         * @return
         */
        public Object getInstance(Object target) {
            this.target = target;
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(this.target.getClass());
            // 回调方法
            enhancer.setCallback(this);
            // 创建代理对象
            return enhancer.create();
        }

        @Override
        // 回调方法
        public Object intercept(Object obj, Method method, Object[] args,
                                MethodProxy proxy) throws Throwable {
            System.out.println("事物开始");
            Object o = proxy.invokeSuper(obj, args);
            System.out.println("事物结束");
            return o;

        }

    }
}
