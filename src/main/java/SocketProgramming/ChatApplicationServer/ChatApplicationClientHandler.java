package SocketProgramming.ChatApplicationServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.HashMap;

/**
 * Created by rahil on 6/12/21.
 */
public class ChatApplicationClientHandler implements Runnable
{
    Socket newClientSocket;
    String target1;
    String target2;
    private static HashMap<String,Socket> socketStore=new HashMap<String,Socket>();

    ChatApplicationClientHandler(Socket newClientSocket,String target1,String target2)
    {
        this.newClientSocket=newClientSocket;
        this.target1=target1;
        this.target2=target2;
//        this.socketStore=socketStore;
    }
    @Override
    public void run()
    {
        socketStore.put(Thread.currentThread().getName(),newClientSocket);
        System.out.println("current thread : " + Thread.currentThread().getName());

        if(socketStore.size() == 2)
        {
            Socket target1Socket=socketStore.get(target1);
            Socket target2Socket=socketStore.get(target2);

            Thread target1ActivityThread1=new Thread(new ChatApplicationClientActivity(target1Socket,target2Socket));

            Thread target1ActivityThread2=new Thread(new ChatApplicationClientActivity(target2Socket,target1Socket));

            target1ActivityThread1.start();
            target1ActivityThread2.start();
        }

    }
}
