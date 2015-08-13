package main.java.com.personal.String;

/**
 * Created by riyaz on 9/8/15.
 */
public class RunLengthEncoding {
    private static String getRunLengthString(String str) {
        if(str == null || str.length() == 0)
            return null;
        int length = str.length();
        String result = "";
        char ch = str.charAt(0);
        int count = 1;
        int i  = 1;
        while(i < length) {
            if(ch == str.charAt(i))
                ++count;
            else {
                result = result + ch + count;
                count = 1;
                ch = str.charAt(i);
            }
            ++i;
        }
        result = result + ch + count;
        return result;
    }
    public static void main(String[] args) {
        String str = "wwwwaaadexxxxxxpppp";
        System.out.println(getRunLengthString(str));
        String str1 = "geeksforgeeks";
        System.out.println(getRunLengthString(str1));
    }
}
