package main.java.com.personal.String;

/**
 * Created by riyaz on 12/8/15.
 */
public class PallindromePartitioning {
    private static void displayMatrix(boolean [][] matrix) {
        if(matrix == null)
            return;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0 ; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

    }
    private static String reverse(String str) {
        if(str.length() < 2)
            return str;
        else return reverse(str.substring(1)) + str.charAt(0);
    }
    private static int getMinPallindromePartiotioning(String str) {
        if(str == null || str.length() == 0)
            return 0;
        int length = str.length();

        int [] [] T = new int [length][length];
        boolean [][] P = new boolean[length][length];
        for(int i = 0; i < length; ++i) {
            P[i][i] = true;
        }
        for(int len  = 2; len <= length; ++len) {
            for(int i = 0; i + len - 1 < length; ++i){
                    int j = i + len - 1;
                    if(len == 2) {
                        P[i][j] = str.charAt(i) == str.charAt(j);
                    }else {
                        P[i][j] = str.charAt(i) == str.charAt(j) && P[i+1][j-1];
                }
                if(P[i][j]) {
                    T[i][j] = 0;
                } else {
                    T[i][j] = Integer.MAX_VALUE;
                    for(int k = i ; k < j; ++k) {
                        int res  = T[i][k] + T[k + 1][j] + 1;
                        if(res < T[i][j])
                            T[i][j] = res;
                    }
                }
            }
        }
        return T[0][length - 1];
    }

    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println(getMinPallindromePartiotioning(str));
    }
}
