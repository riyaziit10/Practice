package main.java.com.personal.Array;

import java.util.Arrays;

/**
 * Created by riyaz on 3/8/15.
 */
public class SumExceptCurrElement {
    static void getSum(int [] arr) {
        if(arr == null) {
            return;
        }
        int length = arr.length;
        if(arr.length == 0)
            return;

        int [] result = new int[length];
        int sum = 0;
        for(int i = 0; i < length; ++i) {
            result[i] += sum;
            sum += arr[i];
        }
        sum=0;
        for(int j = length - 1; j >= 0; --j) {
            result[j] += sum;
            sum += arr[j];
        }
        System.out.println(Arrays.toString(result));
    }
    public static void main(String[] args) {
        int[]arr={3};//;,1,4,5,3,4,12,3};
//        int [] barr =null;
        getSum(arr);
    }
}
