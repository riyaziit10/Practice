package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 28/8/15.
 */
public class PairInSortedRotated {
    private static int findPivot(int arr [], int l , int h) {
        if(l > h)
            return -1;
        int mid = (l + h) / 2;
        if(l == h)
            return l;
        if(l + 1 == h)
            return arr[l] > arr[h] ? l : h;
        if(mid - 1 < l && arr[mid] > arr[mid + 1])
            return mid;
        else if(mid + 1 > h && arr[mid - 1] < arr[mid])
            return mid;
        else if(arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid])
            return mid;
        else if(arr[l] < arr[mid])
            return findPivot(arr, mid + 1, h);
        else return findPivot(arr, l, mid - 1);

    }

    private static boolean isSumPoossible(int arr[], int sum) {
        if(arr == null || arr.length == 0)
            return false;
        int size = arr.length;
        int r = findPivot(arr, 0, arr.length - 1);
        int start = r;
        int l = (r + 1) % size;
        while(l != r) {
            int current_sum = arr[l] + arr[r];
            if(sum == current_sum) {
                System.out.println("Elements are\n" + arr[l] + "\t" + arr[r]);
                return true;
            } else if(current_sum > sum) {
                r = ( r + size - 1) % size;
            } else {
                l = (l + 1) % size;
            }
        }
        System.out.println("Not possible");
        return false;
    }
    public static void main(String[] args) {
        int arr1[] = {11, 15, 6, 8, 9, 10}; // x= 16
        isSumPoossible(arr1,16);
        int arr2[] = {11, 15, 26, 38, 9, 10}; //x=35
        isSumPoossible(arr2, 35);
        int arr3[] = {11, 15, 26, 38, 9, 10}; //x = 45;
        isSumPoossible(arr3, 45);
          }
}
