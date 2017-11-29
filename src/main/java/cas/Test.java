package cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by daihuijun on 2017/6/7.
 */
public class Test {
//    public Test(){
//        System.out.println("parent 1");
//    }
    public Test(String test) {
        System.out.println("parent 2");
    }
}


class TestSon extends Test{


    public TestSon(String test) {
        super(test);
        System.out.println("son 1");
    }

    public static void main(String[] args) {
        System.out.println(Test.class.getClassLoader().getParent().getParent());
        new TestSon("1");
    }
}
