package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 21/8/15.
 */
public class ConsecutiveElement {
    private static boolean isConsecutive(int arr[]) {
        if (arr == null || arr.length == 0)
            return true;
        int length = arr.length;
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < length; ++i) {
            if (arr[i] < min)
                min = arr[i];
            else if (arr[i] > max)
                max = arr[i];
        }
        int xor = 0;
        for (int i = min; i <= max; ++i) {
            xor = xor ^ i;
        }
        for (int j = 0; j < length; ++j)
            xor = xor ^ arr[j];

        return xor == 0 ? true : false;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 4, 5, 3, 2, 6};
        System.out.println(isConsecutive(arr1));
        int arr2[] = {2, 1, 0, -3, -1, -2};
        System.out.println(isConsecutive(arr2));
        int arr3[] = {83, 78, 80, 81, 79, 82};
        System.out.println(isConsecutive(arr3));
        int arr4[] = {34, 23, 52, 12, 3 };
        System.out.println(isConsecutive(arr4));
        int arr5[] = {7, 6, 5, 5, 3, 4};
        System.out.println(isConsecutive(arr5));

    }
}
