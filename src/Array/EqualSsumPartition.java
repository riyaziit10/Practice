package Array;

/**
 * Created by riyaz on 30/6/15.
 */
public class EqualSsumPartition {
    private static boolean isPartitionPossible(int [] arr,int i, int sum){
        if( i < 0 || sum < 0)
            return false;
        if(sum == 0)
            return true;
        if(isPartitionPossible(arr, i - 1, sum)) {
            return true;
        }
        if(isPartitionPossible(arr, i - 1, sum - arr[i])) {
            if(arr[i] <= sum)
                System.out.println(arr[i]);
            return true;
        }
        return  false;
    }
    private static void equalSumPartition(int [] arr) {
        int arrLength = arr.length;
        if(arr.length == 0){
            System.out.println("Not possible:Array is Empty");
            return;
        }
        int sum=0;
        for(int i=0; i<arrLength; ++i)
            sum+= arr[i];
        System.out.println("Total sum is \t" + sum);
        if(sum % 2 != 0){
            System.out.println("Not possible: sum is odd");
            return;
        }
        System.out.println(isPartitionPossible(arr,arrLength,sum/2));

    }

    static boolean partition(int [] arr,  int sum){
        int length = arr.length;
        int [][]memorization = new int[sum+1][length+1];
        for(int i = 1; i <= sum ; ++i) {
            for(int j = 1; j <=length; ++j) {
                if(arr[j-1] == i)
                    memorization[i][j] = i;
                else if(arr[j-1] > i)
                    memorization[i][j] = memorization[i][j-1];
                else
                    memorization[i][j] = memorization[i-arr[j-1]][j-1] == i - arr[j-1] ? i : memorization[i][j-1];
            }
        }
        if(sum != memorization[sum][length])
            return  false;
        int i = sum, j = length;
        while(i > 0 && j > 0) {
            if(memorization[i][j] == i && i  - arr[j-1] >= 0) {
                if(memorization[i-arr[j-1]][j-1] == i - arr[j-1]) {
                    System.out.println("elements are " + arr[j - 1]);
                    i = i - arr[j - 1];
                }
            }
            --j;
        }
        return true;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,6,4,5,7};
        equalSumPartition(arr);
        partition(arr, 12);
    }
}
