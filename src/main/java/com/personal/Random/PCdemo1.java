package main.java.com.personal.Random;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by riyaz on 28/10/15.
 */
public class PCdemo1 {
    private static BlockingQueue<Integer> queue;
    private static Random random;
    PCdemo1() {
        queue = new LinkedBlockingQueue<>(10);
        random = new Random();
    }

    private static class Producer implements Runnable{

        @Override
        public void run() {
            while(true) {
                int i = random.nextInt(100);
                System.out.println("Putting \t" + i + "\tin the queue");
                try {
                    queue.put(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Consumer implements  Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    int i = queue.take();
                    Thread.sleep(1000);
                    System.out.println("Removed value from queue is\t" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        PCdemo1 pCdemo1 = new PCdemo1();
        Thread t1 = new Thread(new Producer());
        Thread t2 = new Thread(new Consumer());
        t1.start();
        t2.start();
    }

}
