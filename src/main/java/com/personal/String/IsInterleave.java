package main.java.com.personal.String;

/**
 * Created by riyaz on 12/8/15.
 */
public class IsInterleave {
    private static boolean isInterleaved(String str1, int m , String str2, int n , String interleavedString, int index) {
        if(str1 == null || str2 == null || interleavedString == null)
            return false;
        int str1Length = str1.length();
        int str2Length = str2.length();
        if(index == str1Length + str2Length)
            return true;
        if(m < str1Length && interleavedString.charAt(index) == str1.charAt(m))
            return isInterleaved(str1, m + 1, str2, n, interleavedString, index + 1);
        if(n < str2Length && interleavedString.charAt(index) == str2.charAt(n))
            return isInterleaved(str1, m, str2, n + 1, interleavedString, index + 1);
        return false;

    }
    public static void main(String[] args) {
        String str1 = "AB";
        String str2 = "CD";
        String str3 = "ABpgrb,kjn";
        System.out.println(isInterleaved(str1, 0, str2, 0, str3, 0));

    }
}
