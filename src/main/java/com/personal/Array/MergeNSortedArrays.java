package main.java.com.personal.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by riyaz on 25/7/15.
 */
public class MergeNSortedArrays {

    static class MinHeapComparator implements Comparator<Node> {
        @Override
        public int compare(Node t1, Node t2) {
            return t1.element - t2.element;
        }
    }
    static class Node {
        int element;
        int index;
        int array;

        public Node(int array, int index, int element) {
            this.array = array;
            this.element = element;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        int [] [] arr = {
                {2, 4, 6, 8, 9, 12, 14, 16},
                {3, 6, 7, 9, 22, 25, 28},
                {2, 5, 7, 8, 10, 11, 16},
                {4, 8, 23, 26, 28}
                };
        int length = arr.length;
        int [] capacity = new int[length];
        int totalElements = 0;
        for(int i = 0; i < length; ++i){
            int len = arr[i].length;
            capacity[i] = len;
            totalElements += len;

        }
        int [] result  = new int[totalElements];
        int j = 0;
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(length, new MinHeapComparator());
        for(int i = 0 ; i < length; ++i){
            minHeap.add(new  Node(i, 0, arr[i][0]));
        }
        while(j < totalElements) {
            Node minNode  = minHeap.poll();
             result[j++] = minNode.element;
            if((minNode.index + 1) < capacity[minNode.array]) {
                minHeap.add(new Node(minNode.array,minNode.index + 1,arr[minNode.array][minNode.index + 1]));
            } else {
                minHeap.add(new Node(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE));
            }
        }
        System.out.println("Result is \n" + Arrays.toString(result));
    }
}
