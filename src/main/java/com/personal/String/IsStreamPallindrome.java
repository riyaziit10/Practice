package main.java.com.personal.String;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by riyaz on 8/8/15.
 */
public class IsStreamPallindrome {
    public static void main(String[] args) {
        String str = "aabaacaabaa";
        int length = str.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0;
        int oddCount = 0;
        int count = 0;
        char ch;
        while(i < length) {
            ch = str.charAt(i);
            if(map.containsKey(str.charAt(i))) {
                count =  map.get(str.charAt(i));
                map.put(str.charAt(i), count + 1);
                if(((count + 1) & 1) == 1)
                    oddCount++;
                else
                    oddCount--;
            } else  {
                map.put(str.charAt(i), 1);
                ++oddCount;
            }
            ++i;
            if(oddCount >= 2)
                System.out.println(ch + "\tNOT PALLINDROME");
            else System.out.println(ch + "\tPallindrome");
        }
    }
}
