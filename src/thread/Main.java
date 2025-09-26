

public class Main {

    public static void main(String ... args) {

        Thread t1 = new Thread(
            new FirstThread("R1"));
        t1.start();

        Thread t2 = new Thread(
            new FirstThread("R2"));
        t2.start();
    }
}