package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 18/8/15.
 */
public class RotataedArray {

    private static int BinarySearch(int[] arr, int l, int h, int e) {
        if (l > h)
            return -1;
        int mid = (l + h) / 2;

        if (arr[mid] == e)
            return mid;
        else if (arr[l] < arr[mid]) {
            if (arr[l] <= e && arr[mid] >= e)
                return BinarySearch(arr, l, mid - 1, e);
            else
                return BinarySearch(arr, mid + 1, h, e);

        } else if (arr[l] <= arr[mid]) {
            int result = BinarySearch(arr, l, mid - 1, e);
            if (result != -1)
                return result;
            else
                return BinarySearch(arr, mid + 1, h, e);
        } else {
            if (arr[l] > e && arr[mid] >= e)
                return BinarySearch(arr, l, mid - 1, e);
            else
                return BinarySearch(arr, mid + 1, h, e);
        }
    }


    public static void main(String[] args) {
        int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(BinarySearch(arr1, 0, arr1.length - 1,3));
        System.out.println("========================");
        int arr2[] = {3, 4, 5, 1, 2};
        System.out.println(BinarySearch(arr2, 0, arr2.length - 1,3));
        System.out.println(BinarySearch(arr2, 0, arr2.length - 1,4));
        System.out.println("==============================");
        int arr3[] = {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("problem1\t" + BinarySearch(arr3, 0, arr3.length - 1, 0));
        System.out.println("================================");
        int arr4[] = {2, 2, 2, 2, 2, 2, 2, 3, 0, 2};
        System.out.println("problem 2\t" + BinarySearch(arr4, 0, arr4.length - 1,3));
        System.out.println("problem 3\t" + BinarySearch(arr4, 0, arr4.length - 1,0));
        System.out.println("================================");
        int arr5[] = {1, 2, 3, 4};
        System.out.println(BinarySearch(arr5, 0, arr5.length - 1,3));
        System.out.println("================================");
//
    }
}
