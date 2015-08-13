package main.java.com.personal.String;

/**
 * Created by riyaz on 8/8/15.
 */
public class ListOfWords {
    private static void printSentence(String [][] input, int r, int c, String sb) {
        if(r == input.length) {
            System.out.println(sb);
            return;
        }
        int length = input[r].length;
        for(int i = 0; i < length; ++i) {
            sb = sb.concat(input[r][i]);
            sb = sb.concat(" ");
            printSentence(input, r + 1, c, sb);
            sb = sb.replace(input[r][i] + " ", "");
        }
    }
    public static void main(String[] args) {
        String [][] input = {{"you", "we"},
                             {"have", "are"},
                             {"sleep", "eat", "drink"}};
        printSentence(input, 0, 0, "");
    }
}
