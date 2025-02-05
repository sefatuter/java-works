import java.util.Random;

public class Consumer implements Runnable{

    private final static Random generator = new Random();
    private final Buffer sharedLocation;

    public Consumer(Buffer shared) {
        sharedLocation = shared;
    }

    public void run() {
        int sum = 0;

        for (int count = 1; count <= 10; count++) {
            try {
                Thread.sleep(generator.nextInt(100));
                sum += sharedLocation.get();
//                System.out.printf("\t\t\t%2d\n", sum);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

        System.out.printf("\n%s %d\n%s\n", "Consumer read values totaling", sum, "Terminating consumer");
    }
}
