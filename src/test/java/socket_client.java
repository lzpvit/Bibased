import org.junit.Test;

import java.io.*;
import java.net.Socket;

/**
 * Created by LZP on 2018/3/18.
 */
public class socket_client {
    @Test
    public void test1(){
        String serverName = "100.64.166.15";
        int port = Integer.parseInt("8082");
        try
        {
            System.out.println("try to connect to£º" + serverName + " £¬port is£º" + port);
            Socket client = new Socket(serverName,port);
            System.out.println("server ip£º" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("1666,565656,11,66,56,66,23,666,6565");
            //out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("server back£º " + in.readUTF());
            client.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
