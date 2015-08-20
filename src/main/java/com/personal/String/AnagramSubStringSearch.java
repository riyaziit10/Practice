package main.java.com.personal.String;

/**
 * Created by riyaz on 16/8/15.
 */
public class AnagramSubStringSearch {
    private static final int NO_OF_CHARS = 256;
    private static boolean compare(int [] arr1, int arr2[]) {
        for(int i = 0; i < NO_OF_CHARS; ++i) {
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    private static void searchSubString(String text, String pattern) {
        if(text == null && pattern == null)
            return;
        if(text.length() < pattern.length())
            return;
        int text_length = text.length();
        int pattern_length = pattern.length();
        int [] patternCount = new int[NO_OF_CHARS];
        int [] windowCount = new int[NO_OF_CHARS];

        for(int i = 0; i < pattern_length; ++i) {
                ++patternCount[pattern.charAt(i)];
                ++windowCount[text.charAt(i)];
        }
        int i = 0;
        for(i = pattern_length; i < text_length; ++i) {
            if(compare(patternCount, windowCount)) {
                System.out.println("Found @ index \t" + (i - pattern_length));
            }
            ++windowCount[text.charAt(i)];
            --windowCount[text.charAt(i - pattern_length)];
        }
        if(compare(patternCount, windowCount)) {
            System.out.println("Found @ index \t" + (i - pattern_length));
        }

    }
    public static void main(String[] args) {
        String text = "BACDGABCDA";
        String pattern = "ABCD";
        searchSubString(text, pattern);
    }
}
