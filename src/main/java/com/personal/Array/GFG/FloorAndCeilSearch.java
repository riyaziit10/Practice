package main.java.com.personal.Array.GFG;

/**
 * Created by riyaz on 19/8/15.
 */
public class FloorAndCeilSearch {

    private static int getCeil(int arr[], int l , int h, int ceil) {
        if( l > h)
            return  -1;

        if(ceil <= arr[l])
            return arr[l];
        else if(ceil >= arr[h])
            return  - 1;
        int mid = (l + h)/2;
        if(mid - 1 >= 0   && arr[mid - 1] < ceil && ceil <= arr[mid])
            return arr[mid];
        else if(ceil < arr[mid])
            return getCeil(arr, l , mid - 1, ceil);
        else return getCeil(arr, mid + 1, h, ceil);
    }

    private static  int getFloor(int [] arr, int l, int h, int floor) {
        if( l > h)
            return -1;
        if(floor < arr[l])
            return -1;
        else if(floor >= arr[h])
            return arr[h];
        int mid = (l + h) / 2;
        if(mid + 1 <= h && arr[mid] <= floor && floor < arr[mid + 1])
             return arr[mid];
        else if(floor < arr[mid])
            return getFloor(arr, l, mid - 1, floor);
        else
            return  getFloor(arr, mid + 1, h, floor);
    }
    public static void main(String[] args) {

        int arr[] = {1, 2, 8, 10, 10, 12, 19};
        System.out.println("Ceiling\t" + getCeil(arr, 0 , arr.length - 1, 0) + "\tFloor\t" + getFloor(arr, 0, arr.length - 1, 0));
        System.out.println("Ceiling\t" + getCeil(arr, 0, arr.length - 1, 1) + "\tFloor\t" + getFloor(arr, 0, arr.length - 1, 1));
        System.out.println("Ceiling\t" + getCeil(arr, 0 , arr.length - 1, 5) + "\tFloor\t" + getFloor(arr, 0, arr.length - 1, 5));
        System.out.println("Ceiling\t" + getCeil(arr, 0 , arr.length - 1, 20) + "\tFloor\t" + getFloor(arr, 0, arr.length - 1, 20));
        System.out.println("Ceiling\t" + getCeil(arr, 0 , arr.length - 1, 10)  + "\tFloor\t" + getFloor(arr, 0, arr.length - 1, 10));


    }
}
