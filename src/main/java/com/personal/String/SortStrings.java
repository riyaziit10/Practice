package main.java.com.personal.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by riyaz on 14/8/15.
 */
public class SortStrings {
    public static class SortCharacters implements Comparable {
        public String string;

        public SortCharacters(String string) {
            this.string = string;
        }

        public String getString() {
            return string;
        }

        public String sortCharacters() {
            char [] arr = string.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }

        @Override
        public int compareTo(Object o) {
            return sortCharacters().compareTo(((SortCharacters)o).sortCharacters());

        }
    }
    private static void sort(String [] str) {
        if (str == null)
            return;
        int length = str.length;
        List<SortCharacters> list = new ArrayList<SortCharacters>();
        for (String string : str) {
            list.add(new SortCharacters(string));
        }
        Collections.sort(list);
        for (int i = 0; i < length; ++i){
            str[i] = list.get(i).string;
        }
    }
    public static void main(String[] args) {
        String []  str = {"cat", "dog", "tac", "god", "act"};
        sort(str);
        for(String s : str) {
            System.out.println(s);
        }
    }
}
