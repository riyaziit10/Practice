package main.java.com.personal.Array.GFG;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by riyaz on 21/8/15.
 */
public class MaxElementInSizeK {
    private static void adjustUsefulElement(Deque<Integer> deque, int element) {
        while(!deque.isEmpty() && element > deque.peekLast())
            deque.pollLast();
        deque.addLast(element);
    }
    private static void getMaximumInKsizeWindow(int arr[], int k) {
        if(arr == null ||  arr.length == 0 || k == 0)
            return;
        int length = arr.length;
        if(k == 1) {
            for(int i = 0; i < length; ++i)
                System.out.println(arr[i]);
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        int i = 0;
        while(i < k) {
                adjustUsefulElement(deque, arr[i]);
            ++i;
        }
        int j = 0;
        while(i < length) {
            System.out.print(deque.peekFirst() + " ");
            adjustUsefulElement(deque, arr[i]);
            deque.addLast(arr[i]);
            if(arr[j] == deque.peekFirst())
                deque.pollFirst();
            ++i;
        }
        System.out.println(deque.peek());
    }
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 2;
        getMaximumInKsizeWindow(arr1,k);
        int arr2[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        System.out.println();
        getMaximumInKsizeWindow(arr2, 4);
    }
}
