package ChatApplicationNSQ.ConsumerNSQ;

import ChatApplicationNSQ.ProducerNSQ.Producer;
import ChatApplicationNSQ.ProducerNSQ.ProducerHandler;

import java.util.HashSet;

/**
 * Created by rahil on 13/12/21.
 */
public class Consumer
{
    public static void main(String[] args)
    {
        ProducerHandler obj=new ProducerHandler();
        HashSet<String> clientNames=obj.clientNames;
        for(String clientName:clientNames
            )
        {
            new Thread(new ConsumerHandler(),clientName).start();
        }

    }
}
