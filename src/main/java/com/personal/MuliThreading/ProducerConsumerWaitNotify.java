package main.java.com.personal.MuliThreading;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by riyaz on 1/9/15.
 */
class ProducerConsumer {
    private static LinkedList<Integer> list = new LinkedList<Integer>();

    private static Object lock = new Object();

    private static final int LIMIT = 10;

    public static void producer() throws InterruptedException {
        Random rand = new Random();
        int count = 0;
        while (true) {
            synchronized (lock) {
                while (list.size() == LIMIT) {
                    lock.wait();
                }
                list.add(rand.nextInt(100));
                lock.notify();
            }
            Thread.sleep(rand.nextInt(500));
        }
    }

    public static void consumer() throws InterruptedException {
        Random rand = new Random();

        while (true) {
            synchronized (lock) {
                while (list.size() == 0) {
                    lock.wait();
                }
                int size = list.size();
                int value = list.removeFirst();
                System.out.println(value + "\t linked list size is\t" + size);
                lock.notify();
            }
            Thread.sleep(rand.nextInt(1000));
        }
    }
}

public class ProducerConsumerWaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ProducerConsumer.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ProducerConsumer.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Closing Producer and Consumer ..");
    }
}
