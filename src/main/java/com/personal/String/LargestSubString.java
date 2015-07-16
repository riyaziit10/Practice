package String;

/**
 * Created by riyaz on 5/7/15.
 */
public class LargestSubString {
    static String findLargest(String str){
        if(str == "" || str == null)
            return null;
        if(str.length() == 1)
            return  str;
        int length = str.length();
        int max =0;
        int count = 1;
        int s = 0;
        int e = 0;
        for(int i = 1 ; i < length; ++i){
            int left = i - 1;
            int right = i + 1;
            count = 1;
            while(left>=0 && right < length && str.charAt(left) == str.charAt(right)){
                count += 2;
                --left;
                ++right;
            }
            if(count > max) {
                s = ++left;
                e = --right;
                max = count;
            }
            count = 0;
            left = i;
            right = i + 1;
            while(left >= 0 && right < length && str.charAt(left) == str.charAt(right)){
                count +=2;
                --left;
                ++right;
            }
            if(count > max) {
                s = ++left;
                e= --right;
                max = count;
            }
        }
        System.out.println("Maximum size palindrome is \t" + max + "\t" + s + "\t" + e);
        return str.substring(s, 1 + e);
    }
    public static void main(String[] args) {
//        String str = "abccbabacbcacba";
        String str = "malayalam";
        String result = findLargest(str);
        System.out.println(result);
    }
}
