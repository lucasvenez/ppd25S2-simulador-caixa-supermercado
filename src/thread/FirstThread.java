public class FirstThread implements Runnable {

    private final String name;

    public FirstThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        for (int i = 0; i < 30; i++) {

            System.out.println("[" + this.name + "] " + "Execution " + String.valueOf(i + 1));
            
            try {
                Thread.sleep(1000);    
            } catch (InterruptedException e) {
            }            
        }
    }
}
