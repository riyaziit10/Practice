package main.java.com.personal.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by riyaz on 25/7/15.
 */
public class NextGreaterNumber {
    static boolean isUnique(String str) {
        Set<Character> set = new HashSet<Character>();
        int length = str.length();
        int i = 0 ;
        while(i < length) {
            Character digit = str.charAt(i);
            if(!set.contains(digit))
                set.add(digit);
            else {
                return false;
            }
            ++i;
        }
        return true;
    }
    static int decresingNumberIndex(String str) {
        int j = str.length() - 1;
        int i = 0;
        while( j - 1 >= 0) {
            if(str.charAt(j) > str.charAt(j - 1))
                return j - 1;
            --j;
        }
        return -1;
    }
    static String swap(String str, int i) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(length - 1));
        sb.setCharAt(str.length() - 1, str.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "534976";
        Integer number = null;
        int length = str.length();

        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Not a Valid number");
            return;
        }

        if(!isUnique(str)) {
            System.out.println("Digits are not unique");
            return;
        }
        int index = decresingNumberIndex(str);
        if(index == -1) {
            System.out.println("Next greater number is not possible");
            return;
        }
        str =  swap(str,index);
        System.out.println("Swapped String" + str);
        StringBuilder sb = new StringBuilder(str);
        int i = index + 1;
        int j = length - 1;
        while(i < j) {
            char t = sb.charAt(i);
            sb.setCharAt(i,sb.charAt(j));
            sb.setCharAt(j,t);
            ++i;
            --j;
        }
        System.out.println(sb);
    }
}
