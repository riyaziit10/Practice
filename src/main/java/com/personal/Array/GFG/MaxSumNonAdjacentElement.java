package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 18/8/15.
 */
public class MaxSumNonAdjacentElement {
    private static int getMaxSumNonAdjacentElement(int [] arr) {
        if(arr == null || arr.length == 0)
            return 0;
        if(arr.length == 1)
            return arr[0];

        int previous = 0;
        int exclude = 0;
        int include = arr[0];
        int length = arr.length;
        for(int i  = 1; i < length; ++i) {
            previous = Math.max(include, exclude);
            include = exclude + arr[i];
            exclude = previous;
        }
        return Math.max(include, exclude);
    }
    public static void main(String[] args) {
        int arr[] = {3,2,7,10};
        System.out.println(getMaxSumNonAdjacentElement(arr));
        int arr1[] = {5,  5, 10, 40, 50, 35};
        System.out.println(getMaxSumNonAdjacentElement(arr1));
    }
}
