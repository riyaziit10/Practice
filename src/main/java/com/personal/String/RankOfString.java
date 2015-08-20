package main.java.com.personal.String;

/**
 * Created by riyaz on 14/8/15.
 */
public class RankOfString {
    private static final int NO_OF_CHARS = 256;
    private static int ch [] = new int [NO_OF_CHARS];
    private static void getSmallerNumbersRightSide(String str) {
        if(str == null || str.length() == 0)
            return;
        int length = str.length();
        for(int i  = 0; i < length; ++i) {
            ++ch[str.charAt(i)];
        }
        for(int i = 1; i < NO_OF_CHARS; ++i)
            ch[i] += ch[i-1];
    }

    private static  int getFactorial(int i) {
        if(i <= 1)
            return 1;
        else return i * getFactorial(i-1);
    }
    private static void updatecount (char c)
    {
        int i;
        for( i = c; i < NO_OF_CHARS; ++i )
            --ch[i];
    }

    private static int getRank(String str) {
        if(str == null || str.length() == 0)
            return 0;
        int length = str.length();
        getSmallerNumbersRightSide(str);
        int factorial = getFactorial(length);
        int rank = 1;
        for(int i = 0; i < length; ++i) {
            char character = str.charAt(i);
            factorial = factorial /(length - i);
//            System.out.println(character + "\t" + (ch[character] - 1)  + "\t" + getFactorial(length - i - 1));
//            ch[character]--;
            rank = rank + (ch[character] - 1) * factorial;
            updatecount(character);
        }
        return rank;
    }
    public static void main(String[] args) {
        String str = "";
        System.out.println(getRank(str));
    }
}
