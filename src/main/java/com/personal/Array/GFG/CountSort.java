package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 25/8/15.
 */
public class CountSort {
    private static final int NO_OF_CHARS = 256;
    private  static String getSortedString(String str) {
        if(str == null || str.length() == 0)
            return null;
        int length = str.length();
        int count [] = new int [NO_OF_CHARS];
        for(int i = 0; i < length; ++i) {
            ++count[str.charAt(i)];
        }
        char [] result = new char[length];


        for(int i = 1 ; i < NO_OF_CHARS; ++i)
            count[i] += count[i-1];

        for(int i = 0; i< length; ++i){
            result[count[str.charAt(i)]- 1] = str.charAt(i);
            --count[str.charAt(i)];
        }

        return new String(result);

    }
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(getSortedString(getSortedString(str)));
    }
}
