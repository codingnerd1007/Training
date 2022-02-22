//nsq sample Producer

package ChatApplicationNSQ;

import com.github.brainlag.nsq.NSQProducer;

/**
 * Created by rahil on 9/12/21.
 */
public class Producer
{
    public static void main(String[] args)throws Exception
    {
        NSQProducer producer = new NSQProducer().addAddress("localhost", 4150).start();
        for(int i=0;i<20;i++)
        {
            producer.produce("TestTopic", ("this is a message").getBytes());
            producer.produce("TestTopic1", ("this a new message").getBytes());
        }

    }
}
