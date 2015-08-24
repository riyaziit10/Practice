package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 24/8/15.
 */
public class MinimumNumberOfJumps {

    private static  int getMinimumNumberOfJumpsToReachEnd(int arr[]) {
        if(arr == null || arr.length  == 0)
            return -1;
        if(arr[0] == 0)
            return -1;
        int length = arr.length;
        int [] jumps = new int[length];
        for(int i = 1; i < length; ++i) {
            jumps[i] = Integer.MAX_VALUE;
            for(int j = 0 ; j < i; ++j) {
                if(j + arr[j] >= i && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[length - 1];
    }
    public static void main(String[] args) {
        int arr1 [] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}; //3
        System.out.println("arr1 \t" + getMinimumNumberOfJumpsToReachEnd(arr1));
        int arr2[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5}; // 4
        System.out.println("arr2 \t" + getMinimumNumberOfJumpsToReachEnd(arr2));
        int arr3[] = {1, 3, 6, 1, 0, 9}; //3
        System.out.println("arr 3\t" + getMinimumNumberOfJumpsToReachEnd(arr3));
    }
}
