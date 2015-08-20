package main.java.com.personal.String;

/**
 * Created by riyaz on 16/8/15.
 */
public class CountPossibleDecoding {
    private static int getPsoosibleNumberOfDecoding(String str, int end) {
        if(str == null || end <= 0)
            return 1;
        if(end > 0) {
            int digit = (str.charAt(end - 1) - '0') * 10 + str.charAt(end) - '0';
            int count  = 0;
            if (digit >= 10 && digit <= 26) {
                count += getPsoosibleNumberOfDecoding(str, end - 2);
            }
            count += getPsoosibleNumberOfDecoding(str, end - 1);
            return count;
        } else
            return 0;
    }

    private static void getPossibleNumberOfDecodingDp(String str) {
        if(str == null || str.length() <= 1) {
            System.out.println("1");
            return;
        }
        int length = str.length();
        int fibonacciArray []  = new int [length+1];
        fibonacciArray[0] = fibonacciArray[1] = 1;
        for(int i  = 2 ; i <= length; ++i) {
            int digit = (str.charAt(i - 2) - '0') * 10 + str.charAt(i-1) - '0';
            if(digit >= 10 && digit <= 26)
                fibonacciArray[i] = fibonacciArray[i-1] + fibonacciArray[i-2];
            else
                fibonacciArray[i] = fibonacciArray[i-1];
        }
        System.out.println(fibonacciArray[length]);
    }
    public static void main(String[] args) {
        String str = "121";
        System.out.println(getPsoosibleNumberOfDecoding(str, str.length() - 1));
        getPossibleNumberOfDecodingDp(str);
        System.out.println("=======================");
        String str2 = "1234";
        System.out.println(getPsoosibleNumberOfDecoding(str2, str2.length()-1));
        getPossibleNumberOfDecodingDp(str2);
        System.out.println("====================================");
    }
}
