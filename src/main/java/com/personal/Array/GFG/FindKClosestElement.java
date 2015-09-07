package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 26/8/15.
 */
public class FindKClosestElement {

    private static int binarySearch(int arr[], int l , int h, int e) {
        if(l > h)
            return -1;
        int mid = (l + h)/ 2;
        if(arr[mid] == e) {
            return mid;
        } else if(e < arr[mid]) {
            return binarySearch(arr, l, mid - 1, e);
        } else {
            return binarySearch(arr, mid + 1, h, e);
        }
    }
    private static void printKClosestElement(int arr[], int k, int element) {
        if(arr == null || arr.length == 0 || arr.length < k)
            return;
        int length = arr.length;
        int elementIndex = binarySearch(arr, 0, length - 1, element);
        int count  = 0;
        int left = elementIndex - 1;
        int right = elementIndex + 1;
        while(left >= 0 && right < length && count < k) {
            if(arr[elementIndex] - arr[left] < arr[right] - arr[elementIndex]) {
                System.out.println(arr[left]);
                --left;
            } else {
                System.out.println(arr[right]);
                right++;
            }
            ++count;
        }
        if(count < k) {
            if(right>= length) {
                while(left >= 0 && count < k) {
                    System.out.println(arr[left]);
                    --left;
                    ++count;
                }
            }
            if(left< 0 && count <= k) {
                while(right< length && count < k){
                    System.out.println(arr[right]);
                    ++right;
                    ++count;
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {12, 16, 22, 30, 35, 39, 42,
                45, 48, 50, 53, 55, 56};
        int k = 4;
        int element = 16;
        printKClosestElement(arr, k, element);
    }
}
