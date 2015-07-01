package Array;

/**
 * Created by riyaz on 29/6/15.
 */
public class AnyNumbersSum {
    static boolean isSum(int [] arr,int i, int sum) {
        if(sum == 0)
            return true;
        if(i < 0 || sum < 0 )
            return false;
        return isSum(arr, i - 1, sum) || isSum(arr, i -1, sum - arr[i]);
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
                        tempTable[i][j] = 1;
                    else if( i < arr[j-1])
                        tempTable[i][j] = tempTable[i][j-1];
                    else
                        tempTable[i][j] = tempTable[i][j-1] != 0 ? 1 :  tempTable[i - arr[j-1]][j-1];
            }
        }
        for(int i = 0; i <= sum; ++i) {
            for (int j = 0; j <= arrLength; ++j)
                System.out.print(" " + tempTable[i][j]);
            System.out.println();
        }
        return tempTable[sum][arrLength] == 0 ? false :true;
    }
    public static void main(String[] args) {
        int[] arr = {4,6,2,8};
//        System.out.println(isSum(arr, arr.length - 1, 7));
        System.out.println(isSumV2(arr,10));
    }
}
