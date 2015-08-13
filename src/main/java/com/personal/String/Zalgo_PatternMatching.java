package main.java.com.personal.String;

import java.util.Arrays;

/**
 * Created by riyaz on 7/8/15.
 */
public class Zalgo_PatternMatching {
    static boolean paaternMatchingBruteForce(String text, String pattern) {
        if(text == null && pattern == null)
            return true;
        if(text == null || pattern == null)
            return false;

        int text_length = text.length();
        System.out.println("text length \t" + text_length);
        int pattern_length = pattern.length();
        System.out.println("Pattern length \t" + pattern_length);
        String z_string = text + "$" + pattern;
        int [] z_array = new int[text_length + pattern_length + 1];
        int z_length = z_string.length();
        System.out.println("Z String length \t" + z_length);
        int count;
        int k;
        for(int i = 1 ; i < z_length - 1; ++i) {
            count = 0;
            k = i;
            for(int j = 0; j < z_length && k < z_length; ++j)
                if(z_string.charAt(j) == z_string.charAt(k)) {
                    ++count;
                    ++k;
                }
            if(count == text_length)
                return true;
            z_array[i] = count;
        }
        System.out.println(Arrays.toString(z_array));
        return false;

    }
    public static void main(String[] args) {
        String text = "GEEKS FOR GEEKS";
        String pattern = "GEEKS";
        System.out.println(paaternMatchingBruteForce(text, pattern));
        System.out.println("Pattern matching \n" + text.contains(pattern));
    }
}
