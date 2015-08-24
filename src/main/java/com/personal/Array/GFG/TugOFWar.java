package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 23/8/15.
 */
public class TugOFWar {

    private static int diff;
    private static boolean [] visited;
    private static boolean [] result;

    private static void setDiff(int  length) {
        visited = new boolean[length];
        result = new boolean[length];
        diff = Integer.MAX_VALUE;
    }
    private static void copyResult(boolean []result, boolean []visited) {
        int length = result.length;
        for(int i  = 0; i < length; ++i)
            result[i]= visited[i];
    }
    private static void tugOfWar(int [] arr, int index, int element_count , int total_sum,  int current_sum) {
        int length = arr.length;
        if(index == length)
            return;
        if(!visited[index]) {
            visited[index] = true;
            current_sum += arr[index];
            element_count += 1;
            if(element_count == length / 2) {
                int rest = total_sum - current_sum;
                if(Math.abs(rest - current_sum) < diff) {
                    diff = Math.abs(rest - current_sum);
                    copyResult(result,visited);
                }
            }
            tugOfWar(arr, index + 1, element_count, total_sum, current_sum);
            visited[index] = false;
            current_sum -= arr[index];
            element_count -= 1;
            tugOfWar(arr, index + 1, element_count, total_sum, current_sum);
        }
    }
    private  static void partitionArray(int arr[]) {
        if(arr == null || arr.length == 0)
            return;
        int length = arr.length;
        setDiff(length);
        int total_sum = 0;
        for (int i = 0 ; i < length; ++i)
            total_sum += arr[i];
        int index = 0 ;
        int element_count = 0;
        int current_sum = 0;
        tugOfWar(arr, index, element_count, total_sum, current_sum);
        for (int i  = 0; i < length; ++i) {
            if(result[i] == true)
            System.out.print(arr[i] + " ");
        }
    }


    public static void main(String[] args) {
        int arr [] = {3,4,5,7};
        partitionArray(arr);
        System.out.println();
//        {4, 100, 1, 23, 20} , {3, 5, -3, 89, 54}
        int arr2[] = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
        partitionArray(arr2);
        System.out.println();
//        The first subset is: 45 -34 12 98 -1
//        The second subset is: 23 0 -99 4 189 4
        int arr3[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        partitionArray(arr3);
    }
}
