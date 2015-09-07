package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 24/8/15.
 * Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same
 */
public class PartitionProblem {
    private static int getTotalSum(int arr[]) {
        if (arr == null || arr.length == 0)
            return 0;
        int sum = arr[0];
        int length = arr.length;
        for (int i = 1; i < length; ++i) {
            sum += arr[i];
        }
        return sum;
    }

    private static void displayMatrix(boolean[][] mat) {
        if (mat == null || mat.length == 0)
            return;
        int M = mat.length;
        int N = mat[0].length;
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static boolean isEqualSumPartitionProblem(int arr[]) {
        if (arr == null || arr.length == 0)
            return false;
        int sum = getTotalSum(arr);
        if ((sum & 1) == 1)
            return false;
        int length = arr.length;
        boolean[][] memo = new boolean[(sum / 2) + 1][length + 1];
        for (int i = 0; i <= length; i++)
            memo[0][i] = true;
        for (int i = 1; i <= sum / 2; ++i) {
            for (int j = 1; j <= length; ++j) {
                memo[i][j] = memo[i][j - 1];
                if (i >= arr[j - 1])
                    memo[i][j] = memo[i][j - 1] || memo[i - arr[j - 1]][j - 1];
            }
        }
        return memo[sum / 2][length];

    }

    public static void main(String[] args) {
        int arr1[] = {1, 5, 11, 5}; // true
        System.out.println(isEqualSumPartitionProblem(arr1));
        int arr2[] = {1, 5, 2}; //false
        System.out.println(isEqualSumPartitionProblem(arr2));
        int arr3[] = {3, 1, 1, 2, 2, 1}; //true
        System.out.println(isEqualSumPartitionProblem(arr3));
    }
}
