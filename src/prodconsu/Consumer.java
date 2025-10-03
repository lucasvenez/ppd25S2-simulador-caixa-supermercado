
import java.util.List;
import java.util.Random;

public class Consumer implements Runnable {

    private final List<Integer> list;
    private final Random random = new Random();

    public Consumer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {

        for (int i = 0; i < 8; i++) {

            if (!this.list.isEmpty())
                System.out.println("Consuming an integer: " + String.valueOf(
                    this.list.remove(0)));
            else    
                System.err.println("Nothing to consume");

            try {

                Thread.sleep(this.random.nextLong(1000, 2000));
            
            } catch (InterruptedException e) {

            }

        }

    }


}