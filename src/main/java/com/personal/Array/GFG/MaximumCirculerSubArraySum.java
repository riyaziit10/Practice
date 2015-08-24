package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 21/8/15.
 */
public class MaximumCirculerSubArraySum {
    private static int getMaximumSumKadanaAlgo(int arr[]) {
        if(arr == null || arr.length == 0)
            return 0;
        int length = arr.length;
        int max_sum = arr[0];
        int current_sum = arr[0];
        for(int i = 1; i < length; ++i) {
            current_sum = Math.max(current_sum + arr[i] , arr[i]);
            max_sum = Math.max(current_sum, max_sum);
        }
        return max_sum;
    }

    private static int maximumSum(int arr[]) {
        if(arr == null || arr.length == 0)
            return 0;
        int length = arr.length;
        int sum = arr[0];
        for(int i = 1; i < length; ++i)
            sum += arr[i];
        int current_sum = -arr[0];
        int max_sum = -arr[0];
        for(int i = 1; i < length; ++i) {
            current_sum = Math.max(current_sum + (-arr[i]), -arr[i]);
            max_sum = Math.max(current_sum, max_sum);
        }
        return Math.max(getMaximumSumKadanaAlgo(arr), sum + max_sum);
    }
    public static void main(String[] args) {
        int arr1 [] = {8, -8, 9, -9, 10, -11, 12};
        System.out.println("arr1 \t" + maximumSum(arr1));
        int arr2[] = {10, -3, -4, 7, 6, 5, -4, -1};
        System.out.println("arr2 \t" + maximumSum(arr2));
        int arr3[] = {-1, 40, -14, 7, 6, 5, -4, -1};
        System.out.println("arr3 \t" + maximumSum(arr3));
        int arr4[] =  {-10, 2, -1, 5};
        System.out.println("arr4 \t" + maximumSum(arr4));
        int arr5[] = {-2, 4, -1, 4, -1};
        System.out.println("arr5 \t" + maximumSum(arr5));
        int arr6[] =  {11, 10, -20, 5, -3, -5, 8, -13, 10};
        System.out.println("arr6 \t" + maximumSum(arr6));
    }
}
