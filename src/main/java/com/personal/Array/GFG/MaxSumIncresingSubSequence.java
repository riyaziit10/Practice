package main.java.com.personal.Array.GFG;

import java.util.Arrays;

/**
 * Created by riyaz on 24/8/15.
 */
public class MaxSumIncresingSubSequence {
    private static int getMaxSum(int arr[]) {
        if(arr == null || arr.length == 0 )
            return  -1;
        int length = arr.length;
        int memo[] = new int [length];
        for(int i = 0; i < length; ++i)
            memo[i] = arr[i];
        for(int i = 1; i < length; ++i) {
            for(int j = 0 ; j < i; ++j) {
                if(arr[i] > arr[j]) {
                    memo[i] = arr[i] + memo[j];
                }
            }
        }
        int max = memo[0];
        for(int i  = 1; i < length; ++i) {
            if(memo[i] > max)
                max = memo[i];
        }
        System.out.println(Arrays.toString(memo));
        return max;
    }
    public static void main(String[] args) {
        int arr1 [] = {1, 101, 2, 3, 100, 4, 5}; // 106
        System.out.println("arr1 \t" + getMaxSum(arr1));
        int arr2 [] = {3, 4, 5, 10}; //22
        System.out.println("arr2 \t" + getMaxSum(arr2));
        int arr3 [] = {10, 5, 4, 3}; //10;
        System.out.println("arr3 \t" + getMaxSum(arr3));
    }
}
