package proxyTest;

import sun.reflect.Reflection;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * Created by daihuijun on 2017/5/4.
 */
public class Main {
    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };
    public static String toHexString (Integer i, int radix) {
        boolean negative = i < 0;
        int index = 32;
        char[] array = new char[33];

        do {
            if(negative){
                array[index --] = digits[-i % radix];
            }else{
                array[index --] = digits[i % radix];
            }
            i = i / radix;
        }while (i != 0);




if(negative){
    array[index] = '-';
}



        return new String(array,index,33-index);
    }
    public static void main(String[] args) throws Exception {
        System.out.println(Double.toHexString(123.25));
        System.out.println(toHexString(17, 16));
//        ServerSocket serverSocket = new ServerSocket(9999);
//        while(true){
//            Socket socket = serverSocket.accept();
//            InputStream is = socket.getInputStream();
//            int len = 0;
//            byte[] bytes = new byte[1024];
//            while((len = is.read(bytes))>0){
//                System.out.write(bytes, 0 ,len);
//            }
//        }


        ProxyInterface proxyInterface = (ProxyInterface)ProxyFactory.createProxyFactory(new ProxyClass());
        System.out.println(proxyInterface.execute());

        ProxyInterface proxyInterfaceByCglib = (ProxyInterface)ProxyFactory.createProxyFactoryByCGLib(new ProxyClass());
        System.out.println(proxyInterfaceByCglib.execute());
    }
}
