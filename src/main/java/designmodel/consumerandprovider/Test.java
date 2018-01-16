package designmodel.consumerandprovider;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
        Provider p1 = new Provider(queue);
        Provider p2 = new Provider(queue);
        Comsumer c1 = new Comsumer(queue);
        executorService.submit(()->{p1.produce();});
        executorService.submit(()->{p2.produce();});
        executorService.submit(()->{c1.comsume();});
    }
}
