package main.java.com.personal.Random;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by riyaz on 2/9/15.
 */

class ProcessorV1 {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    private Object lock1 = new Object();
    public static void producer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            Thread.sleep(500);
            queue.put(random.nextInt(100));
        }
    }

    public static void consumer() throws InterruptedException {
        while(true) {
            int size = queue.size();
            Thread.sleep(1000);
            System.out.println("Element\t" + queue.take() + "\tsize\t" + size);
        }
    }
}
class ProcessorV2 {

    private  static LinkedList<Integer> queue = new LinkedList<Integer>();

    private static Object lock = new Object();

    private static final int LIMIT = 10;

    public static void producer() throws InterruptedException {
        Random rand = new Random();

        while(true) {
            synchronized (lock) {
                while (queue.size() == LIMIT) {
                    lock.wait();
                }
                Thread.sleep(500);
                queue.add(rand.nextInt(100));
                lock.notify();
            }
        }
    }

    public  static  void consumer () throws InterruptedException {
        while(true) {
            synchronized (lock) {
                while (queue.size() == 0) {
                    lock.wait();
                }
                Thread.sleep(1000);
                System.out.println("Element from V2\t" + queue.removeFirst() + "\tsize\t" + queue.size());
                lock.notify();
            }
        }
    }

}

class Runner {
    private int count  = 0;

    private Lock lock = new ReentrantLock();

    private Condition cond = lock.newCondition();

    private void increment() {
            for (int i = 0; i < 10000; ++i)
                count++;
    }
    public void fistThread() throws InterruptedException {
        lock.lock();
        System.out.println("Thread is waiting for manual input ..");
        cond.await();

        try {
            increment();
        }finally {
            lock.unlock();
        }
    }
    public void secondThread() throws InterruptedException {
        lock.lock();
        Thread.sleep(1000);
        System.out.println("Please press  enter key to resume flow");
        new Scanner(System.in).nextLine();
        cond.signal();
        try {
            increment();
        }finally {
            lock.unlock();
        }
    }

    public void display() {
        System.out.println("Value of count is \t" + count);
    }
}
public class PCdemo {
    public static void main(String[] args) throws InterruptedException {
        final Runner runner = new Runner();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.fistThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        runner.display();


//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    ProcessorV2.producer();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    ProcessorV2.consumer();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t1.start();
//        t2.start();
//
//
//        t1.join();
//        t2.join();
//        System.out.println("Thread is going to finish");

    }
}
