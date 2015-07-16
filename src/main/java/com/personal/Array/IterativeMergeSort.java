package Array;

import java.util.Arrays;

/**
 * Created by riyaz on 28/6/15.
 */
public class IterativeMergeSort {
    public static void mergeSort(int [] arr, int start, int end) {
        if(end <= start)
            return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int [] arr, int start, int mid, int end) {
        int i = 0, s = start, e = mid +1;
        int [] temp =  new int[end + 1];
        while(s <= mid && e <= end) {
            if(arr[s] < arr[e]) {
                temp[i] = arr[s];
                ++s;
            } else {
                temp[i] = arr[e];
                ++e;
            }
            ++i;
        }
        if(s<=mid) {
            while(s<=mid){
                temp[i] = arr[s];
                ++s; ++i;
            }
        }
        if(e<=end){
            while(e<=end){
                temp[i] = arr[e];
                ++i;++e;
            }
        }
        int j =0;
        for(int k = start; k <= end; ++k, ++j)
            arr[k] = temp[j];
    }
    public static void main(String[] args) {
        int [] arr = {12, 11, 13, 6,7};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
