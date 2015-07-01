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
        return isPartitionPossible(arr, i - 1, sum) || isPartitionPossible(arr, i - 1, sum - arr[i]);
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
        if(sum % 2 != 0){
            System.out.println("Not possible: sum is odd");
            return;
        }
        System.out.println(isPartitionPossible(arr,arrLength,sum/2));

    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,6,4,5,7};
        equalSumPartition(arr);
    }
}
