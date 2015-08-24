package main.java.com.personal.Array;

/**
 * Created by riyaz on 23/8/15.
 */
public class MatrixDigonally {
    private static void printMatrixDigonally(int[][] mat) {
        if (mat == null || mat.length == 0)
            return;
        int M = mat.length;
        int N = mat[0].length;
        int count = -1;
        for (int k = 0; k < (M + N); ++k) {
            if (k < M) {
                int i = k;
                for (int j = 0; j <= Math.min(k, N - 1); ++j, --i) {
                    System.out.print(mat[i][j] + " ");
                }
            }else {
                count++;
                int index = Math.min(k, M - 1);
                for(int j = count; j < N; ++j, --index)
                    System.out.print(mat[index][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20},
        };

        printMatrixDigonally(mat);
    }
}
