package main.java.com.personal.DP;

/**
 * Created by riyaz on 29/10/15.
 */
public class CoinChange {
    private static int  calculateCoinChange(int[] arr, int n) {
        if (arr == null || arr.length == 0 || n < 0)
        return Integer.MAX_VALUE;
        int length = arr.length;

        int [][] memo = new int [n+1][length+1];

        for(int i = 0; i <= length; ++i)
            memo[0][i] = 1;

        for(int i = 1; i <=n ; ++i) {
            for(int j = 1; j <= length; ++j) {
                memo[i][j] = memo[i][j-1];
                if(i >= j) {
                    if(i - arr[j-1] >= 0)
                    memo[i][j] += memo[i - arr[j-1]][j];
                }
            }
        }
        for(int i = 0 ; i <= n; ++i) {
            for(int j = 0; j <= length; ++j) {
                System.out.print(memo[i][j] + "\t");
            }
            System.out.println();
        }
        return memo[n][length];

    }
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        int n = 4;
        System.out.println("Number of ways\n" + calculateCoinChange(arr, n));
    }


}
