package PingingTheServerUsingThreadPool;

/**
 * Created by rahil on 2/11/21.
 */
import java.net.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PingingTheServerUsingThreadPool implements Runnable{

    static InetAddress IPAddress;
    String threadName;
    public PingingTheServerUsingThreadPool(String threadName){
        this.threadName=threadName;
    }

    @Override
    public void run(){
        try{
            if(IPAddress.isReachable(5000)){
                System.out.println("Server pinged using thread: "+Thread.currentThread().getName()+"  "+threadName);
            }
            else{
                System.out.println("Not Found");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args)throws Exception{
        long start=System.currentTimeMillis();
        IPAddress=InetAddress.getByName("172.16.8.76");
        ExecutorService threadPool= Executors.newFixedThreadPool(10);
        //Runnable newRunnable=new PingingTheServerUsingThreadPool();

        for(int noOfThreads=1;noOfThreads<=10;noOfThreads++){
            String threadName="Thread"+noOfThreads;
            threadPool.execute(new PingingTheServerUsingThreadPool(threadName));
        }
        threadPool.shutdown();
        long end=System.currentTimeMillis();
        //Thread.currentThread().getName();
        //Thread.currentThread().sleep(1000);
        System.out.println("time of execution "+(end-start));
    }
}
