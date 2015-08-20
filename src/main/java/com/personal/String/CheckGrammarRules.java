package main.java.com.personal.String;

/**
 * Created by riyaz on 16/8/15.
 */
public class CheckGrammarRules {
    private static boolean isSentenceValid(String str) {
        if(str == null || str.length() == 0)
            return true;
        int length = str.length();
        if(str.charAt(0)< 'A' || str.charAt(0) > 'Z')
            return false;
        if(str.charAt(length - 1) != '.')
            return false;

        int i = 1;
        int prev_state = 0;
        int curr_state = 0;
        while(i < length) {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                curr_state = 0;
            else if(str.charAt(i) == ' ')
                curr_state = 1;
            else if(str.charAt(i) >= 'a' || str.charAt(i) <= 'z')
                curr_state= 2;
            else if(str.charAt(i) == '.')
                curr_state = 3;

            if(prev_state == curr_state && curr_state!=2)
                return false;

            if(prev_state == 2 && curr_state == 0)
                return false;
            if(curr_state == 3 && i+1 != length)
                return false;
            ++i;
            prev_state = curr_state;
        }
        return true;

    }
    public static void main(String[] args) {
        String str[] = {"I love cinema.", "The vertex is S.",
                "I am single.", "My name is KG.",
                "I lovE cinema.", "GeeksQuiz. is a quiz site.",
                "I love Geeksquiz and Geeksforgeeks.",
                "  You are my friend.", "I love cinema" };

        int length = str.length;
        for(int i = 0; i < length; ++i)
            System.out.println(isSentenceValid(str[i]));
    }
}
