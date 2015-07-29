package main.java.com.personal.String;

/**
 * Created by riyaz on 26/7/15.
 */
public class ReverseWords {
    static void reverse(char [] arr , int s, int e) {
        while(s < e) {
            char t = arr[s];
            arr[s] = arr[e];
            arr[e] = t;
            ++s;
            --e;
        }
    }
    static String reverseWords(String str) {
        if(str == null || str == "")
            return str;
        char [] arr = str.toCharArray();
        int length = arr.length;
        reverse(arr, 0, length - 1);
        System.out.println(arr);
        int start = 0;
        for(int i = 0 ; i < length; ++i) {
            if(arr[i] == ' ') {
                reverse(arr, start, i - 1);
                start = i + 1;
            }
        }
        reverse(arr, start, length - 1);
        return new String (arr);
    }
    public static void main(String[] args) {
        String str = "My name is Riyaz Ali";
        String reverseWords = reverseWords(str);
        System.out.println(reverseWords);
    }
}
