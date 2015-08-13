package main.java.com.personal.String;

import java.util.Stack;

/**
 * Created by riyaz on 9/8/15.
 */
public class DepthOfParenthisis {
    private static int  getDepth (String str) {
        if(str == null || str.length() == 0)
            return 0;
        str = str.replaceAll("\\s+", "");
        int length = str.length();
        int i  = 0;
        Stack<Character> stack = new Stack<Character>();
        int max = 0;
        int curr_max  = 0;
        char ch;
        while(i < length) {
            ch = str.charAt(i);
            if(ch == '(') {
                ++curr_max;
                if(curr_max > max)
                    max= curr_max;
            }
            else if(ch == ')') {
                if(curr_max > 0)
                    --curr_max;
                else
                    return -1;
            }
            ++i;
        }
        if(curr_max  != 0)
            return - 1;
        else return max;
    }
    public static void main(String[] args) {
        String str1 =  "( ((X)) (((Y))) )";
        String str2 = "( a(b) (c) (d(e(f)g)h) I (j(k)l)m)";
        String str3 = "( p((q)) ((s)t) )";
        String str4 = "b) (c) ()";
        String str5 = "(b) ((c) ()";
        System.out.println(getDepth(str5));
    }
}
