package DsAlgo;

/**
 * Created by riyaz on 31/5/15.
 */
public class SearchInSortedMatrix {
    private static void search(int[][] mat, int x) {
        int row = mat.length;
        int col = mat[0].length - 1;
        int current_row=0;
        while(col >=0 && current_row != row) {
                if(mat[current_row][col] == x) {
                    System.out.println("Element found at location \t ");
                    return;
                }
                if(x < mat[current_row][col])
                    --col;
                else
                    ++current_row;
            }
        System.out.println("Element is not present\t");
        }

    private static void contains(int[][] matrix, int k)
    {
        int row = matrix.length;
        int col = matrix[0].length;
        int currentRow = 0;
        int currentCol = col - 1;
        while (currentRow != row && currentCol != -1)
        {
            if (matrix[currentRow][currentCol] == k) {
                System.out.println("element found");
                return;
            }

            else if (matrix[currentRow][currentCol] > k)
                currentCol--;
            else
                currentRow++;
        }
        System.out.println("Element is not present in the matrix");
    }
    public static void main(String[] args) {
        int [][] mat = { {10, 20, 30, 40},
                         {15, 25, 35, 45},
                         {27, 29, 37, 48},
                         {32, 33, 39, 50},
                        };
        search(mat, 10);
    }


}
