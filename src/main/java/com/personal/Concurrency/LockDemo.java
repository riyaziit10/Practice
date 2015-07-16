package main.java.com.personal.Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by riyaz on 12/7/15.
 */
class Counter implements Runnable{
    private Lock lock;
    private int count;

    public Counter(Lock lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "\t" + getCount());
    }
    public final int getCount() {
        lock.lock();
        try {
            ++count;
            return count;
        }finally {
            lock.unlock();
        }
    }
}
public class LockDemo {

    public static void main(String[] args) {

//        final Counter c = new Counter(new ReentrantLock());
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + "\t" + c.getCount());
//            }
//        };

//        Thread t1 = new Thread(r, "Thread1");
//        Thread t2 = new Thread(r, "Thread2");
//        Thread t3 = new Thread(r, "Thread3");

        Lock lock = new ReentrantLock();
        Counter a = new Counter(lock);
        Counter b = new Counter(lock);
        Counter c = new Counter(lock);

        Thread t1 = new Thread(a, "Firat thread");
        Thread t2 = new Thread(a, "second thread");
        Thread t3 = new Thread(a, "Third thread");
        t1.start();
        t2.start();
        t3.start();

    }
}
