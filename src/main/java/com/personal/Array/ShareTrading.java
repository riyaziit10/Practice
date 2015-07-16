package Array;

/**
 * Created by riyaz on 28/6/15.
 */

public class ShareTrading {
    private static int soldShare(int []arr, int i){
        int arrLength = arr.length;
        while(i + 1 < arrLength && arr[i] < arr[i+1])
            ++i;
        if(i == arrLength)
            return -1;
        return i;
    }
    private static int purchaseShare(int [] arr, int i){
        int arrLength = arr.length;
        while(i + 1 < arrLength && arr[i] > arr[i+1])
            ++i;
        if(i == arrLength)
            return -1;
        return i;
    }
    public static void main(String[] args) {
//        int [] price = {10, 22, 5, 75, 65, 80};
//        int price[] = {2, 30, 15, 10, 8, 25, 80};
//       int  price[] = {100, 30, 15, 10, 8, 25, 80};
        int price[] = {90, 80, 70, 60, 50};
        int sold=soldShare(price,0);
        if(sold == -1) {
            System.out.println("No Profit");
            return;
        }
        int profit = price[sold] - price[0];

        int purchase = purchaseShare(price, sold + 1);

        if(purchase == -1 || purchase == price.length - 1){
            System.out.println("Total profit" + profit);
            return;
        }
        int k = purchase + 1;
        int max = 0;
        while(k < price.length) {
            if(max < price[k])
                max = price[k];
            ++k;
        }
         profit += max - price[purchase];
        System.out.println("Total profit will be" + profit);

    }
}
