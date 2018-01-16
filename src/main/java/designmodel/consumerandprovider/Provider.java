package designmodel.consumerandprovider;

import java.util.concurrent.BlockingQueue;

public class Provider {
    public Provider(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }
    private BlockingQueue<String> blockingQueue;
    public void produce() {
        try {
            blockingQueue.put("apple");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
