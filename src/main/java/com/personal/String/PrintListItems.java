package main.java.com.personal.String;

/**
 * Created by riyaz on 9/8/15.
 */
public class PrintListItems {
    private static void getStringMap(String str, int [] map){
        int str_length = str.length();
        for(int i = 0; i < str_length; ++i) {
            ++map[str.charAt(i)];
        }

    }
    private static final int NO_OF_CHRS = 256;
    private static void printListItems(String str, String [] list) {
        int str_length = str.length();
        int [] map = new int [NO_OF_CHRS];
        getStringMap(str, map);
        for(String string: list) {
            int length = string.length();
            int matched_char = 0;
            for(int i = 0; i < length; ++i) {
                char ch = string.charAt(i);
                if(map[ch] != 0){
                    ++matched_char;
                    if(matched_char == str_length) {
                        System.out.println(string);
                        break;
                    }
                    --map[ch];
                }
            }
            getStringMap(str, map);

        }
    }
    public static void main(String[] args) {
        String str = "sun";
        String [] list = {"geeksforgeeks", "unsorted", "sunday", "just", "sss" };
        printListItems(str, list);
    }
}
