package main.java.com.personal.String;

/**
 * Created by riyaz on 12/8/15.
 */
public class SmallestWindowContaingAllCharacters {
    private static final int NO_OF_CHARS = 256;

    private static void getSmallestWindowContaingAllCharacter(String text, String pattern) {
        if (text == null || pattern == null) {
            return;
        }
        int[] countArray = new int[NO_OF_CHARS];
        int[] characterCount = new int[NO_OF_CHARS];
        int[] temp = new int[NO_OF_CHARS];
        int pattern_length = pattern.length();
        for (int i = 0; i < pattern_length; ++i) {
            countArray[pattern.charAt(i)]++;
            temp[pattern.charAt(i)]++;
        }
        int text_length = text.length();
        int count = 0, start = 0;
        int m = 0, n = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < text_length; ++i) {
            char ch = text.charAt(i);
            if (ch == ' ' || countArray[ch] == 0)
                continue;
            if (countArray[ch] != 0) {
                ++characterCount[ch];
            }
            if (temp[ch] != 0) {
                ++count;
                --temp[ch];
            }
            if (count == pattern_length) {
                while (characterCount[text.charAt(start)] == 0|| characterCount[text.charAt(start)] > countArray[text.charAt(start)]) {
                    char c = text.charAt(start);
                    if (characterCount[c] > 0) {
                        --characterCount[c];
                    }
                    ++start;
                }
                if (i - start < min) {
                    min = i - start  + 1;
                    m = start;
                    n = i;
                }
            }
        }
        System.out.println(min);
    }

    public static void main(String[] args) {
        String text = "this is a test string";
        String pattern = "tist";
        getSmallestWindowContaingAllCharacter(text, pattern);
        String text1 = "azxcfghabcfghe";
        String pattern1 = "afghe";
        getSmallestWindowContaingAllCharacter(text1, pattern1);

    }
}
