package main.java.com.personal.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by riyaz on 25/7/15.
 */
public class MaxKElements {

    static class PQComparator implements Comparator<Integer> {


        @Override
        public int compare(Integer t1, Integer t2) {
            return t2-t1;
        }
    }

    static void maxkElements(int [] arr, int k ) {
        int arrLength = arr.length;
        PriorityQueue pq = new PriorityQueue();
        for(int i = 0 ; i < arrLength; ++i) {
            if(pq.size() < k) {
                pq.add(arr[i]);
                continue;
            } else {
                if(((Integer) pq.peek()) < arr[i]) {
                    pq.poll();
                    pq.add(arr[i]);
                }
            }
        }
        int [] result = new int[k];
        int i = 0;
        while(!pq.isEmpty())
            result[i++] = (Integer)pq.poll();
        System.out.println(Arrays.toString(result));
    }
    public static void main(String[] args) {
        int[] arr = { 3, 46, 2, 56, 3, 38, 93, 45, 6, 787, 34, 76,
                        44, 6, 7, 86, 8, 44, 56 };
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        maxkElements(arr, 4);
    }
}
