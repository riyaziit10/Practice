package DsAlgo;

/**
 * Created by riyaz on 30/5/15.
 */
public class FindMinMax {
    static void findMinMax(int[] arr) {
        int length = arr.length, max = arr[0], min = arr[0], i;

        if (length == 0) {
            System.out.println("Array is empty");
            return;
        }

        if (length == 1)
            max = min = arr[0];

        for (i = 0; i < length / 2; ++i) {
            int num1 = arr[i * 2];
            int num2 = arr[i * 2 + 1];

            if(num1 > num2) {
                if(num1 > max)
                    max = num1;
                if(num2 < min)
                    min = num2;
            } else {
                if(num2 > max)
                    max = num2;
                if(num1 < min)
                    min = num1;
            }
        }
        if (i * 2 < length) {
            if (arr[i * 2] > max)
                max = arr[i * 2];
            if (arr[i * 2] < min)
                min = arr[i * 2];

        }

        System.out.println("maximum = \t" + max + "\tminimum\t" + min);
    }

    public static void main(String[] args) {
        int[] arr = {4,3,5,1,2,6,9,2,10,11};
        findMinMax(arr);
    }
}
