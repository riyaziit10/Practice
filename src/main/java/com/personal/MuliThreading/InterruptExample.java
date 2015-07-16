package MuliThreading;

/**
 * Created by riyaz on 9/7/15.
 */
public class InterruptExample extends Thread {
    public  void run () {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "is interrupted manually");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptExample(), "mythread");
        thread.start();

        System.out.println(Thread.currentThread().getName() + "in main is sleeping");

        Thread.sleep(10000);

        thread.interrupt();

//        Thread.setDefaultUncaughtExceptionHandler();


    }
}
