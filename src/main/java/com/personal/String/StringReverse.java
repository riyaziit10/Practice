package main.java.com.personal.String;

/**
 * Created by riyaz on 9/8/15.
 */
public class StringReverse {
    private static  String reverse(String str) {
        if(str.length() < 2)
            return str;
        else return reverse(str.substring(1)) + str.charAt(0);
    }
    public static void main(String[] args) {
        String str = "Geeks for Geeks";
        System.out.println(reverse(str));
    }
}
