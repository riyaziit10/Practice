package main.java.com.personal.Random;

/**
 * Created by riyaz on 31/8/15.
 */

public class DemoThread {
    private static int count;
    public static void main(String[] args) throws InterruptedException {
        Thread  t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i = 0 ; i < 2000; ++i) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i  = 0; i < 2000; ++i) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ++count;
                }
            }
        }) ;
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
