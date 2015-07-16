package Concurrency;

import java.util.Random;

/**
 * Created by riyaz on 7/7/15.
 */
class ConcurrentBuffer {
    int[] buffer;
    int index;

    public ConcurrentBuffer() {
        buffer = new int[10];
        index = 0;
    }

    public synchronized void add(int data) {
        while (index == this.buffer.length - 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        buffer[index++] = data;
        notifyAll();
    }

    public synchronized int remove() {
        while (index == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        int result = buffer[--index];
        notifyAll();
        return result;
    }
}

class Producer extends Thread {
    private ConcurrentBuffer intBuffer;

    public Producer(ConcurrentBuffer intBuffer) {
        this.intBuffer = intBuffer;
    }

    public void run() {
        Random rand = new Random();
        while (true) {
            int r = rand.nextInt();
            this.intBuffer.add(r);
            System.out.println("Produced data \t" + r);
        }
    }
}

class Consumer extends Thread {
    private ConcurrentBuffer intBuffer;

    public Consumer(ConcurrentBuffer intBuffer) {
        this.intBuffer = intBuffer;
    }

    public void run() {
        while (true)
            System.out.println("Consumed Data \t" + intBuffer.remove());
    }

}

public class ProducerConsumer {
    public static void main(String[] args) {
        ConcurrentBuffer buffer = new ConcurrentBuffer();
        Producer p = new Producer(buffer);
        Consumer c = new Consumer(buffer);
        p.start();
        c.start();

    }
}