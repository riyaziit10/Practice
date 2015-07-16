package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by riyaz on 29/6/15.
 */
public class UniqueSubstring {
    public static void main(String[] args) {
        String str = "abacbdadbc";
        char [] chars = str.toCharArray();
        int strLength = chars.length;
        System.out.println(strLength + " \t" + new String(chars));
        int max = 0, count = 0;
        Map<Character,Integer>  hashMap = new HashMap<Character, Integer>();
        for(int i = 0; i < strLength; ++i) {
            if(!hashMap.containsKey(chars[i])) {
                hashMap.put(chars[i],i);
                ++count;
            } else {
                int index = hashMap.get(chars[i]);
                hashMap.put(chars[i],index);
                if(i - index > count) {
                    ++count;
                } else {
                    if(count > max) {
                        max = count;
                        count=0;
                    }

                }

            }
        }
        System.out.println("Size of unique subString is \t" + max);
    }
}
