package socket.ftp;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class FtpClient {
    public static void main(String[]args) throws IOException {
        Socket socket = new Socket("localhost",22);
        InputStream inputStream =socket.getInputStream();
        int len = 0;
        byte[] b = new byte[1024];
        while((len = inputStream.read(b))>-1){
            System.out.println(new String(b,0,len));
        }
    }
}
