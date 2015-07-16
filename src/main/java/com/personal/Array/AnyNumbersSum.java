package Array;

/**
 * Created by riyaz on 29/6/15.
 */
public class AnyNumbersSum {
    static boolean isSum(int [] arr,int i, int sum, int totalSum) {
        if(sum == 0)
            return true;
        if(i < 0 || sum < 0 || totalSum < sum)
            return false;
        if(isSum(arr, i - 1, sum,totalSum)) {
            return true;
        }
        if(isSum(arr, i -1, sum - arr[i],totalSum)) {
            if(arr[i] <= sum)
                System.out.println(arr[i]);
            return true;
        }
        return  false;
    }

    static boolean isSumV2(int [] arr, int sum) {
        if(sum == 0)
            return true;
        int arrLength = arr.length;
        if(arrLength == 0)
            return false;

        int [] [] tempTable = new int[sum + 1][arrLength + 1];
        for(int i = 0; i <= arrLength; ++i)
            tempTable[0][i] = 1;
        for(int i = 1; i <= sum; ++i){
            for(int j = 1; j <= arrLength; ++j) {
                    if( i == arr[j-1])
                        tempTable[i][j] = i;
                    else if( i < arr[j-1])
                        tempTable[i][j] = tempTable[i][j-1];
                    else
                        tempTable[i][j] = tempTable[i - arr[j-1]][j-1] == i - arr[j-1] ? i : tempTable[i][j-1];
            }
        }
        for(int i = 0; i <= sum; ++i) {
            for (int j = 0; j <= arrLength; ++j)
                System.out.print(" " + tempTable[i][j]);
            System.out.println();
        }
        return tempTable[sum][arrLength] == sum;

    }
    public static void main(String[] args) {
        int[] arr = {4,1,2,8};
        int arrLength = arr.length;
        int totalSum = 0;
//        for(int i = 0; i < arrLength; ++i)
//            totalSum += arr[i];                 // this will give the same performance as DP version
//        System.out.println(isSum(arr, arr.length - 1, 9, totalSum));
        System.out.println(isSumV2(arr, 6));
    }
}
