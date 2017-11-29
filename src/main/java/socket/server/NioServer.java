package socket.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static socket.server.CommonDefine.SERVER_PORT;

/**
 * Created by daihuijun on 2017/2/14.
 */
public class NioServer {
    // 定义实现编码、解码的字符串集对象
    private Charset charse = Charset.forName("GBK");
    public void run() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        Selector selector = Selector.open();

        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(SERVER_PORT));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // selector.select()要么返回>0要么阻塞
        while(selector.select()>0){
            for (SelectionKey key : selector.selectedKeys()){
                selector.selectedKeys().remove(key);
                if(key.isAcceptable()){
//                    SocketChannel socketChannel = ((ServerSocketChannel)key.channel()).accept();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
                if(key.isReadable()){
                    ByteBuffer byteBuffer = ByteBuffer.allocate(10);
                    String content = "";
                    // 开始读取数据
                    try (SocketChannel socketChannel = (SocketChannel)key.channel()){
                        while (socketChannel.read(byteBuffer) > 0) {
                            byteBuffer.flip();
                            System.out.print(charse.decode(byteBuffer));
                            byteBuffer.clear();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        new NioServer().run();
        SellTicket t = new SellTicket();
        new Thread(t,"窗口1").start();
        new Thread(t,"窗口2").start();
        new Thread(t,"窗口3").start();
    }


}

class SellTicket implements Runnable {

    // 定义票
    private int tickets = 100;

    // 定义锁对象
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                // 加锁
                lock.lock();
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()
                            + "正在出售第" + (tickets--) + "张票");
                }
            } finally {
                // 释放锁
//                lock.unlock();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}