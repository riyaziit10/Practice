package main.java.com.personal.Array;

/**
 * Created by riyaz on 13/7/15.
 */
public class PotsOfGoldGame {
    private static int gameTheory(int [] arr, int i, int n){
        if(i == n)
            return arr[i];
        if( i + 1 == n)
            return Math.max(arr[i], arr[n]);
        int firstPicked = arr[0] + Math.min(gameTheory(arr, i + 2, n), gameTheory(arr, i + 1, n - 1));
        int lastPicked = arr[n] + Math.min(gameTheory(arr, i + 1, n-1), gameTheory(arr, i, n - 2));
        return  Math.max(firstPicked, lastPicked);

    }
    private static int getMaxGold(int [] goldCoins) {
        int length = goldCoins.length;
        Integer [][] memo = new Integer[length][length];
        return getMaxGold(goldCoins, 0, length - 1, memo);
    }
    private  static int getMaxGold(int [] goldCoins, int startIndex, int endIndex, Integer [][]memo) {

        if(startIndex > endIndex) {
            return 0;
        }

        if(memo[startIndex][endIndex] != null)
            return memo[startIndex][endIndex];

        int x = getMaxGold(goldCoins, startIndex + 2, endIndex, memo);
        int y = getMaxGold(goldCoins, startIndex + 1, endIndex - 1, memo);
        int z = getMaxGold(goldCoins, startIndex, endIndex - 2, memo);
        int start = goldCoins[startIndex] + Math.min(x,y);
        int end = goldCoins[endIndex] + Math.min(y,z);
        memo[startIndex][endIndex] = Math.max(start, end);
        return memo[startIndex][endIndex];

    }
    public static void main(String[] args) {
//        int [] goldCoins = {5, 3, 7, 10};
        int [] goldCoins = {8, 15, 3, 7};

        System.out.println(gameTheory(goldCoins, 0, goldCoins.length - 1));
        System.out.println("============================================");
        System.out.println(getMaxGold(goldCoins));
    }
}