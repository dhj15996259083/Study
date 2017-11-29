package socket.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static socket.server.CommonDefine.SERVER_PORT;

/**
 * Created by daihuijun on 2017/2/14.
 */
public class ClassicServer {
    public void run() throws IOException {
        ServerSocket server = new ServerSocket(SERVER_PORT);
        while(true){
            Socket socket = server.accept();
            new Executer(socket).start();
        }
    }

    public static void main(String[] args) throws IOException {
        new ClassicServer().run();
    }
}

class Executer extends Thread{
    private Socket socket;

    public Executer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        byte[] bytes = new byte[10240];
        try (InputStream is = socket.getInputStream()) {
            int len = 0;
            while((len = is.read(bytes)) > -1){
                System.out.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}