package main.java.com.personal.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by riyaz on 2/8/15.
 */
public class IncreasingArraySubsequenceV2 {
    static void showResult(ArrayList<ArrayList<Integer>> result) {
        for(ArrayList<Integer> sublist : result) {
            System.out.println(sublist);
        }
    }
    static List<Integer> getIncreasingSubSequence(int [] arr) {
        int length = arr.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = 0 ; i < length; ++i) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();//ArrayList<Integer>();
            for(ArrayList<Integer> subList : result){
                if(subList.get(subList.size() - 1) <= arr[i]) {
                    ArrayList<Integer> tempList = new ArrayList<Integer>(subList);
                    tempList.add(arr[i]);
                    list.add(tempList);
                }
            }
            result.addAll(list);
            ArrayList<Integer> singleElement = new ArrayList<Integer>();
            singleElement.add(arr[i]);
            result.add(singleElement);
        }
        showResult(result);
        return null;
    }
    public static void main(String[] args) {
        int[] input =  { 2, 5, 6, 1, 3 };
        getIncreasingSubSequence(input);
    }
}
