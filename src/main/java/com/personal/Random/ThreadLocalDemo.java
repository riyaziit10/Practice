package main.java.com.personal.Random;

/**
 * Created by riyaz on 18/10/15.
 */
public class ThreadLocalDemo implements Runnable {
    private ThreadLocal threadLocal = new ThreadLocal();


    @Override
    public void run() {
        threadLocal.set(Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(threadLocal.get());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadLocalDemo());
        Thread t2 = new Thread(new ThreadLocalDemo());

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
