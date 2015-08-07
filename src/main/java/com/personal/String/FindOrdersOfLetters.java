package main.java.com.personal.String;

import java.util.*;

/**
 * Created by riyaz on 31/7/15.
 */
public class FindOrdersOfLetters {
    static void showMatrix(boolean [][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0 ; i < m; ++i) {
            for(int j = 0 ; j < n; ++j){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    static void findOrdersOfLetters(String [] words) {
        int wordsArrayLength = words.length;
        Map<Character, Integer> characters = new HashMap<Character, Integer>();
        for(String word : words) {
            int length = word.length();
            for(int i = 0; i < length; ++i)
                if(!characters.keySet().contains(word.charAt(i))) {
                    characters.put(word.charAt(i), characters.size());
                }
        }
        System.out.println(characters.keySet());
        System.out.println(characters.toString());
        boolean [][] matrix = new boolean[characters.size()][characters.size()];
        for(int i = 0; i < wordsArrayLength - 1; ++i) {
            String preWords = words[i];
            for(int j = i + 1; j < wordsArrayLength; ++j) {
                String nextword = words[j];
                for(int k = 0 ; k < Math.min(preWords.length(), nextword.length()); ++k) {
                    if(preWords.charAt(k) != nextword.charAt(k)){
                        matrix[characters.get(preWords.charAt(k))][characters.get(nextword.charAt(k))] = true;
                        break;
                    }
                }
            }
        }
        showMatrix(matrix);
        List<Character> result = new ArrayList<Character>();
        char ch = ' ';
        while(!characters.isEmpty()) {
            boolean lowest = false;
            for(Character preChar: characters.keySet()) {
                lowest = true;
                int prevIndex = characters.get(preChar);
                for(Character nextChar: characters.keySet()) {
                    int nextIndex = characters.get(nextChar);
                    if(matrix[nextIndex][prevIndex] == true) {
                        lowest= false;
                        break;
                    }
                }
                if(lowest) {
                    ch = preChar;
                    result.add(ch);
                    break;
                }
            }
            characters.keySet().remove(ch);
            ch = ' ';
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
//        String [] words  = {"baa", "abcd", "abca", "cab", "cad"};
        String[] words = {"caa", "aab", "aab"};
        findOrdersOfLetters(words);
    }
}
