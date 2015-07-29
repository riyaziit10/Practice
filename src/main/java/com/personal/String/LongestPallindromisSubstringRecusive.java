package main.java.com.personal.String;

/**
 * Created by riyaz on 16/7/15.
 */
public class LongestPallindromisSubstringRecusive {
    static int LPS(String str, int i, int j) {
        if(i > j)
            return 0;
        if(i==j)
            return 1;
        if(str.charAt(i) == str.charAt(j))
            return 2 + LPS(str, i + 1, j - 1);
        else {
            int x = LPS(str, i + 1, j);
            int y = LPS(str, i , j - 1);
            return Math.max(x, y);

        }
    }
    public static void main(String[] args) {
        String str = "dabea";
        System.out.println("String length \t" + str.length());
        System.out.println("LPS \t" +LPS(str, 0, str.length() - 1));
    }
}
