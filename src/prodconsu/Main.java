
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String ... args) {
        
        List<Integer> sharedList = new LinkedList<>();

        Thread producer = new Thread(
            new Producer(sharedList));

        Thread consumer = new Thread(new Consumer(sharedList));

        consumer.start();
        producer.start();
        

    }

}