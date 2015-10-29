package main.java.com.personal.Random;

import java.util.Arrays;

/**
 * Created by riyaz on 28/10/15.
 */
public class BalanceParentheses {
    private static void balanceParanthises(char str[], int index, int open, int close, int n) {
        if(open == n && close == n) {
            System.out.println(Arrays.toString(str));
            return;
        }

        if(open < n) {
            str[index] = '{';
            balanceParanthises(str, index + 1, open + 1, close, n);
        }
        if(close < open) {
            str[index] = '}';
            balanceParanthises(str, index + 1, open, close + 1, n);
        }

    }
    public static void main(String[] args) {
        int n = 3;
        char result [] = new char[n * 2];
        balanceParanthises(result, 0,0,0,n);
    }
}
