package main.java.com.personal.MuliThreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by riyaz on 1/9/15.
 */

class  App{

    private static BlockingQueue<Integer>  queue = new ArrayBlockingQueue<Integer>(10);

    public static void producer() throws InterruptedException {
        Random rand =  new Random();
        while(true) {
            queue.put(rand.nextInt(100));
        }
    }

    public static void consumer() throws InterruptedException {
        Random  rand = new Random();
        while(true) {
            Integer index = rand.nextInt(10);
            if(index == 0) {
                System.out.println(queue.take() + "\t size \t" + queue.size());
            }
        }
    }


}
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    App.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    App.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
