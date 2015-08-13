package main.java.com.personal.String;

/**
 * Created by riyaz on 9/8/15.
 */
public class Permutations {
    private static void printPermutations(char [] str, char [] result , int index, boolean [] visited) {
        if(index == str.length) {
            System.out.println(result);
            return;
        }
        int length = str.length;
        for(int i = 0; i < length; ++i) {
            if(!visited[i]) {
                visited[i] = true;
                result[index] = str[i];
                printPermutations(str, result, index + 1, visited);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        String str = "ABC";
        boolean [] visited = new boolean[str.length()];
        char [] result = new char[str.length()];
        printPermutations(str.toCharArray(), result,0,visited);
    }
}
