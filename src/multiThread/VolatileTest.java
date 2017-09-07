package multiThread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by daihuijun on 2017/6/2.
 */
public class VolatileTest {
    /**
     * 相信绝大多数使用JAVA的人都没试出volatile变量的区别。献给那些一直想知道volatile是如何工作的而又试验不出区别的人。
     * 成员变量boolValue使用volatile和不使用volatile会有明显区别的。
     * 本程序需要多试几次，就能知道两者之间的区别的。
     * @param args
     */
    public static void main(String[] args) {
        final VolatileTest volObj=new VolatileTest();
        Thread t2=new Thread(){
            public void run(){
                System.out.println("t1 start");
                for(;;){
                    volObj.waitToExit();
                }
            }
        };
        t2.start();
        Thread t1=new Thread(){
            public void run(){
                System.out.println("t2 start");
                for(;;){
                    volObj.swap();
                }
            }
        };
        t1.start();
    }
    /*   注意：在mac下没有效果。。。
     *   加上volatile 修饰的是时候，程序会很快退出，因为volatile 保证各个线程工作内存的变量值和主存一致。所以boolValue == !boolValue就成为了可能。
     */
    boolean boolValue;

    public void waitToExit() {
        if(boolValue == !boolValue)System.exit(0);//非原子操作，理论上应该很快会被打断。实际不是，因为此时的boolValue在线程自己内部的工作内存的拷贝，因为它不会强制和主存区域同步，线程2修改了boolValue很少有机会传递到线程一的工作内存中。所以照成了假的“原子现象”。
    }

    public void swap() {//不断反复修改boolValue，以期打断线程1.
        boolValue = !boolValue;
    }

}
