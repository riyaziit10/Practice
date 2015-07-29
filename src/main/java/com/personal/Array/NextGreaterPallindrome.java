//package main.java.com.personal.Array;
//
///**
// * This Answer is not complete
// * Created by riyaz on 26/7/15.
// */
//public class NextGreaterPallindrome {
//    static String reverse(String str) {
//        if (str.length() < 2)
//            return str;
//        else return reverse(str.substring(1)) + str.charAt(0);
//    }
//
//    public static void main(String[] args) {
//        String str = "1234212";
////        String str = "345676";
//        StringBuilder sb = new StringBuilder(str);
//        int length = str.length();
//        String firstHalf = str.substring(0, length / 2);
//        String secondHalf = str.substring(length / 2);
//        String firstHalfReverse = reverse(firstHalf);
//        if ((length & 1) == 0) {
//            if (Integer.parseInt(firstHalfReverse) > Integer.parseInt(secondHalf))
//                System.out.println("Next Pallindrome is\t" + firstHalf + firstHalfReverse);
//            else {
//                String incrementedFistHalf = Integer.toString(Integer.parseInt(firstHalf) + 1);
//                String reverseIncrementedFirstHalf = reverse(incrementedFistHalf);
//                System.out.println("NextPalindrome is\t" + incrementedFistHalf + reverseIncrementedFirstHalf);
//            }
//        } else {
//            String secondHalfOddLength = str.substring(length / 2 + 1);
//            System.out.println(secondHalfOddLength);
//            if (Integer.parseInt(firstHalfReverse) > Integer.parseInt(secondHalfOddLength)) {
//                System.out.println("NextPallindrome is \t" + firstHalf + str.charAt(length / 2) + firstHalfReverse);
//            } else {
//                String incrementedFirstHalf = Integer.toString(Integer.parseInt(str.substring(0, length / 2  + 1)) + 1);
//            }
//
//        }
//    }
//}
