package ChatApplicationNSQ.ProducerNSQ;

/**
 * Created by rahil on 13/12/21.
 */
public class Producer
{

    public static void main(String[] args)
    {
        ProducerHandler obj=new ProducerHandler();
        new Thread(obj).start();

    }
}
