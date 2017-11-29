package proxyTest;

/**
 * Created by daihuijun on 2017/7/7.
 */
public class ProxyClass implements  ProxyInterface{
    @Override
    public String execute() {
        return execute0();
    }

    @Override
    public String execute0() {
        return "ProxyClass.execute0";
    }
}
