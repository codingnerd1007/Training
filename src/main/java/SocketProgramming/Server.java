package SocketProgramming;

/**
 * Created by rahil on 28/10/21.
 */
import java.io.*;
import java.net.*;
public class Server{
    public static void main(String[] args){
        try{
            ServerSocket serverSocket=new ServerSocket(6666);
            Socket newSocket= serverSocket.accept();
            DataInputStream dataInputStreamObject=new DataInputStream(newSocket.getInputStream());
            String input=(String)dataInputStreamObject.readUTF();
            System.out.println("message="+input);
            serverSocket.close();
        }catch(Exception e){
            System.out.println("Sorry! we encountered some error");
        }
    }
}
