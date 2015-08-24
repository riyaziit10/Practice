package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 22/8/15.
 */
public class LISArray {
    private static int getLISSize(int arr[]) {
        if(arr == null || arr.length == 0)
            return 0;
        int length = arr.length;
        int memo [] = new int [length];
        int path [] = new int[length];
        for(int i  = 0 ; i < length ; ++i) {
            memo[i] = 1;
            path[i] = -1;
        }

        int max = 0;
        int index = -1;
        for(int  i = 1; i < length; ++i) {
            for(int j = 0 ; j < i; ++j) {
                if(arr[i] > arr[j] &&  memo[i] < memo[j] + 1) {
                    memo[i] =  memo[j] + 1;
                    path[i] = j;
                    if(memo[i] > max) {
                        max = memo[i];
                        index = i;
                    }
                }
            }
        }
        while(index >= 0) {
            System.out.print(arr[index] + "\t");
            index = path[index];
        }
        System.out.println();
        return max;
    }
    public static void main(String[] args) {
        int arr1[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        System.out.println("arr1 \t" + getLISSize(arr1));
        int arr2[] = { 10, 22, 9, 33, 21, 50, 41, 60,80};
        System.out.println("arr2 \t " + getLISSize(arr2));
    }
}
