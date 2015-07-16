package main.java.com.personal.Array;

/**
 * Created by riyaz on 13/7/15.
 */
public class FindRepetitionWithoutExtraSpace {
    static void findRepetition(int [][] arr) {
        int len = arr.length;

        int[] index = new int[len];
        int[] frontElement = new int[len];
        int[] length = new int[len];
        for (int i = 0; i < len; ++i)
            length[i] = arr[i].length;
//        System.out.println(Arrays.toString(length));
        boolean isModified = true;
        while (isModified) {
            isModified = false;
            for (int i = 0; i < len; ++i) {
                if(index[i] < length[i]) {
                    frontElement[i] = arr[i][index[i]];
                    isModified = true;
                }
                else
                    frontElement[i] = Integer.MAX_VALUE;
            }
            int min = frontElement[0];
            int indexMin = 0;
            for (int i = 1; i < len; ++i) {
                if (frontElement[i] == min) {
                    if(frontElement[i] != Integer.MAX_VALUE) {
                        System.out.println("Repeated Element is \t" + frontElement[i]);
                        min = frontElement[i];
                        indexMin = i;
                        ++index[i];
                    }
                } else if (frontElement[i] < min) {
                    min = frontElement[i];
                    indexMin = i;
                }
            }
            ++index[indexMin];
//            System.out.println(Arrays.toString(index));
//            System.out.println(Arrays.toString(frontElement));
        }
    }
    public static void main(String[] args) {
        int[][]arr={{8,12,13,16,17,22,24,29,33},
                {4,8,14,16,18,23},
                {33,36,37,44,95,126},
                {5,7,15,18}};
        findRepetition(arr);

    }
}
