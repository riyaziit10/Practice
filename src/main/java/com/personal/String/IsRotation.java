package main.java.com.personal.String;

/**
 * Created by riyaz on 9/8/15.
 */
public class IsRotation {
    private static boolean isRotation(String str1, String str2) {
        if(str1 == null && str2 == null)
            return  true;
        if(str1 == null || str2 == null)
            return false;
        if(str1.length() != str2.length())
            return false;
        String temp = str1+ str1;
        if(temp.contains(str2))
            return true;
        return false;
    }
    public static void main(String[] args) {
        String str1 = "ABCD";
        String str2 = "CDAB";
        System.out.println(isRotation(str1,str2));
        String str3 = "ABCD";
        String str4 = "ACBD";
        System.out.println(isRotation(str3,str4));

    }
}
