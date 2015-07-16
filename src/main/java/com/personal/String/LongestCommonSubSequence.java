package main.java.com.personal.String;

/**
 * Created by riyaz on 15/7/15.
 */
public class LongestCommonSubSequence {
    static int LCS(char[] str1, char[] str2, int i, int j) {

        if (i < 0 || j < 0)
            return 0;
        if (str1[i] == str2[j])
            return 1 + LCS(str1, str2, i - 1, j - 1);
        else
            return Math.max(LCS(str1, str2, i - 1, j), LCS(str1, str2, i, j - 1));
    }

    static void show(int[][] matrix, int m, int n) {
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int LCSdp(String str1, String str2, int m, int n) {
        if (m < 0 || n < 0)
            return 0;
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        show(memo, m, n);
        printChar(str1, str2, m, n, memo);
        return memo[m][n];
    }

    static void printChar(String str1, String str2, int m, int n, int[][] memo) {
        StringBuilder builder = new StringBuilder();
        while (m > 0 && n > 0) {
            if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
                builder.insert(0,str1.charAt(m-1));
                --m;
                --n;
            } else if (memo[m - 1][n] > memo[m][n - 1]) {
                m = m - 1;
            } else
                n = n - 1;
            }
        System.out.println(builder);
        }

    public static void main(String[] args) {
        String X = "AXYT";
        String Y = "AYZX";
//        for(int i = 0 ; i < 4; ++i)
//            System.out.println(xx[i]);
//        System.out.println(Arrays.toString(xx) + "\t" + Arrays.toString(yy));
//        System.out.println(LCS(xx, yy, xx.length - 1, yy.length - 1));
//        System.out.println("================================lcs==============");
        System.out.println(LCSdp(X, Y, X.length(), Y.length()));
//        System.out.println(lcs(xx,yy,xx.length - 1, yy.length - 1));
//        System.out.println(xx.length + "\t" + yy.length );
    }
}
