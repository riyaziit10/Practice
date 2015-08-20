package main.java.com.personal.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by riyaz on 16/8/15.
 */
public class AlienDictioanary {
    private static void showMatrix(boolean [][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    private static void printOrderOfCharactersAlienDictioanry(String [] words) {
        if(words == null)
            return;
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        for(String word: words) {
            int length = word.length();
            for(int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                if (!charCount.keySet().contains(ch))
                    charCount.put(ch, charCount.size());
            }
        }

        boolean [][] matrix = new boolean[charCount.size()][charCount.size()];
        int wordsArrayLength = words.length;
        for(int i = 0; i< wordsArrayLength - 1; ++i ) {
            int previousWordLength = words[i].length();
            for(int k = i + 1; k < wordsArrayLength; ++k) {
                int nextWordLength = words[k].length();
                for (int j = 0; j < Math.min(previousWordLength, nextWordLength); ++j) {
                    char previousChar = words[i].charAt(j);
                    char nextChar = words[k].charAt(j);
                    if (previousChar != nextChar) {
                        matrix[charCount.get(previousChar)][charCount.get(nextChar)] = true;
                        break;
                    }
                }
            }
        }
//        showMatrix(matrix);
        List<Character> result = new ArrayList<Character>();
       while(!charCount.isEmpty()) {
           char ch = ' ';
           for(Character  nextChar : charCount.keySet()) {
               boolean isUnique = true;
               int n = charCount.get(nextChar);
               for(Character previous: charCount.keySet()) {
                   int p = charCount.get(previous);
                   if(matrix[p][n] == true) {
                       isUnique = false;
                       break;
                   }
               }
               if(isUnique) {
                   ch = nextChar;
                   result.add(nextChar);
                   break;
               }

           }
           if(ch != ' ')
               charCount.keySet().remove(ch);

       }
        System.out.println("Sequece is \t" + result);
    }
    public static void main(String[] args) {
        String words[] = {"baa", "abcd", "abca", "cab", "cad"};
        printOrderOfCharactersAlienDictioanry(words);
        String words1 [] = {"caa", "aaa", "aab"};
        printOrderOfCharactersAlienDictioanry(words1);
    }
}
