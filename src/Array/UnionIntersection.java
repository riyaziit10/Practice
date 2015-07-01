package Array;

import java.util.*;

/**
 * Created by riyaz on 27/6/15.
 */
public class UnionIntersection {
    private static void unionAndIntersectin(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        int i = 0, j = 0;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        List<Integer> union = new ArrayList<Integer>();
        List<Integer> intersection = new ArrayList<Integer>();
        while (i < arr1Length && j < arr2Length) {
            if (arr1[i] == arr2[j]) {
                intersection.add(arr1[i]);
                union.add(arr1[i]);
                ++i;
                ++j;
            } else if (arr1[i] < arr2[j]) {
                union.add(arr1[i]);
                ++i;
            } else {
                union.add(arr2[j]);
                ++j;
            }
        }
        if (i < arr1.length) {
            while (i < arr1Length) {
                union.add(arr1[i]);
                ++i;
            }
        }
        if (j < arr2Length) {
            while (j < arr2Length) {
                union.add(arr2[j]);
                ++j;
            }
        }
        System.out.println("Union of arrays is" + union);
        System.out.println("InterSection of arrays is" + intersection);

    }
    //ToDo
    private static void unionAndIntersectionV2(int [] arr1, int [] arr2){
        Map<Integer,Boolean> map = new HashMap<Integer, Boolean>();
        List<Integer> union = new ArrayList<Integer>();
        List<Integer> intersection = new ArrayList<Integer>();
        for(int i : arr1) {
            map.put(i,true);
            union.add(i);
        }

        for(int j:arr2){
            if(map.containsKey(j)) {
                intersection.add(j);
            }
            if(!union.contains(j))
            union.add(j);
        }

        System.out.println("==============V2================");
        System.out.println("Union of arrays is" + union);
        System.out.println("InterSection of arrays is" + intersection);
    }

    public static void main(String[] args) {
        int arr1[] = {7, 1, 5, 2, 3, 6};
        int arr2[] = {3, 8, 6, 20, 7};
        unionAndIntersectin(arr1, arr2);
        unionAndIntersectionV2(arr1,arr2);
    }
}
