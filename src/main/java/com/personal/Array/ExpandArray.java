package main.java.com.personal.Array;

/**
 * Created by riyaz on 4/8/15.
 */
public class ExpandArray {
    static void expand(char [] arr, int read,int  write) {
        if(arr == null)
            return;
        if(arr[read] == ' ')
            return;
        int num = 0;
        char ch = arr[read++];
        while(Character.isDigit(arr[read])) {
            num = num * 10 + arr[read] - '0';
            read++;
        }
        expand(arr, read, write + num);
        for(int k = 0; k < num; ++k)
            arr[write + k] = ch;

    }
    public static void main(String[] args) {
        char[] arr = "a3b1c1d1e4f0g11                 ".toCharArray();
        expand(arr,0,0);
        System.out.println(arr);
    }
}
