package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 18/8/15.
 */
public class MedianOfSortedArrays {

    private static double getMedian(int [] arr, int start, int end) {
        int totalElements = end - start + 1;
        if(totalElements % 2 != 0){
            return arr[start + totalElements/2];
        }else {
            return (arr[start + (totalElements/2) - 1] + arr[start+ totalElements/2])/2.0;
        }
    }
    private static double getMedianSortedArray(int [] arr1, int start1, int end1, int [] arr2, int start2, int end2) {
        if(arr1 == null || arr2 == null)
            return -1;
        if(end1 <= 0 || end2 <=0 )
            return -1;
        int totalElement = end1 - start1 + 1;
        if(totalElement == 1)
            return (arr1[0] + arr2[0])/2;

        if(totalElement == 2)
            return (Math.max(arr1[start1], arr2[start2]) + Math.min(arr1[end1], arr2[end2]))/2;

        double median1 = getMedian(arr1, start1, end1);
        double median2 = getMedian(arr2, start2, end2);
        if(median1 == median2)
            return  median1;
        if(median1 > median2) {
            if (totalElement % 2 == 0)
                return getMedianSortedArray(arr1, start1, (start1 + end1) / 2 + 1, arr2,  (start2 + end2) / 2 + 1, end2);
            else
                return getMedianSortedArray(arr1, start1, (start1 + end1) / 2, arr2,  (start2 + end2) / 2, end2);
        } else {
            if(totalElement %2 == 0)
                return getMedianSortedArray(arr1, (start1 + end1) / 2 + 1, end2, arr2, start2, (start2 + end2) / 2 + 1);
            else
                return getMedianSortedArray(arr1, (start1 + end1) / 2, end2, arr2, start2, (start2 + end2) / 2);
        }
    }
    public static void main(String[] args) {

        int arr1[] = {1, 2, 3, 6};
        int arr2[] = {4, 6, 8, 10};

        System.out.println(getMedianSortedArray(arr1, 0, arr1.length - 1, arr2, 0 , arr2.length  - 1));

        int arr3[] = {1, 12, 15, 26, 38};
        int arr4[] = {2, 13, 17, 30, 45};
        System.out.println(getMedianSortedArray(arr3, 0, arr3.length - 1, arr4, 0, arr4.length - 1));

    }
}
