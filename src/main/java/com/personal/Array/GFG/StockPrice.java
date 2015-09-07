package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 25/8/15.
 */
public class StockPrice {
    private static  int getMaxProfit(int arr[]) {
        if(arr == null || arr.length == 0)
            return - 1;
        int length = arr.length;
        int purchase = Integer.MAX_VALUE;
        int profit = 0;
        for(int i  = 0 ; i < length; ++i) {
            if(arr[i] > purchase) {
                profit += arr[i] - purchase;
            }
            purchase = arr[i];
        }
        return profit;
    }
    public static void main(String[] args) {
        int price[] = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(getMaxProfit(price));
    }
}
