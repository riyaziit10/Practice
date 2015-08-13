package main.java.com.personal.String;

/**
 * Created by riyaz on 7/8/15.
 */
public class ShortestCommonSubsequence {

    public static void main(String[] args) {
        String str1 = "GXTXAYB";
        String str2 = "AGGTAB";
//        System.out.println("Length of the shortest supersequence is \t" +
//                shortestSuperSequence(str1, str2));

        System.out.println( lcsDP(str1,str2));
    }

    private static int  shortestSuperSequence(String str1, String str2) {
        if(str1 == null && str2 == null)
            return 0;
        if(str1 == null)
            return str2.length();
        if(str2 == null)
            return str1.length();
        int str1_length = str1.length();
        int str2_length = str2.length();
        int lcs  = lcs (str1, str2, str1_length, str2_length);
        System.out.println("lcs" + lcs);
        return str1_length + str2_length - lcs;
    }

    private static int lcs(String str1, String str2, int str1_length, int str2_length) {
        if(str1_length <= 0 || str2_length <=0 )
            return 0;
        if(str1.charAt(str1_length - 1) == str2.charAt(str2_length - 1))
            return 1 + lcs(str1, str2, str1_length - 1, str2_length - 1);
        else return Math.max(lcs(str1, str2, str1_length - 1, str2_length), lcs(str1, str2, str1_length, str2_length - 1));
    }

    private static int lcsDP(String str1, String str2) {
        if(str1 == null || str2 == null)
            return 0;
        int str1_length = str1.length();
        int str2_length = str2.length();
        if(str1_length == 0 || str2_length == 0)
            return 0;

        int [][] memo = new int [str1_length + 1][str2_length + 1];

        for(int i = 1; i <= str1_length; ++i) {
            for(int j = 1; j <= str2_length; ++j) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    memo[i][j] = 1 + memo[i-1][j-1];
                }else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        printMatrix(memo);
        return memo[str1_length][str2_length];
    }

    static void printMatrix(int [][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
