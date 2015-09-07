package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 27/8/15.
 */
public class Stock2Purchase {
    private static int findMiniMum(int arr[] , int i) {
        int length =  arr.length;
        if(i >= length)
            return -1;
        while(i + 1 < length && arr[i] > arr[i+1]) {
            ++i;
        }
        return i;
    }

    private static int findMaximum(int arr[], int i) {
        int length = arr.length;
        if(i >= length)
            return -1;
        while(i + 1 < length && arr[i] < arr[i+1])
            ++i;
            return i;
    }

    private static int findMax(int arr[], int i) {
        int length = arr.length;
        if(i >= length)
            return -1;
        int max = i;
        while(i < length) {
            if(arr[i] > arr[max])
                max = i;
            ++i;
        }
        return max;
    }
    private static int maxProfitInSahreTrading(int arr[], int maxTransactions) {
        if(arr == null || arr.length == 0)
            return 0;
        int profit = 0;
        int count = 0;
        int i  = 0;
        int length = arr.length;
        int max = -1;
        while(i < length && count < maxTransactions) {
            int min = findMiniMum(arr, i);
            if(count + 1 == maxTransactions)
                max = findMax(arr, min + 1);
            else
                max = findMaximum(arr, min + 1);
            if(max == -1 || min == -1)
                break;
            profit += arr[max] - arr[min];
            ++count;
            i  = max + 1;

        }
        return profit;
    }
    public static void main(String[] args) {
        int price1[] = {10, 22, 5, 75, 65, 80}; // 87

        System.out.println(maxProfitInSahreTrading(price1, 2));

        int price2[] = {2, 30, 15, 10, 8, 25, 80}; // 100

        System.out.println(maxProfitInSahreTrading(price2,2));
        int price3[] = {100, 30, 15, 10, 8, 25, 80}; // 72
        System.out.println(maxProfitInSahreTrading(price3,2));
        int price4[] = {90, 80, 70, 60, 50}; // 0
        System.out.println(maxProfitInSahreTrading(price4,2));

    }
}
