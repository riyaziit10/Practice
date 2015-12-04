package main.java.com.personal.DP;

/**
 * Created by riyaz on 25/11/15.
 */
public class NumberOfPathsAtmostKTurns {

    public static void printPattern(String str) {
        if(str == null || str.length() == 0)
            return;;
        if(str.length() == 1) {
            System.out.println(str);
            return;
        }

        System.out.print(str.charAt(0));
        for(int i = 0 ; i < str.length() - 2; ++i)
            System.out.print(" ");
        System.out.println(str.charAt(str.length() - 1));
        for(int i = 0 ; i < str.length() - 2; ++i)
            System.out.print(" ");
        printPattern(str.substring(1, str.length() - 1));
        System.out.println(str.charAt(0) + "\t" + str.charAt(str.length() - 1));

    }

    public static void main(String[] args) {
        String str = "abc";

        printPattern("12345");
    }


}
