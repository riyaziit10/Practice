package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 24/8/15.
 */
public class BinarySearch {
    private static int getMaximum(int arr[], int l, int h) {
        if(l > h)
            return  -1;
        if( l == h)
            return arr[l];
        if(l + 1 == h)
            return Math.max(arr[l], arr[h]);
        int mid = (l + h) / 2;
        if(arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
            return arr[mid];
        } else if(arr[l] < arr[mid] && arr[mid - 1] < arr[mid]) {
            return getMaximum(arr, mid + 1, h);
        } else
            return getMaximum(arr, l , mid - 1);

    }
    public static void main(String[] args) {
        int arr1[] = {8};//, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}; //500
        System.out.println("arr1 \t" + getMaximum(arr1, 0, arr1.length - 1));
        int arr2[] = {1, 3, 50, 10, 9, 7, 6}; //50
        System.out.println("arr2 \t" + getMaximum(arr2, 0, arr2.length - 1));
        int arr3[] = {10, 20, 30, 40, 50}; //50
        System.out.println("arr3 \t" + getMaximum(arr3, 0, arr3.length - 1));
        int arr4[] = {120, 100, 80, 20, 0}; //120
        System.out.println("arr4 \t" + getMaximum(arr4, 0, arr4.length - 1));
        int arr5[] = {5,6,1,2,3,4};
        System.out.println("arr5 \t" + getMaximum(arr5, 0, arr5.length - 1));

    }
}
