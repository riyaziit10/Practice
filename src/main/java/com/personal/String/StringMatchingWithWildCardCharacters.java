package main.java.com.personal.String;

/**
 * Created by riyaz on 15/8/15.
 */
public class StringMatchingWithWildCardCharacters {
    private static  boolean isMatched(String str1, String str2, int i , int j) {
        if(str1 == null && str2 == null)
            return true;
        if(str1 == null || str2 == null)
            return false;
        int str1_length = str1.length();
        int str2_length = str2.length();
        if(i == str1_length && j == str2_length)
            return true;
        if(i == str1_length || j == str2_length) {
            return false;
        }
        if(str1.charAt(i) == '?' || str1.charAt(i) == str2.charAt(j))
            return isMatched(str1, str2, i + 1, j + 1);
        else if(str1.charAt(i) == '*') {
            if(i + 1 == str1_length)
                return true;
            else
                return isMatched(str1, str2, i, j + 1) || isMatched(str1, str2, i + 1, j);
        }

        return false;
    }
    public static void main(String[] args) {
        System.out.println(isMatched("g*ks", "geeks", 0, 0)); // Yes
        System.out.println(isMatched("ge?ks*", "geeksforgeeks", 0, 0)); // Yes("g*k", "gee");
        System.out.println(isMatched("g*k", "gee",0,0));// No because 'k' is not in second
        System.out.println(isMatched("*pqrs", "pqrst", 0, 0)); // No because 't' is not in first
        System.out.println(isMatched("abc*bcd", "abcdhghgbcd",0,0)); // Yes
        System.out.println(isMatched("abc*c?d", "abcd", 0, 0)); // No because second must have 2 instances of 'c'
        System.out.println(isMatched("*c*d", "abcd", 0,0)); // Yes
        System.out.println(isMatched("*?c*d", "abcd", 0, 0)); // Yes
    }
}
