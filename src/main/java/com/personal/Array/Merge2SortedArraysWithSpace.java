package main.java.com.personal.Array;

import java.util.Arrays;

/**
 * Created by riyaz on 25/7/15.
 */
public class Merge2SortedArraysWithSpace {
    public static void main(String[] args) {
        int [] arrA = {100, 200, 300, 400, 0, 0, 0, 0};
        int [] arrB = {15, 25, 35, 45};
        int arrALength = 4;
        int arrBLength = 4;
        int end = 8;
        while(arrBLength > 0 && arrALength > 0) {
            if(arrB[arrBLength - 1] > arrA[arrALength - 1]) {
                arrA[end - 1] = arrB[arrBLength - 1];
                arrBLength--;
            }else {
                arrA[end - 1] = arrA[arrALength - 1];
                arrALength--;
            }
            end --;
        }
        if(arrBLength > 0) {
            while (arrBLength > 0) {
                arrA[end - 1] = arrB[arrBLength - 1];
                arrBLength--;
                end--;
            }
        }
        System.out.println(Arrays.toString(arrA));
    }
}
