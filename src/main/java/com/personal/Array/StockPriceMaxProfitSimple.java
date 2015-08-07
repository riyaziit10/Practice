package main.java.com.personal.Array;

/**
 * Created by riyaz on 4/8/15.
 */
public class StockPriceMaxProfitSimple {
    static int getMaximumProfitV2(int [] arr) {
        if(arr == null)
            return 0;
        int length = arr.length;
        if(length == 0)
            return 0;
        int profit = 0;
        int previous = arr[0];
        for(int i = 0 ; i < length; ++i) {
            if(arr[i] > previous)
                profit += arr[i] - previous;
            previous=arr[i];
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] prices = { 400, 402, 435, 398, 378, 400, 432, 432, 402 };
//        int[] prices = { 10,9,8,7,6,5};
        System.out.println(getMaxProfit(prices));
        System.out.println("===========" + getMaximumProfitV2(prices));
        System.out.println(getMaxProfitRecursive(prices,0,3,false));
    }

    private static int getMaxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int previousPrice = prices[0];
        int profit = 0;
        int k = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] > previousPrice) {

                profit += (prices[i] - previousPrice);
                ++k;
                if(k == 3)
                    return profit;
            }
            previousPrice = prices[i];
        }
        return profit;
    }
    public static int getMaxProfitRecursive(int[] prices, int startDay,
                                   int maxTransaction, boolean hasStock) {
        if (maxTransaction == 0 || startDay == prices.length)
            return 0;
        if (hasStock) {
            return Math.max(
                    getMaxProfitRecursive(prices, startDay + 1, maxTransaction, true),
                    getMaxProfitRecursive(prices, startDay + 1, maxTransaction - 1,
                            false) + prices[startDay]);
        } else {
            return Math.max(
                    getMaxProfitRecursive(prices, startDay + 1, maxTransaction, false),
                    +getMaxProfitRecursive(prices, startDay + 1, maxTransaction - 1,
                            true) - prices[startDay]);
        }
    }
}
