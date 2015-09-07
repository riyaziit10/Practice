package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 30/8/15.
 */
public class LargestSubArrayContiguousElements {
    private static void getContiguousSubArray(int arr[]) {
        if(arr == null || arr.length == 0)
            return;
        int length = arr.length;
        int count = 0;
        for(int i = 0; i < length - 1; ++i) {
            int min = arr[i];
            int max = arr[i];
            for(int j = i + 1; j < length; ++j) {
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                if(max - min == j - i && count < j - i) {
                    count = j - i + 1;
                }
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        int arr1[] = {10, 12, 11};
        getContiguousSubArray(arr1);
        int arr2[] = {14, 12, 11, 20};
        getContiguousSubArray(arr2);

        int arr3[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
        getContiguousSubArray(arr3);
    }
}
