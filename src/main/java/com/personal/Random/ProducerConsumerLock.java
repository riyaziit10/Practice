//package main.java.com.personal.Random;
//
//import java.util.Random;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * Created by riyaz on 29/10/15.
// */
//public class ProducerConsumerLock {
//    int arr[];
//    int index;
//    Lock lock;
//
//    public ProducerConsumerLock() {
//        arr = new int[10];
//        index = -1;
//        lock = new ReentrantLock();
//    }
//
//    private void add(int data) throws InterruptedException {
//        while(index == arr.length -1) {
//            lock.wait();
//        }
//
//        arr[++index] = data;
//
//    }
//
//    private int remove() {
//
//    }
//    private static class Producer implements Runnable {
//        private ProducerConsumerLock producerConsumerLock;
//        public Producer(ProducerConsumerLock producerConsumerLock) {
//           this. producerConsumerLock = producerConsumerLock;
//        }
//
//        @Override
//        public void run() {
//            Random rand = new Random();
//            while(true ) {
//                int i = rand.nextInt(100);
//                System.out.println("Adding value \t" + i);
//                producerConsumerLock.add(i);
//            }
//        }
//    }
//
//    private static class Consumer implements Runnable {
//        private ProducerConsumerLock producerConsumerLock;
//
//        public Consumer(ProducerConsumerLock producerConsumerLock) {
//            this.producerConsumerLock = producerConsumerLock;
//        }
//
//        @Override
//        public void run() {
//            while(true) {
//                System.out.println("Popped Element is \t" + producerConsumerLock.remove());
//            }
//
//        }
//    }
//}
