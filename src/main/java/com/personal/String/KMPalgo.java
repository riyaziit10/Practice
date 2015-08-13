package main.java.com.personal.String;

import java.util.Arrays;

/**
 * Created by riyaz on 12/8/15.
 */
public class KMPalgo {
    private static void getKMPArray(String text, String pattern) {
        if(pattern == null || pattern.length() ==0)
            return;
        int patternLength = pattern.length();
        int j = 0;
        int i = 1;
        int [] kmpArray = new int[patternLength];
        while(i < patternLength) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                kmpArray[i] = ++j;
                ++i;
            } else if(j != 0) {
                j = kmpArray[j-1];
            } else {
                kmpArray[i] = 0;
                ++i;
            }
        }
        System.out.println(Arrays.toString(kmpArray));
        System.out.println(isPatternMatched(text, pattern, kmpArray));
    }

    private static boolean isPatternMatched(String text, String pattern, int kmpArr[]) {
        if(text == null || text.length() == 0)
            return false;
        int textLength = text.length();
        int i = 0;
        int j = 0;
        int paternLength = pattern.length();
        while(i < textLength && j != paternLength) {
            if(text.charAt(i) == pattern.charAt(j)) {
                ++i;
                ++j;
            } else if(j != 0){
                j = kmpArr[j-1];
            } else {
                ++i;
            }
        }
        if( j == paternLength)
        {
            System.out.println("MATCHEd");
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String text = "this is a test text";
        String pattern = "test";
        getKMPArray(text, pattern);
        String text1 ="AABAACAADAABAAABAA";
        String pattern1="AABA";
        System.out.println("========================");
        getKMPArray(text1,pattern1);

    }
}
