package DsAlgo;

/**
 * Created by riyaz on 31/5/15.
 */
public class LargesSumContiguousSubArray {
    static void maxSumSubArray(int[] arr) {
        int c_sum=0, max = 0;
        for(int i : arr) {
            c_sum += i;

            if(c_sum < 0)
                c_sum = 0;
            if(c_sum > max)
                max = c_sum;
        }
        System.out.println("maximum contiguous sum is \t" + max);

    }
    public static void main(String[] args) {
        int[] arr =
                { -2, -3, 4, -1, -2, 1, 5, -3};
        maxSumSubArray(arr);
    }
}
