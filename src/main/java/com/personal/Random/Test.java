package main.java.com.personal.Random;/* Java program to design a data structure that support folloiwng operations
in Theta(n) time
a) Insert
b) Delete
c) Search
d) getRandom */
interface A {

}
public class Test
{
    private static int findMinimumdistance(int arr[], int x, int y) {
        int length = arr.length;
        int minDistance = Integer.MAX_VALUE;
        int xIndex = -1;
        int yIndex = -1;
        for(int i = 0 ; i < length; ++i) {
            if(arr[i] == x) {
                xIndex = i;
            } else if( arr[i] == y) {
                yIndex = i;
            }

            if( xIndex != -1 && yIndex != -1 && Math.abs(xIndex - yIndex) < minDistance) {
                minDistance = Math.abs(xIndex - yIndex);
            }
        }
        return minDistance;
    }
    public static void main (String[] args) {
        int arr1[] = {2, 5, 3, 5, 4, 4, 2, 3}, x = 3, y = 2;
        System.out.println("arr1\t" + findMinimumdistance(arr1, x, y));


        int arr3[] = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
        x = 3;
        y = 6;

        System.out.println(findMinimumdistance(arr3, x, y));
    }
}

