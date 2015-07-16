package Array;

/**
 * Created by riyaz on 27/6/15.
 */
public class LargestPairSum {
    private static int largestPairSum(int []arr) {
        int arrLength = arr.length;
        if(arrLength < 2) {
            System.out.println("Size of array mmust be greater than 2");
            return 0;
        }
        int firstMax = Math.max(arr[0], arr[1]);
        int sexondMax = Math.min(arr[0],arr[1]);

        for(int i = 2 ; i <arrLength; ++i) {
            if(arr[i] > firstMax) {
                sexondMax = firstMax;
                firstMax=arr[i];
            }
        }

        return firstMax + sexondMax;
    }
    public static void main(String[] args) {
        int arr[] = {12, 34, 10, 6, 40};
        System.out.println("Largest Pair sum\t" + largestPairSum(arr));
    }
}
