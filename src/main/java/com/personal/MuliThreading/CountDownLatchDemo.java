package main.java.com.personal.MuliThreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by riyaz on 1/9/15.
 */
class  ProcessorLatch implements Runnable {

    CountDownLatch latch;
    public ProcessorLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Thread Started");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread finished");
        latch.countDown();
    }
}

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 5; ++i) {
            executor.submit(new ProcessorLatch(latch));
        }

        latch.await();
    }
}
