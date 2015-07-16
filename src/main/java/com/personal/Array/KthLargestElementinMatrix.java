package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by riyaz on 5/7/15.
 */
public class KthLargestElementinMatrix {

    static int getKthLargestElement(int[][] mat, int k) {
        if(k == 0 || k > 2 *mat.length ) {

            return -1 ;
        }

        int i = 1;
        int m = mat.length;
        int n = mat[0].length;
        while (i < k) {
            int row = m - 1;
            int col = n - 1;
            while (!(row == 0 && col == 0)) {
                    if (col <= 0 || row > 0 && mat[row - 1][col] >= mat[row][col - 1]) {
                        mat[row][col] = mat[row - 1][col];
                        row = row - 1;
                    } else if(row <= 0 || col > 0 && mat[row-1][col] <= mat[row][col - 1] ) {
                        mat[row][col] = mat[row][col - 1];
                        col = col - 1;
                    }


            }
            ++i;
            mat[0][0] =  - 1;
        }

        show(mat);
        return  mat[m - 1][n - 1];
    }
    static void show(int [][]  mat){
        int m = mat.length;
        int n = m;
        for(int i = 0; i < m; ++i){
            for(int j = 0 ; j < n; ++j){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 7, 8, 9},
                {6, 9, 10, 13},
                {7, 11, 12, 15},
                {8, 13, 16, 17}
        };
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j)
                list.add(matrix[i][j]);
        }
        Collections.sort(list);
        System.out.println(list);
        show(matrix);
        System.out.println("=============================");

//        for(int k = 1; k<= 3; ++k){
          int k = 3;
            int element = getKthLargestElement(matrix, k);
            if(element != - 1)
                System.out.println( k + " th largest element\t" + element);
            else
                System.out.println( k + " th Element is not possible please check your input");
//        }
    }
}
