package main.java.com.personal.Array.GFG;

import java.util.Arrays;

/**
 * Created by riyaz on 28/8/15.
 */
public class ZigZagArray {

    public static void swap (int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void zigZagPrint(int arr[]) {
        if(arr == null || arr.length <= 1)
            return;
        boolean flag = true;

        int length = arr.length;
        for(int i = 0; i < length - 1; ++i) {
            if(flag) {
                if(arr[i] < arr[i+1])
                    swap(arr, i, i+1);
            } else {
                if(arr[i] > arr[i]) {
                    swap(arr, i , i + 1);
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr1[] = {4, 3, 7, 8, 6, 2, 1}; // {3, 7, 4, 8, 2, 6, 1}
        zigZagPrint(arr1);
        System.out.println(Arrays.toString(arr1));
        int arr2[] = {1, 4, 3, 2}; //arr[] =  {1, 4, 2, 3};
        zigZagPrint(arr2);
        System.out.println(Arrays.toString(arr2));


    }
}
