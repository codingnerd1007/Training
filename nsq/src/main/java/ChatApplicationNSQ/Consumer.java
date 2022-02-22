//nsq sample consumer

package ChatApplicationNSQ;

import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * Created by rahil on 9/12/21.
 */
public class Consumer
{
    public static void main(String[] args)throws Exception
    {
        NSQLookup lookup = new DefaultNSQLookup();
        lookup.addLookupAddress("localhost", 4161);
        NSQConsumer consumer = new NSQConsumer(lookup, "TestTopic", "dustin", (message) -> {
            System.out.println("received: " + message);
            //now mark the message as finished.
            message.finished();

            //or you could requeue it, which indicates a failure and puts it back on the queue.
            //message.requeue();
        });

        NSQConsumer consumer2 = new NSQConsumer(lookup, "TestTopic", "dustin2", (message) -> {
            System.out.println("received: " + message);
            //now mark the message as finished.
            message.finished();

            //or you could requeue it, which indicates a failure and puts it back on the queue.
            //message.requeue();
        });

        NSQConsumer consumer1 = new NSQConsumer(lookup, "TestTopic1", "dustin1", (message) -> {
            System.out.println("received: " + message);
            //now mark the message as finished.
            message.finished();

            //or you could requeue it, which indicates a failure and puts it back on the queue.
            //message.requeue();
        });

        consumer.setExecutor( new ForkJoinPool(1, (pool) -> {

            ForkJoinWorkerThread worker = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);

            worker.setName("Worker - " + worker.getPoolIndex());

            return worker;

        },(Thread.UncaughtExceptionHandler)null, true));

        consumer1.setExecutor( new ForkJoinPool(1, (pool) -> {

            ForkJoinWorkerThread worker = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);

            worker.setName("Worker - " + worker.getPoolIndex());

            return worker;

        },(Thread.UncaughtExceptionHandler)null, true));

        consumer2.setExecutor( new ForkJoinPool(1, (pool) -> {

            ForkJoinWorkerThread worker = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);

            worker.setName("Worker - " + worker.getPoolIndex());

            return worker;

        },(Thread.UncaughtExceptionHandler)null, true));

        consumer.start();
        consumer1.start();
        consumer2.start();
    }
}