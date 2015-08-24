package main.java.com.personal.Array.GFG;

import java.util.Random;

/**
 * Created by riyaz on 22/8/15.
 */
public class ShuffleArray {
    private  static void getShuffledArray(int arr[]) {
        if(arr == null || arr.length == 0)
            return;
        int length = arr.length;

        Random rand = new Random();
        for(int i = length - 1; i >=0; --i) {
            int j = rand.nextInt (i + 1);
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }
    private static void displayArray(int [] arr) {
        if(arr == null || arr.length == 0)
            return;

        int length = arr.length;
        for(int i = 0; i < length; ++i)
            System.out.print(arr[i] + "\t");

    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        getShuffledArray(arr);
        displayArray(arr);
    }
}
