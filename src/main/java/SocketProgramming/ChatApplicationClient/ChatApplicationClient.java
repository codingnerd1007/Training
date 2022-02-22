package SocketProgramming.ChatApplicationClient;

/**
 * Created by rahil on 7/12/21.
 */

import java.net.InetAddress;
import java.net.Socket;
public class ChatApplicationClient
{
    public static void main(String[] args)
    {
        try
        {
            InetAddress ip=InetAddress.getByName("localhost");

            Socket clientSideSocket=new Socket(ip,6666);
            new Thread(new ClientActivity(clientSideSocket)).start();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
