package main.java.com.personal.Array;

import java.util.BitSet;

/**
 * Created by riyaz on 12/7/15.
 */
public class MissingNumberInArray {
    static void printMissingNumber(int []arr, int n) {
        int missingCount = n - arr.length;
        BitSet bitSet = new BitSet(n);
        for(int i : arr){
            bitSet.set(i);
        }
        int lastMissingIndex = 1;
        for(int i = 0; i < missingCount; ++i) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println("missing number is \t" + (lastMissingIndex++));
        }
    }
    public static void main(String[] args) {
        printMissingNumber(new int[]{0, 2, 3, 4, 6}, 7);
    }
}
