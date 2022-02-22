package ChatApplicationNSQ;
import com.sproutsocial.nsq.*;
/**
 * Created by rahil on 9/12/21.
 */
public class PubExample {

    public static void handleData(byte[] data) {
        System.out.println("Received:" + new String(data));
    }

    public static void main(String[] args) {
        Publisher publisher = new Publisher("nsqd-host");

        byte[] data = "Hello nsq".getBytes();
        publisher.publishBuffered("example_topic", data);

        Subscriber subscriber = new Subscriber("", "lookup-host");
        subscriber.subscribe("example_topic", "test_channel",PubExample::handleData);
    }
}

