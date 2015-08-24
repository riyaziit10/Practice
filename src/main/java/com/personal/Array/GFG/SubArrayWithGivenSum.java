package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 24/8/15.
 */
public class SubArrayWithGivenSum {
    private static void getSubarrayWithGivenSum(int arr[], int sum) {
        if(arr == null || arr.length == 0) {
            System.out.println("Array is Empty");
            return;
        }
        int j = 0, i;
        int current_sum = arr[0];
        int length = arr.length;
        for(i = 1; i < length; ++i) {
            while(current_sum > sum && j < i - 1) {
                current_sum -= arr[j];
                ++j;
            }
            if(sum == current_sum) {
                System.out.println("Sum found at \t" + "(" + (j) + "," + (i - 1) + ")");
                return;
            }
            current_sum += arr[i];

        }
            System.out.println("SubArray not found");
    }
    public static void main(String[] args) {
        int arr1[] = {1, 4, 20, 3, 10, 5};
        getSubarrayWithGivenSum(arr1, 33);
        int arr2[] = {1, 4, 0, 0, 3, 10, 5};
        getSubarrayWithGivenSum(arr2, 7);
        int arr3[] = {1, 4};
        getSubarrayWithGivenSum(arr3, 0);
    }
}
