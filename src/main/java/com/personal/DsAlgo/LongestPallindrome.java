package DsAlgo;

/**
 * Created by riyaz on 8/6/15.
 */
public class LongestPallindrome {

    public static void pallindrome(String str) {
        if(str == "" || str == null) {
            System.out.println("Please provide a valid input");
            return;
        }
        int length = str.length();
        int i,j,m,n,count = 0, max = 1, start = 0 ,last = 0 ;
        for(int k=1; k < length - 1; ++k) {
            i = k - 1;
            j= k + 1;
            while(str.charAt(i) == str.charAt(j) && i >= 0 && j < length) {
                --i;
                ++j;
                ++count;
            }
            if( count > max) {
                max = count;
                start=i + 1;
                last=j - 1;
            }
            i = k ; j = k + 1;
            count=0;
            while(str.charAt(i) == str.charAt(j) && i>=0 && j< length) {
                --i;
                ++j;
                ++count;
            }
            if( count > max) {
                max = count;
                start = i + 1;
                last=j - 1;
            }
        }
        System.out.println("maximum substring is of " + max + "length" + "\t" + "("+ start +
                "," + last + ")" + "\t" + str.substring(start, last + 1));
    }
    public static void main(String[] args) {

        String str = "BBABCBAB";
        pallindrome(str);

    }
}
