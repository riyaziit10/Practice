package main.java.com.personal.Random;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by riyaz on 14/8/15.
 */
public class LCS {
    private static int LCS(String str1, String str2, int m , int n) {
        if(m < 0 || n < 0)
            return 0;
        if(str1.charAt(m) == str2.charAt(n)) {
            return 1 + LCS(str1, str2, m - 1, n -1);
        } else {
            return Math.max(LCS(str1, str2, m - 1, n), LCS(str1, str2, m, n - 1));
        }
    }

    private static void lcsDp(String str1, String str2) {
        if(str1 == null || str2 == null)
            return;
        int str1_length = str1.length();
        int str2_length = str2.length();
        int [][]memo = new int [str1_length + 1][str2_length + 1] ;
        for(int i = 1; i <= str1_length; ++i) {
            for(int j = 1; j<= str2_length; ++j) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    memo[i][j] = 1 + memo[i-1][j-1];
                } else {
                    memo[i][j] = Math.max(memo[i-1][j] , memo[i][j-1]);
                }
            }
        }
        System.out.println(memo[str1_length][str2_length]);
        List<Character> result = new ArrayList<Character>();
        int i = str1_length, j = str2_length;
        while (i > 0 && j > 0) {
            if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                result.add(0,str1.charAt(i - 1));
                if(i-1 >=0 && j - 1 >=0 ) {
                    --i;
                    --j;
                }
            } else {
                    if(memo[i-1][j] > memo[i][j-1]) {
                        --i;
                    } else {
                        --j;
                    }
                }
        }


        System.out.println(result);


    }
    private static void show(int [][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0 ; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";
//        System.out.println(LCS(str1, str2, str1.length() - 1, str2.length() - 1));
        lcsDp(str1, str2);


        String str3 = "AGGTAB";
        String str4 = "GXTXAYB";
        List<Character> list2 = new ArrayList<Character>();
//        System.out.println(LCS(str3, str4, str3.length() - 1, str4.length() - 1));
        lcsDp(str3, str4);
    }
}
