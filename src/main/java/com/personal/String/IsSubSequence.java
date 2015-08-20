package main.java.com.personal.String;

/**
 * Created by riyaz on 16/8/15.
 */
public class IsSubSequence {
    private static boolean isSubSequence(String str1, String str2, int m , int n) {
        if(m == 0)
            return true;
        if(n == 0)
            return false;
        if(str1.charAt(m) == str2.charAt(n))
            return isSubSequence(str1, str2, m - 1, n - 1);
        else
            return isSubSequence(str1, str2, m , n - 1);
    }
    public static void main(String[] args) {
        String str1 = "AXY";
        String str2 = "YADXCPY";
        System.out.println(isSubSequence(str1, str2, str1.length() -1 , str2.length() - 1));

        String str11 = "AXY";
        String str22 = "YADXCP";
        System.out.println(isSubSequence(str11, str22, str11.length() - 1, str22.length() - 1));

        String str111 = "gksrek";
        String str222 = "geeksforgeeks";
        System.out.println(isSubSequence(str111, str222, str111.length() - 1, str222.length() - 1));

    }
}
