package SocketProgramming.ChatApplicationServer;

/**
 * Created by rahil on 6/12/21.
 */

import java.net.*;
import java.io.*;
import java.util.*;
public class ChatApplicationServer
{
    static String clientName="Client";
    static int count=0;
    public static void main(String[] args)throws Exception
    {
        ServerSocket severSocket=new ServerSocket(6666);
        //HashMap<String,Socket> socketStore=new HashMap<>();
        System.out.println("enter target1");
        String target1=new Scanner(System.in).next();
        System.out.println("enter target2");
        String target2=new Scanner(System.in).next();

        while(true)
        {
            Socket newClientSocket=null;
            newClientSocket=severSocket.accept();
            System.out.println("A new client has connected");
            System.out.println("client info:"+newClientSocket);
            count++;
            //DataInputStream disObject=new DataInputStream(newClientSocket.getInputStream());
            //DataOutputStream dosObject=new DataOutputStream(newClientSocket.getOutputStream());


            ChatApplicationClientHandler Obj=new ChatApplicationClientHandler(newClientSocket,target1,target2);
            Thread newThread = new Thread(Obj,clientName+count);
            newThread.start();
            //newThread.join();
            //System.out.println(socketStore.values().toString());
        }

    }
}
