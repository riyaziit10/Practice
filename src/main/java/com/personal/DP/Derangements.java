package main.java.com.personal.DP;

import java.io.File;

/**
 * Created by riyaz on 5/12/15.
 */
public class Derangements {
    private static int numberOfDerangements(int n) {
        if(n == 1)
            return 0;
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        return (n - 1) * (numberOfDerangements(n-1) +  numberOfDerangements(n-2));

    }
    private static int numberOfPathsWithExactlyKCoinsUtil(int mat[][], int i , int j, int m , int n, int k) {
        if(k < 0)
            return 0;
        if(k > 0 && (i == m || j == n))
            return 0;
        k = k - mat[i][j];
        if(k == 0 && i == m - 1 && j == n - 1) {
            return 1;
        }
        int count = numberOfPathsWithExactlyKCoinsUtil(mat, i + 1, j, m, n, k);
        count += numberOfPathsWithExactlyKCoinsUtil(mat, i, j + 1, m, n, k);
        return count;
    }

    private static int numberOfPathsWithExactlyKCoins(int mat[][], int k) {
        if (k < 0)
            return 0;
        int m = mat.length;
        int n = mat[0].length;
        return numberOfPathsWithExactlyKCoinsUtil(mat, 0 , 0, m , n, k);
    }

    private static void printUniqueFilenames() {
        File name = new File("/home/riyaz/Desktop");
        File [] listOfFiles = name.listFiles();
        if(listOfFiles == null) {
            System.out.println("No files found");
            return;
        }
        for(int i = 0; i < listOfFiles.length; ++i) {
            if(listOfFiles[i].isFile())
                System.out.println("File \t" + listOfFiles[i].getName());
            else {
                System.out.println("Directory\t" + listOfFiles[i].getName());
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(numberOfDerangements(6));

//        int k = 12;
//        int mat[][] = { {1, 2, 3},
//            {4, 6, 5},
//                {3,2,1}
//        };
//        System.out.println(numberOfPathsWithExactlyKCoins(mat, k));

        printUniqueFilenames();
    }
}
