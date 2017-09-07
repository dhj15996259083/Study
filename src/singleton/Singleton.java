package singleton;

public class Singleton {
    String name;
    private static Singleton ins;

    // 多线程下有问题
    private static Singleton getInstance0(){
        if(ins == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ins = new Singleton();
        }
        return ins;
    }

    // 双重锁检测,由于指令重排可能会有问题
    private static Singleton getInstance1(){
        if(ins == null) {
            synchronized (Singleton.class){
                if(ins == null){
                    // 2,3指令重排会造成问题
                    // mem = malloc();   (1)
                    // ins = mem;        (2)
                    // Singleton(ins);   (3)
                    ins = new Singleton();
                }
            }
        }
        return ins;
    }

    private Singleton() {
        this.name = "ddd";
    }
    public static void main(String[] args) {
        for(int i =0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Singleton.getInstance0());
            }).start();
        }
        for(int i =0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Singleton.getInstance1());
            }).start();
        }
    }
}
