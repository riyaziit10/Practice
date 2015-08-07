package main.java.com.personal.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by riyaz on 2/8/15.
 */
public class AnagramSort {
    public static class Anagram implements Comparable<Anagram>{
        String str;

        public Anagram(String str) {
            this.str = str;
        }

        public String getSortedString() {
            char [] arr = str.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }

        @Override
        public int compareTo(Anagram str) {
            return getSortedString().compareTo(str.getSortedString());
        }
    }
    static void getAnagramSort(String [] strArray) {
        if(strArray == null || strArray.length == 0)
            return;
        List<Anagram> list = new ArrayList<Anagram>();
        for(String str: strArray) {
            list.add(new Anagram(str));
        }
        Collections.sort(list);
        int length = strArray.length;
        for(int i = 0 ; i < length; ++i)
            strArray[i] = list.get(i).str;

    }
    public static void main(String[] args) {
        String[]stringArr={"dog","listen","tip","enlist","pit","god","man","top","pot"};
        getAnagramSort(stringArr);
        System.out.println(Arrays.toString(stringArr));
    }
}
