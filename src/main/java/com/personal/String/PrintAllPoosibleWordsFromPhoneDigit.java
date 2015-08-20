package main.java.com.personal.String;

/**
 * Created by riyaz on 14/8/15.
 */
public class PrintAllPoosibleWordsFromPhoneDigit {
    private static void printCharacters(String [] str, char [] result, int index, String number, int m) {
        if(m == number.length()) {
            System.out.println(new String(result));
            return;
        }
        int digit = number.charAt(m) - '0';
        int length = str[digit].length();
        for(int i = 0; i < length; ++i) {
            result[index] = str[digit].charAt(i);
            printCharacters(str, result, index + 1, number, m + 1);
        }
    }
    public static void main(String[] args) {
        String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String number = "203";
        char [] result = new char[number.length()];
        printCharacters(keypad, result, 0, number, 0);
    }
}