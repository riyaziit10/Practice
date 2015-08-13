package main.java.com.personal.String;

/**
 * Created by riyaz on 9/8/15.
 */
public class LongestSubStringWithKUniqueCharacters {
    private static void longestStringWithKUniqueCharacters(String str, int k) {
        if (str == null || str.length() == 0 || k == 0 || k > str.length())
            return;
        int i = 0;
        int j = 0;
        int length = str.length();
        int[] map = new int[256];
        System.out.println(map[0]);
        int uniqueCount = 0;
        int max = 0;
        int start=0,end=0;
        while (i < length) {
            if (map[str.charAt(i)] == 0) {
                ++uniqueCount;
                if (uniqueCount > k) {
                    while (uniqueCount > k) {
                        map[str.charAt(j)]--;
                        if (map[str.charAt(j)] == 0)
                            --uniqueCount;
                        ++j;
                    }
                }
            }
            if (uniqueCount == k && i - j + 1 > max) {
                max = i - j + 1;
                start = j;
                end = i;

            }
            map[str.charAt(i)]++;
            i++;
        }
        if(max != 0)
            System.out.println("string\t"  + str.substring(start, end+1) + "\tstart\t" + start + "\tend\t" + end + "\tmax\t" +  max);
        else {
            System.out.println("Not Possible");
        }
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
//        String s = "aabbcc";
//        String s = "aaabbb";
        int k = 3;
        longestStringWithKUniqueCharacters(s, k);
    }
}
