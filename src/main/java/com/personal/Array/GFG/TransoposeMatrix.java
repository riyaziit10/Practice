package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 22/8/15.
 */
public class TransoposeMatrix {
    private  static void displayMatrix(int mat[][]) {
        if(mat == null || mat.length == 0)
            return;
        int M = mat.length;
        int N = mat[0].length;
        for(int i  = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }
    private static void transeposeMatrix(int mat[][]) {
        if(mat == null || mat.length == 0)
            return;
        int M = mat.length;
        int N = mat[0].length;
        int transeposeMatrix [] [] = new int[N][M];
        for(int i  = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
//                int temp  = mat[i][j] ;
//                mat[i][j] = mat[j][i];
//                mat[j][i] = temp;
                transeposeMatrix[j][i] = mat[i][j];
            }
        }
        displayMatrix(transeposeMatrix);
    }
    public static void main(String[] args) {


        int mat1[][] = {{1, 2, 3, 4, 5, 6,},
                        {7, 8, 9, 10, 11, 12},
                        {13, 14, 15, 16, 17, 18},
                        {19, 20, 21, 22, 23, 24},
                        {25, 26, 27, 28, 29, 30}
                        };
        transeposeMatrix(mat1);
//        displayMatrix(mat1);
    }
}
