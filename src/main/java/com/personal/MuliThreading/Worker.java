package main.java.com.personal.MuliThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by riyaz on 31/8/15.
 */
public class Worker {
    private Random rand = new Random();

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();

    public void stageOne()  {
        synchronized (lock1) {
            list1.add(rand.nextInt(100));
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  void stageTwo()  {
        synchronized (lock2) {
            list2.add(rand.nextInt(100));
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void process() {
        for(int i = 0; i < 1000; ++i) {
            stageOne();
            stageTwo();
        }
    }

    public List<Integer> getList1() {
        return list1;
    }

    public List<Integer> getList2() {
        return list2;
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        final Worker w = new Worker();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                w.process();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                w.process();
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
        long end = System.currentTimeMillis();
        System.out.println("Total time taken was \t" + (end - start));
        System.out.println("List size\t" + w.getList1().size() + "\t" + "List2 size:" + w.getList2().size());

    }
}
