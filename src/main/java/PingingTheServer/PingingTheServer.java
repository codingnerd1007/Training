package PingingTheServer;

/**
 * Created by rahil on 2/11/21.
 */
import java.net.*;

public class PingingTheServer implements Runnable{

    static InetAddress IPAddress;

    @Override
    public void run(){
        try{
            if(IPAddress.isReachable(5000)){
                System.out.println("Server pinged using thread: "+Thread.currentThread().getName());
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
        Runnable newRunnable=new PingingTheServer();

        for(int noOfThreads=1;noOfThreads<=10;noOfThreads++){
            String threadName="Thread"+noOfThreads;
            (new Thread(newRunnable, threadName)).start();
        }
        long end=System.currentTimeMillis();
        System.out.println("time of execution "+(end-start));
    }
}
