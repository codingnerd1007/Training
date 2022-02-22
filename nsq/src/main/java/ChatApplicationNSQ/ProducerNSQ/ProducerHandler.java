package ChatApplicationNSQ.ProducerNSQ;

/**
 * Created by rahil on 13/12/21.
 */
import com.github.brainlag.nsq.NSQProducer;

import java.io.*;
import java.util.*;
public class ProducerHandler implements Runnable
{
    public HashSet<String> clientNames=new HashSet<>();
    @Override
    public void run()
    {
        System.out.println("Enter the name of the client to which you want to connect!");
        Scanner scannerObj=new Scanner(System.in);
        String client=scannerObj.next();
        clientNames.add(client);
        System.out.println(clientNames.size());
        while(true)
        {
            NSQProducer producer = new NSQProducer().addAddress("localhost", 4150).start();
            System.out.println("Enter your message :-");
            //if(scannerObj!=null)
            //{
                try
                {
                    producer.produce(client,scannerObj.next().getBytes());
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            //}


        }
    }

}
