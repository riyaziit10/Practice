package main.java.com.personal.Random;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by riyaz on 18/10/15.
 */
public class ProducerConsumer {

    private final BlockingQueue<Integer>  queue ;

    private  static final Random rand = new Random();

    public ProducerConsumer() {
        this.queue = new LinkedBlockingQueue<>(10);
    }

    private class Producer implements Runnable{
        @Override
        public void run() {
            Integer e = rand.nextInt(100);
            System.out.printf("\nInserting element \t" + e);
            try {
                queue.put(e);
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                Thread.currentThread().interrupted();
            }
        }
    }

    private  class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("\nRemoved element is \t" + queue.take());
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                Thread.currentThread().interrupted();
            }
        }
    }

    public void init() throws InterruptedException {
        for(int i = 0 ; i < 100; ++i) {
            new Thread(new Producer(), "Producer - 1 of iteration" + i).start();
            new Thread(new Producer(), "Producer - 2 of iteration" + i).start();
            new Thread(new Producer(), "Producer - 3 of iteration" + i).start();

            new Thread(new Consumer(), "Consumer - 1 of iteration" + i).start();
            new Thread(new Consumer(), "Consumer - 2 of iteration" + i).start();
            new Thread(new Consumer(), "Consumer - 3 of iteration" + i).start();
            Thread.sleep(1000);

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();
        pc.init();
    }

}
