package main.java.com.personal.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by riyaz on 5/8/15.
 */
public class OneWordPermutationOfOther {
    //complexcity o(nlog n)
    static boolean isPermutation(String a, String b) {
        if( a == null && b == null)
            return true;
        if(a == null || b == null)
            return false;
        if(a.length() != b.length())
            return false;
        char [] arr1 = a.toCharArray();
        char [] arr2 = b.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1) + "\t" + Arrays.toString(arr2));
        if(Arrays.equals(arr1,arr2))
            return true;
        return false;

    }

    static boolean isAnagram(String a, String b) {
        if(a == null && b == null)
            return true;
        if(a == null || b == null)
            return false;
        int  a_length = a.length();
        int b_length = b.length();
        if(a_length!= b_length)
            return false;
        Map<Character, Integer> map = new HashMap<Character, Integer>(256);

        for(int i = 0 ; i < a_length; ++i) {
            char ch = a.charAt(i);
            if(!map.keySet().contains(ch)) {
                map.put(ch,1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        for(int i = 0; i < b_length; ++i) {
            char ch = b.charAt(i);
            if(!map.keySet().contains(ch)) {
                return false;
            } else {
                int count =  map.get(ch);
                if(count - 1 == 0)
                    map.keySet().remove(ch);
                else
                    map.put(ch, count - 1);
            }
        }
        return map.keySet().isEmpty() ? true : false;
    }
    public static void main(String[] args) {
        String a = "listexn";
        String b = "enlistn";
        System.out.println(isPermutation(a, b));
        System.out.println(isAnagram(a,b));
    }
}
