package main.java.com.personal.Random;

/**
 * Created by riyaz on 14/8/15.
 */
public class LPSubString {
    private static void getLPS(String str) {
        if(str == null || str.length() <= 1)
            return;
        int count = 0;
        int length = str.length();
        int max = Integer.MIN_VALUE;
        for(int k = 1; k < length; ++k) {
            int  i = k;
            int j =  k - 1;
            while(j>=0 && i < length && str.charAt(j) == str.charAt(i)) {
                count = count + 2;
                --j;
                ++i;
            }
            if(count > max) {
                max = count;
                count = 0;
            }
            j = k - 1;
            i = k + 1;
            while(j >= 0 && i < length && str.charAt(i) == str.charAt(j)) {
                count = count + 2;
                ++i;
                --j;
            }
            if(count + 1 > max) {
                max = count + 1;
                count = 0;
            }
        }
        System.out.println("LPS\t" + max);
    }
    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        getLPS(str);

    }
}
