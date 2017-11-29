package rpc;

import rpc.example.HelloImpl;
import rpc.example.interfaces.Hello;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final static Integer PORT = 9999;

    public static void main(String[] args) throws Exception {
        Hello hello = new HelloImpl();

        Server.export(hello);
    }

    public static void export(final Object o) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            final Socket socket = serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ObjectInputStream inputStream = null;
                    ObjectOutputStream oos = null;
                    try {
                        inputStream = new ObjectInputStream(socket.getInputStream());
                        String methodName = inputStream.readUTF();
                        Class[] paramsTypes = (Class[]) inputStream.readObject();
                        Object[] params = (Object[]) inputStream.readObject();
                        Object result = o.getClass().getMethod(methodName, paramsTypes).invoke(o, params);
                        oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            inputStream.close();
                            oos.close();
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
