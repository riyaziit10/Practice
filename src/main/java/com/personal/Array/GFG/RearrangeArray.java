package main.java.com.personal.Array.GFG;

import java.util.Arrays;

/**
 * Created by riyaz on 28/8/15.
 */
public class RearrangeArray {

    private static void rearrangeArray(int arr[]) {
        if(arr == null || arr.length == 0)
            return;
        int length = arr.length;
        for(int i  = 0 ; i < length; ++i) {
            int j = arr[i] % length;
            arr[j] =  arr[j] + length * i;
        }
        for(int i = 0; i < length; ++i)
            arr[i] = arr[i] / length;
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int arr1[] = {1, 3, 0, 2};
        rearrangeArray(arr1);
        int arr2[] = {2, 0, 1, 4, 5, 3};
        rearrangeArray(arr2);
        int arr3[] =  {0, 1, 2, 3};
        rearrangeArray(arr3);
        int arr4[] = {3, 2, 1, 0};
        rearrangeArray(arr4);
    }
}
