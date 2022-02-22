package ChatApplicationNSQ.ConsumerNSQ;

import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;

/**
 * Created by rahil on 13/12/21.
 */
public class ConsumerHandler implements Runnable
{
    @Override
    public void run()
    {
        String threadName=Thread.currentThread().getName();


        NSQLookup lookup = new DefaultNSQLookup();
        lookup.addLookupAddress("localhost", 4161);

        NSQConsumer consumer=new NSQConsumer(lookup,threadName,"abc",(message) -> {
            System.out.println("received: " + message);
            //now mark the message as finished.
            message.finished();

            //or you could requeue it, which indicates a failure and puts it back on the queue.
            //message.requeue();
        });
        consumer.start();

    }
}
