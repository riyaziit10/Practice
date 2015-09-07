package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 28/8/15.
 */
public class MinimumNumberOfCoins {

    private static void display(int mat[][]) {
        int M = mat.length;
        int N = mat[0].length;
        for(int i = 0; i < M; ++i) {
            System.out.print(i + " | " + "\t");
            for(int j = 0; j < N; ++j) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static int getMinimumNumberOfCoinsForGivenValue(int arr[], int v) {
        if(arr == null || arr.length == 0)
            return -1;
        if(v == 0)
            return 0;
        int length = arr.length;
        int memo[][] = new int [v + 1][length + 1];
        for(int i = 0; i <= v; ++i)
            memo[i][0] = Integer.MAX_VALUE;

        for(int i = 1; i <= v; ++i) {
            for(int j = 1; j <= length; ++j) {
                if(i < arr[j-1])
                    memo[i][j] = memo[i][j-1];
                else
                    memo[i][j] = Math.min(memo[i][j-1], memo[i - arr[j - 1]][j] != Integer.MAX_VALUE ? 1 + memo[i - arr[j - 1]][j] :Integer.MAX_VALUE );
            }
        }
//        display(memo);
        return memo[v][length];
    }
    public static void main(String[] args) {
        int coins1[] = {25, 10, 5};
        int value1 = 30; //2
        System.out.println(getMinimumNumberOfCoinsForGivenValue(coins1, value1));

        int coins2[] = {9, 6, 5, 1};
        int value2 = 11; // 2;
        System.out.println(getMinimumNumberOfCoinsForGivenValue(coins2, value2));
    }
}
