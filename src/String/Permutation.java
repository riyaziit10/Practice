package String;

import java.util.Arrays;

/**
 * Created by riyaz on 4/7/15.
 */
public class Permutation {
    static void permuatation(char [] str, char [] result, int i, int [] visited) {
        int length = str.length;
        if(i == length) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for(int k = 0; k < length; ++k) {
            if(visited[k] == 0) {
                visited[k] = 1;
                result[i] = str[k];
                permuatation(str,result, i + 1, visited);
                visited[k] = 0;
            }
        }

    }
    public static void main(String[] args) {
//        char[] str = {'a','b','c'};
//        char[] solution = new char[str.length];
//        int [] visited = new int [str.length];
//        permuatation(str,solution,0,visited);
        String str = "abcde";
        char [] arr = str.toCharArray();
        System.out.println(Arrays.toString(arr));
    }
}
