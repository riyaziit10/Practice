package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 30/8/15.
 */
public class FindSumOFSubsquare {
    private static void display(int [][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        for(int i = 0; i< M ; ++i) {
            for(int j  = 0; j< N ; ++j) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }
    private static void printSubsuareMAtrixSum(int [][] mat, int K) {
        if(mat == null || mat.length == 0)
            return;
        int M = mat.length;
        int N = mat[0].length;
        int memo[][] = new int [M][N];
        for(int i  = 0 ; i < M; ++i) {
            for(int j = 0; j < N; ++j) {
                if(j==0)
                    memo[i][j] = mat[i][j];
                else
                    memo[i][j]  = mat[i][j] + memo[i][j - 1];
            }
        }
        for(int r  = 0; r <= M - K; ++r) {
            for(int j = K - 1; j < N; ++j) {
                int count = 0;
                for(int i = r; i < r + K; ++i) {
                    count = count + memo[i][j] - (j - K >=0 ? memo[i][j-K] : 0);
                }
                System.out.print(count + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[][] = { {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
        };

        printSubsuareMAtrixSum(arr, 2);
    }
}
