package Array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by riyaz on 27/6/15.
 */
public class PythagoreanTriplet {

    private  static boolean isTriplet(int [] arr){
        int arrLength = arr.length;
        for(int i = 0; i < arrLength; ++i)
            arr[i] =(int) Math.pow(arr[i],2);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //ToDo : remember these array is sorted so travcerse backward
        for(int i = arrLength - 1; i >= 2; --i) {
            int left = 0;
            int right = i - 1 ;
            while(left < right) {
                int sum = arr[left] + arr[right];
                if( sum == arr[i]) {
                    System.out.println("numbers are\t" + left + "\t" + right +"\t" + i);
                    return true;
                }
                if(sum < arr[i])
                 ++left; else --right;
            }

        }
        return false;
    }

    private static boolean isTripletV2(int [] arr) {
        HashSet squares = new HashSet();
        for(int i: arr)
            squares.add(i * i);
        int arrLength = arr.length;
        for(int i = 0; i < arrLength - 1; ++i) {
            for(int j = i + 1; j < arrLength; ++j) {
                int square = arr[i] * arr[i] + arr[j] * arr[j];
                if(squares.contains(square)) {
                    System.out.println("Elements are" + arr[i] + "\t" + arr[j] + "\t" + Math.sqrt(square));
                }
            }
        }
        return false;

    }
    public static void main(String[] args) {
//        int ar[] = {3, 1, 4, 6, 5};
        int[] ar = { 2, 3, 4, 6, 7, 12, 13, 15, 5, 17, 14, 22 };
//        if(isTriplet(ar))
//            System.out.println("yes");
//        else
//            System.out.println("No");

        isTripletV2(ar);
    }
}
