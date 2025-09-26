public class Main {

    private static final java.util.Random random = new java.util.Random(42);

    public static void main(String ... args) {

        for (int i = 0; i < 10; i++)
            System.out.println(random.nextGaussian());

    }
}