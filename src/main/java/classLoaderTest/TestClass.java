package classLoaderTest;

import cas.Test;

public class TestClass {
    private Main main = new Main();

    public Main getMain() {
        System.out.println("getContextClassLoader:" + Thread.currentThread().getContextClassLoader());
        System.out.println("getClassLoader:" + Test.class.getClassLoader());
        return main;
    }

}
