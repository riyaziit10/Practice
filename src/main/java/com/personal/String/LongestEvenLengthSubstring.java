package main.java.com.personal.String;

/**
 * Created by riyaz on 8/8/15.
 */
public class LongestEvenLengthSubstring {

    private static int getLengthV1(String str) {
        if(str == null || str.length() == 0)
            return 0;
        int length = str.length();
        int [] sum = new int[length + 1];
        for (int i = 1; i <= length; ++i) {
            sum [i] = sum[i - 1] + str.charAt(i - 1) - '0';
        }
        int ans=0;
        for(int len = 2; len<= length; len += 2) {
            for(int i = 0; i <= length - len; ++i) {
                if(sum[i + len/2] - sum[i] == sum[i + len] - sum[i+len/2])
                    ans = Math.max(ans,len);
            }
        }
        return ans;
    }
    private static int getSum(char[] str, int i, int j) {
        if (str == null || str.length == 0)
            return 0;
        int sum = 0;
        while (i <= j) {
            char ch = str[i];
            if (ch < '0' && ch > '9') {
                System.out.println("Input is not valid");
                return -1;
            }
            sum += str[i] - '0';
            ++i;
        }
        return sum;
    }

    private static boolean getLongestLengthSubString(char[] str, int i, int j, int[] max) {
        if (i > j)
            return false;
        if ((j - i) % 2 != 0) {
            int mid = (i + j) / 2;
            int leftSum = getSum(str, i, mid);
            int rightSum = getSum(str, mid + 1, j);
            if ( leftSum == rightSum) {
                if (j - i + 1 > max[0]) {
                    max[0] = j - i + 1;
                    System.out.println("leftSum \t" +  leftSum + "\t rightSum \t" + rightSum + "\tj\t" + j  + "\ti\t" + i);
                    return true;
                }
            } else {
                return getLongestLengthSubString(str, i + 1, j, max) || getLongestLengthSubString(str, i, j - 1, max);
            }
        } else {
            return getLongestLengthSubString(str, i + 1, j, max) || getLongestLengthSubString(str, i, j - 1, max);
        }
        return false;
    }

    public static void main(String[] args) {
        String input = "1538023";
//        String input = "123123";
        int[] max = new int[]{0};
        System.out.println(getLongestLengthSubString(input.toCharArray(), 0, input.length() - 1, max));
        System.out.println(max[0]);

        System.out.println("v1\t" + getLengthV1(input));
//        System.out.println(getSum(input.toCharArray(), 0, input.length()));
    }

}
