package main.java.com.personal.String;

/**
 * Created by riyaz on 9/8/15.
 */
public class IteratingString {
    private static boolean isIteratingStringPossible(String str) {
        if(str == null || str.length() == 0)
            return true;
        int length = str.length();
        int [] KMParray = new int [length];
        int len = 0;
        int i = 1;
        while(i < length) {
            if(str.charAt(len) == str.charAt(i)) {
                len++;
                KMParray[i] = len;
                i++;
            } else {
                if(len != 0) {
                    len = KMParray[len-1];
                } else {
                    KMParray[i] = 0;
                    ++i;
                }
            }
        }
        int prefixLength = KMParray[length - 1];
         return  prefixLength > 0 ? (length % (length - prefixLength) == 0 ? true : false) : false;
    }
    public static void main(String[] args) {
        String str = "abcabcabc";
        System.out.println(isIteratingStringPossible(str));
        String str1 = "abadabad";
        System.out.println(isIteratingStringPossible(str1));
        String str2 = "abcdabc";
        System.out.println(isIteratingStringPossible(str2));
    }
}
