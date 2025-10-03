
import java.util.List;
import java.util.Random;

public class Producer implements Runnable {

    List<Integer> list;
    final Random random = new Random();

    public Producer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            int randomInteger = random.nextInt();

            System.out.println("Producing a new integer: " + String.valueOf(randomInteger));

            this.list.add(randomInteger);

            try {
                
                Thread.sleep(
                    random.nextLong(1000, 2000));

            } catch(InterruptedException e) {

            }

        }
    }
}