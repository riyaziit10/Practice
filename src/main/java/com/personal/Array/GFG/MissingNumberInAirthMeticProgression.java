package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 28/8/15.
 */
public class MissingNumberInAirthMeticProgression {

    private static int findMissing(int arr[], int l, int h, int diff) {
        if (l > h)
            return -1;
        int mid = (l + h) / 2;

        if (mid + 1 <= h && arr[mid + 1] - arr[mid] != diff) {
            return arr[mid] + diff;
        } else if (mid - 1 >= 0 && arr[mid] - arr[mid - 1] != diff) {
            return arr[mid - 1] + diff;
        }
        else if (arr[mid] == arr[0] + mid * diff) {
            return findMissing(arr, mid + 1, h, diff);
        }
        else
            return findMissing(arr, l, mid - 1, diff);
    }

    private static int getMissingNumber(int arr[]) {
        if (arr == null || arr.length <= 1)
            return -1;
        int length = arr.length;
        int diff = arr[1] - arr[0];
        return findMissing(arr, 0, arr.length - 1, diff);
    }

    public static void main(String[] args) {
        int arr1[] = {2, 4, 8, 10, 12, 14};
        System.out.println(getMissingNumber(arr1));
        int arr2[] = {1, 6, 11, 16, 21, 31};
        System.out.println(getMissingNumber(arr2));

    }
}
