package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 26/8/15.
 */
public class MultipleOf3 {

    private static int getCount(int arr[]) {
        if(arr == null || arr.length == 0)
            return -1;
        int count[] = new int[3];

        int length = arr.length;
        for(int i  = 0; i < length; ++i) {
            ++count[arr[i]%3];
        }

        int result = 0;

        result += (count[0] * (count[0] - 1) >> 1);

        result += count[1] * count[2];

        result += (count[0] * (count[0] - 1) * (count[0] - 2)) / 6;

        result += (count[1] * (count[1] - 1) * (count[1] - 2)) / 6;

        result += (count[2] * (count[2] - 1) * (count[2] - 2)) / 6;

        result +=  (count[0] * count[1] * count[2]);

        return result;
    }
    public static void main(String[] args) {
        int  arr1[] = {3, 6, 7, 2, 9}; // 8
        System.out.println("arr1\t" + getCount(arr1));
        int arr2[] = {2, 1, 3, 4}; //4
        System.out.println("arr2 \t" + getCount(arr2));
    }
}
