package main.java.com.personal.Array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by riyaz on 26/7/15.
 */
public class RunningMedian {
    static PriorityQueue<Integer> minHeap;
    static PriorityQueue<Integer> maxHeap;

    static {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(10, new MaxHeapComparator());
        minHeap.add(Integer.MAX_VALUE);
        maxHeap.add(Integer.MIN_VALUE);
    }
    static class MaxHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer t1, Integer t2) {
            return t1 - t2;
        }
    }


    static void addElements(int num) {
        if(num >= minHeap.peek()) {
            minHeap.add(num);
        }
        else {
            maxHeap.add(num);
        }
        if(maxHeap.size() - minHeap.size() == 2) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() - maxHeap.size() == 2) {
            maxHeap.add(minHeap.poll());
        }


    }

    static double getMedian() {
        int difference = maxHeap.size() - minHeap.size();
        if(difference == 0)
            return (maxHeap.peek() + minHeap.peek())/ 2.0;
        if(difference > 0) {
            return  maxHeap.peek();
        } else
            return minHeap.peek();
    }


    public static void main(String[] args) {
        addElements(10);
        addElements(5);
        addElements(8);
        addElements(12);
        System.out.println(getMedian());
    }
}
