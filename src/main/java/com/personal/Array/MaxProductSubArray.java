package main.java.com.personal.Array;

/**
 * Created by riyaz on 23/7/15.
 */
public class MaxProductSubArray {
    static int maxproductSubArray(int [] array){
        int length = array.length;
        if(length == 1)
            return array[0];
        int max_so_far = array[0];
        int max = array[0];
        for(int i = 1; i < length; ++i){
            max_so_far = max_so_far * array[i];

            if(max_so_far > max)
                max=max_so_far;
            if(max_so_far == 0)
                max_so_far = 1;
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] = {6, -3, -10, 0, 2};
        System.out.println(maxproductSubArray(arr));
        int arr1[] = {-1, -3, -10, 0, 60};
        System.out.println(maxproductSubArray(arr1));
        int arr2[] = {-2, -3, 0, -2, -40};
        System.out.println(maxproductSubArray(arr2));
        int arr3[] = {0, 0, -20, 0};
        System.out.println(maxproductSubArray(arr3));
        int arr4[] =  {0,0,0};
        System.out.println(maxproductSubArray(arr4));
        int[] arr5 = { 1, 2, -1, 4, 0, 5, -6, -5, -6, 2, 0, 3, -4, 3, -2, 4, -3 };
        System.out.println(maxproductSubArray(arr5));


    }
}
