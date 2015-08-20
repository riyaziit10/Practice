package main.java.com.personal.Random;

/**
 * Created by riyaz on 14/8/15.
 */
public class CycleLeader {
    private static void getCycleLeader(char [] str, int length, int shifts) {
        for(int i = 1; i < length; i = i *3) {
            int j = i;
            char item = str[shifts + j];
            do {
                if((j & 1) == 1) {
                    j = length / 2 + j / 2;
                } else {
                    j = j / 2;
                }
                char temp = str[j + shifts];
                str[j + shifts] = item;
                item = temp;
            }while(j !=  i);
        }
    }
    private static void reverse(char [] arr, int i , int j) {
        char ch;
        while(i < j) {
            ch = arr[i];
            arr[i] = arr[j];
            arr[j] = ch;
            ++i;
            --j;
        }
    }
    private static void shiftRight(char [] str) {
        if(str == null) {
            System.out.println("String is Empty");
            return;
        }
        int length = str.length;
        int shift = 0;
        int remainingLength = length;
        while(remainingLength >= 0) {
            int k = 0;
            while(Math.pow(3,k) <= remainingLength){
                ++k;
            }
            int lenFirst = (int) (Math.pow(3, k - 1) + 1);
            remainingLength = remainingLength - lenFirst;
            getCycleLeader(str, lenFirst, shift);
            // Step 4.1: Reverse the second half of first subarray
            reverse ( str, shift / 2, shift - 1 );

            // Step 4.2: Reverse the first half of second sub-string.
            reverse ( str, shift, shift + lenFirst / 2 - 1 );

            // Step 4.3 Reverse the second half of first sub-string and first
            // half of second sub-string together
            reverse ( str, shift / 2, shift + lenFirst / 2 - 1);
            shift += lenFirst;

        }

    }
    public static void main(String[] args) {
        char [] str = "a1b2c3d4e5f6g7h8i9".toCharArray();
        shiftRight(str);
        System.out.println(new String(str));

    }
}
