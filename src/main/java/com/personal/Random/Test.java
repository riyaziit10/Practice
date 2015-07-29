package  main.java.com.personal.Random;

import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) throws Exception {
        PriorityQueue minHeap = new PriorityQueue();
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(30);
        System.out.println(minHeap);
        System.out.println(minHeap.poll());
        System.out.println(minHeap);


    }
}

