package main.java.com.personal.String;

/**
 * Created by riyaz on 9/8/15.
 */
public class FirstNonRepeatingCharacter {
    private static final int NO_OF_CHARS = 256;
    private static class CountIndex {
        int count;
        int index;

        public CountIndex() {
            this.count = 0;
            this.index = -1;
        }

        public CountIndex(int count, int index) {
            this.count = count;
            this.index = index;
        }

        @Override
        public String toString() {
            return "CountIndex{" +
                    "count=" + count +
                    ", index=" + index +
                    '}';
        }
    }
    private static void getFirstNonRepeatingChar(String str) {
        if(str == null || str.length() == 0)
            return;
        int length = str.length();
        CountIndex [] countIndexes = new CountIndex[NO_OF_CHARS];
        for(int i = 0; i < NO_OF_CHARS; ++i)
            countIndexes[i] = new CountIndex();
        for(int i = 0; i < length; ++i) {
            char ch = str.charAt(i);
            countIndexes[ch].count += 1;
            if(countIndexes[ch].count == 1) {
                countIndexes[ch].index = i;
            }
        }
        char resultChar=' ';
        int index=Integer.MAX_VALUE;
        for(int i = 0 ; i < NO_OF_CHARS; ++i) {
            if(countIndexes[i].count == 1 && countIndexes[i].count < index) {
                index = countIndexes[i].count;
                resultChar = (char)i;
            }
        }
        if(index == -1) {
            System.out.println("NO UNIQUE LETTER FOUND");
            return;
        }
        System.out.println("UNIQUE LETTER\t" + resultChar);

    }
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        getFirstNonRepeatingChar(str);
        String str1 = "GeeksQuiz";
        getFirstNonRepeatingChar(str1);

    }
}
