package designmodel.consumerandprovider;

import java.util.concurrent.BlockingQueue;

public class Comsumer {
    public Comsumer(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }
    private BlockingQueue<String> blockingQueue;
    public void comsume() {
        try {
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
