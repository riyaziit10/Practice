package main.java.com.personal.String;

/**
 * Created by riyaz on 12/8/15.
 */
public class PrintInterLeaving {
    private static void printInterleaving(String str1, String str2) {
        if(str1 == null || str1.length() == 0) {
            System.out.println(str2);
            return;
        }
        if(str2 == null || str2.length() == 0) {
            System.out.println(str1);
            return;
        }

        String str3 = str1 + str2;
        System.out.println(str3);
        int  str3_length = str3.length();
        int i = 1;
        char [] strArray = null;
        while(i + 1 < str3_length) {
            strArray = str3.toCharArray();
            char temp = strArray[i];
            strArray[i]= strArray[i+1];
            strArray[i+1]=temp;
            System.out.println(new String(strArray));
            ++i;
        }


    }

    private static void printInterleavingRecursively(char [] str1, char []  str2, char [] result,int m , int n , int i) {
        if(m == str1.length && n == str2.length) {
            System.out.println(new String(result));
            return;
        }
        if(m != str1.length) {
            result[i] = str1[m];
            printInterleavingRecursively(str1, str2, result, m + 1, n, i + 1);
        }
        if(n != str2.length) {
            result[i] = str2[n];
            printInterleavingRecursively(str1, str2, result, m, n + 1,i + 1);
        }
    }
    public static void main(String[] args) {
        String str1 = "AB";
        String str2 = "CD";
        printInterleaving(str1, str2);
        printInterleaving(str2,str1);
        System.out.println("=======================");
        char [] result = new char[str1.length() + str2.length()];
        printInterleavingRecursively(str1.toCharArray(),str2.toCharArray(), result, 0,0,0);
    }
}
