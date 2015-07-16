package Graph;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by riyaz on 6/7/15.
 */
public class AlienDictionaryOwn {
    static void show(boolean [][] arr) {
        int length = arr.length;
        for(int i = 0; i <length; ++i){
            for(int j = 0; j < length; ++j)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
    static char [] getLetterOrdering(String [] words) {
        if(words == null)
            return null;
        int length = words.length;
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for(String word: words){
            int l = word.length();
            for(int i = 0; i < l; ++i) {
                char c = word.charAt(i);
                if(!hashMap.keySet().contains(c)) {
                    hashMap.put(c, hashMap.size());
                }
            }
        }
        System.out.println(hashMap);
        boolean [] [] adjacencyMatrix= new boolean[hashMap.size()][hashMap.size()];
        for(int i = 0 ; i < words.length -1; ++i) {
            String preWord = words[i];
            for(int j = i + 1; j < words.length; ++j){
                String nextWord = words[j];
                for(int k = 0; k < Math.min(preWord.length(), nextWord.length()); ++k) {
                    char prevCharacter = preWord.charAt(k);
                    char nextCharacter = nextWord.charAt(k);
                    if(prevCharacter != nextCharacter) {
                        adjacencyMatrix[hashMap.get(prevCharacter)][hashMap.get(nextCharacter)] = true;
                        break;
                    }
                }
            }

        }
        show(adjacencyMatrix);

        char [] result = new char[hashMap.size()];
        int index = 0;
        while(!hashMap.isEmpty()){
            for(Character nextCharacter: hashMap.keySet()) {
                boolean lowest = true;
                int nextIndex = hashMap.get(nextCharacter);
                for(Character preCharacter: hashMap.keySet()) {
                    int preIndex = hashMap.get(preCharacter);
                    if(adjacencyMatrix[preIndex][nextIndex]){
                        lowest = false;
                        break;
                    }
                }
                if(lowest){
                    hashMap.keySet().remove(nextCharacter);
                    result[index++]=nextCharacter;
                    break;
                }
            }

        }
        if(result.length == 0)
            return  null;
        else
            return result;

    }
    public static void main(String[] args) {
        String words[] = {"baa", "abcd", "abca", "cab", "cad"};
        char [] charOrdering = getLetterOrdering(words);
        if(charOrdering == null) {
            System.out.println("Ordering is not possible");
        } else {
            System.out.println(Arrays.toString(charOrdering));
        }
    }
}
