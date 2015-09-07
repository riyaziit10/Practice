package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 29/8/15.
 */
public class FindIndexOfOne {
    private static int findIndex(int arr[]) {
        if(arr == null || arr.length == 0)
            return -1;
        boolean flag = false;
        int length = arr.length;
        int one_sum = 0;
        int zero_sum = 0;
        int index = -1;
        int max = 0;
        int res = -1;
        int i = 0;
        for(; i < length; ++i){
            if(flag == false) {
                if(arr[i] != 0)
                    one_sum += 1;
                else {
                    index = i;
                    flag = true;
                }
            } else if( flag == true && arr[i] != 0) {
                zero_sum += 1;
            } else if( flag == true && arr[i] == 0) {
                int total_sum = one_sum + 1 + zero_sum;
                if(total_sum > max) {
                    max = total_sum;
                    res = index;
                }
                    one_sum = zero_sum;
                    zero_sum = 0;
                    index = i;
                    flag = true;
            }
        }
            int total_sum = one_sum + 1 + zero_sum;
            if (total_sum > max) {
                max = total_sum;
                res = index;
        }
//        System.out.println("i\t" + index);
        return index;
    }
    public static void main(String[] args) {
        int arr1[] =  {1, 1, 0};// 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};

        System.out.println(findIndex(arr1));

        int arr2[] =  {1, 1, 1, 1, 0};

        System.out.println(findIndex(arr2));
    }
}
