package SocketProgramming;

/**
 * Created by rahil on 1/11/21.
 */
import java.net.*;
import java.util.*;
public class SocketTask1{

    public static void main(String[] args){
        Runnable socketTask1Obj1=new Runnable(){
            @Override
            public void run(){
                Socket sshConnectionObject=null;
                try{
                    sshConnectionObject = new Socket("172.16.8.76", 22);
                    if(sshConnectionObject.isConnected())
                        System.out.println("connection established");
                    else
                        System.out.println("no connection established");

                    sshConnectionObject.close();
                }catch(Exception e){

                    e.printStackTrace();
            }
        }
        };

        Runnable socketTask2Obj2=new Runnable(){
            @Override
            public void run(){
                Socket ftpConnectionObject=null;
                try{

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        };

        Thread t1=new Thread(socketTask1Obj1);
        Thread t2=new Thread(socketTask2Obj2);
        t1.start();
        t2.start();
    }
}
