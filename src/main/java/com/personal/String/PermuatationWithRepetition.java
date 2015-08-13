package main.java.com.personal.String;

/**
 * Created by riyaz on 12/8/15.
 */
public class PermuatationWithRepetition {
    private static void printPermuatation(String str, StringBuilder result) {
        if(result.length() == str.length()) {
            System.out.println(result);
            return;
        }
        int length = str.length();
        for(int i  = 0; i < length; ++i) {
            char ch = str.charAt(i);
            result.append(ch);
            printPermuatation(str, result);
            result.deleteCharAt(result.lastIndexOf(ch+""));
        }
    }
    public static void main(String[] args) {
        String str = "ABC";
        printPermuatation(str, new StringBuilder());
    }
}
