package rpc;

import rpc.example.interfaces.Hello;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Hello helloClient = Client.refer(Hello.class);
        System.out.println(helloClient.sayHello("戴慧军"));
    }

    public static <T> T refer(Class<T> myInterface) throws Exception {
        return (T) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{myInterface},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        ObjectOutputStream oos = null;
                        ObjectInputStream ois = null;
                        Socket socket = null;
                        try {
                            socket = new Socket("localhost", 9999);
                            oos = new ObjectOutputStream(socket.getOutputStream());
                            oos.writeUTF(method.getName());
                            oos.writeObject(method.getParameterTypes());
                            oos.writeObject(args);

                            ois = new ObjectInputStream(socket.getInputStream());

                            Object result = ois.readObject();
                            if (result instanceof Throwable) {
                                throw (Throwable) result;
                            }
                            return result;
                        } finally {
                            oos.close();
                            ois.close();
                            socket.close();
                        }
                    }
                });
    }
}
