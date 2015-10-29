package main.java.com.personal.Random;

import java.util.Random;

/**
 * Created by riyaz on 28/10/15.
 */
public class PCdemo2 {
    private static int arr[];
    private static int index;
    private static Random random;

    public PCdemo2() {
        arr = new int[10];
        index = -1;
        random = new Random();
    }

    synchronized private void add(int data) throws InterruptedException {
        while (index == arr.length - 1)
            wait();
        arr[++index] = data;
        notifyAll();
    }

    synchronized private int remove() throws InterruptedException {
        while (index == -1)
            wait();
        int data = arr[index--];
        notifyAll();
        return data;
    }

    private static class Producer extends Thread {
        private PCdemo2 pCdemo2;

        Producer(PCdemo2 pCdemo2) {
            this.pCdemo2 = pCdemo2;
        }


        @Override
        public void run() {
            while (true) {
                int i = random.nextInt(100);
                try {
                    pCdemo2.add(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i + "\t is added");
            }

        }
    }

    private static class Consumer extends Thread {
        private PCdemo2 pCdemo2;

        Consumer(PCdemo2 pCdemo2) {
            this.pCdemo2 = pCdemo2;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Removed item is \t" + pCdemo2.remove());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        PCdemo2 pCdemo2 = new PCdemo2();
        Producer p = new Producer(pCdemo2);
        Consumer c = new Consumer(pCdemo2);
        p.start();
        c.start();
    }

}
