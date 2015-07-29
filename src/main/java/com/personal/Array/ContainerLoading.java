package main.java.com.personal.Array;

/**
 * Created by riyaz on 24/7/15.
 */
public class ContainerLoading {
//    static int [] visited = new int[4];
    private static void containerLoading(int [] arr,int k, int [] visited,int sum_so_far, Integer [] m, int sum) {
        int length = arr.length;
        if(length == 0)
            return;
        for(int i = k; i < length; ++i) {
            if(visited[i] != 1) {
                int temp = sum_so_far + arr[i];
                if(temp > sum)
                    continue;
                visited[i] = 1;
                if(temp > m[0])
                    m[0] = temp;
                containerLoading(arr, i + 1, visited, temp, m, sum);
                visited[i] = 0;
            }
        }

    }
    public static void main(String[] args) {
        int [] arr = {4,6,3,9};
        int [] visited = new int[arr.length];
        Integer [] m = {0};
        containerLoading(arr, 0, visited,0, m, 14);
        System.out.println("Maximum sum possible is \t" + m[0]);
    }
}
