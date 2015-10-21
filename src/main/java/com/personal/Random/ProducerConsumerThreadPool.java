package main.java.com.personal.Random;

import sun.rmi.runtime.RuntimeUtil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by riyaz on 18/10/15.
 */
class ThreadPoolDemo {

    private class Worker extends Thread{

        public Worker(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                Runnable r = queue.take();
                r.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private final BlockingQueue<Runnable> queue;
    private final Thread[] workerthreads;
    private volatile boolean shutdown;

    public ThreadPoolDemo(int size) {
        queue = new LinkedBlockingQueue<>(size);
        workerthreads = new Thread[size];
        for (int i = 0; i < size; ++i)
            workerthreads[i] = new Worker("Pool Thread" + i);
    }

    public void addTask(Runnable task) throws InterruptedException {
        queue.put(task);
        Thread.sleep(1000);
    }


    public void setShutdown() throws InterruptedException {
        while(!queue.isEmpty()) {
            Thread.sleep(1000);
        }
        shutdown = true;
        for(Thread workerThread: workerthreads) {
            workerThread.interrupt();
        }
    }
}


public class ProducerConsumerThreadPool {
    private final BlockingQueue  queue;

    private static AtomicInteger rnd = new AtomicInteger(0);

    public ProducerConsumerThreadPool(int size) {
        this.queue = new LinkedBlockingQueue(size);
    }

    private class Producer implements Runnable {

        @Override
        public void run() {
            Integer e = rnd.incrementAndGet();
            System.out.println("Adding\t" + e + "element in the queue");
            try {
                queue.put(e);
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                Thread.currentThread().interrupted();
            }
        }
    }

    private class Consumer implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println("Extracted element is \t" + queue.take());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void init() throws InterruptedException {
        ThreadPoolDemo threadpool = new ThreadPoolDemo(6);

        for(int i = 0 ; i < 100; ++i) {
            threadpool.addTask(new Producer());
            threadpool.addTask(new Producer());
            threadpool.addTask(new Producer());
            threadpool.addTask(new Consumer());
            threadpool.addTask(new Consumer());
            threadpool.addTask(new Consumer());
        }

        threadpool.setShutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerThreadPool pc = new ProducerConsumerThreadPool(3);
        pc.init();
    }
}
