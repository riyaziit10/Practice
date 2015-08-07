package main.java.com.personal.Array;

import java.util.ArrayList;

/**
 * Created by riyaz on 2/8/15.
 */
public class SameAverageSubSet {

    private static void getSubSet(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        int length = arr.length;

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < length; ++i) {
            ArrayList<ArrayList<Integer>> table = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : result) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.addAll(subset);
                temp.add(arr[i]);
                table.add(temp);
            }
            ArrayList<Integer> singleElement = new ArrayList<Integer>();
            singleElement.add(arr[i]);
            result.add(singleElement);
            result.addAll(table);
        }
        for(ArrayList<Integer> res: result)
            System.out.println(res);
//        Map<Double, ArrayList<Integer>> map = new HashMap<Double, ArrayList<Integer>>();
//        for (ArrayList<Integer> list : result) {
//            if(list.size() != 0) {
//                double average = getSum(list) / list.size();
////                System.out.println(average);
//                if(map.keySet().contains(average)) {
//                    System.out.println(average + "\t=========\t" + map.get(average));
//                }
//                else
//                     map.put(average, list);
//            }
////
//        }
//        for(Double key : map.keySet()) {
//            System.out.println(key + "\t==\t"+ map.get(key));
//        }
//        System.out.println(map.keySet());
    }

    static  double getSum(ArrayList<Integer> list) {
        if(list == null || list.size() == 0)
            return 0;
        int sum = 0;
        for(Integer i: list)
            sum += i;
        return sum;
    }
    public static void main(String[] args) {
        int[] input = {4, 2, 1, 7, 8, 3, 5};
        getSubSet(input);
    }
}
