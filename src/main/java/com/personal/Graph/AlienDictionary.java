package Graph;

import java.util.HashMap;

/**
 * Created by riyaz on 6/7/15.
 */
public class AlienDictionary {
    static void show(boolean [][] arr) {
        int length = arr.length;
        for(int i = 0; i <length; ++i){
            for(int j = 0; j < length; ++j)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
//        String[] words =
//                { "car", "cat", "cbr", "deer", "egg", "god",
//                        "rabe", "race", "rat", "tar" };
        String words[] = {"baa", "abcd", "abca", "cab", "cad"};
        char[] letters = getLetterOrdering(words);
        if (letters == null)
            System.out.println("not possible");
        else {
            for (char ch : letters)
                System.out.print(ch + ",");
        }
    }

    private static char[] getLetterOrdering(String[] words) {
        HashMap<Character, Integer> characters =
                new HashMap<Character, Integer>();
        for (String word : words) {
            for (int i = 0; i < word.length(); ++i) {
                char character = word.charAt(i);
                if (!characters.keySet().contains(character)) {
                    characters.put(character, characters.size());
                }
            }
        }
        System.out.println("HashMap \t" + characters);
        boolean[][] adjacency = new boolean[characters.size()]
                [characters.size()];
        for (int i = 0; i < words.length - 1; ++i) {
            for (int j = i + 1; j < words.length; ++j) {
                String prevWord = words[i];
                String nextWord = words[j];
                for (int k = 0; k < Math.min(prevWord.length(),
                        nextWord.length()); ++k) {
                    char prevCharacter = prevWord.charAt(k);
                    char nextCharacter = nextWord.charAt(k);
                    if (prevCharacter != nextCharacter) {
                        adjacency[characters.get(prevCharacter)][characters
                                .get(nextCharacter)] = true;
                        break;
                    }
                }
            }
        }
        show(adjacency);
        System.out.println("KeySet\t" + characters.keySet());
        char[] result = new char[characters.size()];
        int resultIndex = 0;
        while (!characters.isEmpty()) {
            char lowChar = ' ';
            for (Character nextCharacter : characters.keySet()) {

                int nextIndex = characters.get(nextCharacter);
                boolean lowest = true;

                for (Character prevCharacter : characters.keySet()) {
                    int prevIndex = characters.get(prevCharacter);
                    if (adjacency[prevIndex][nextIndex]) {
                        lowest = false;
                        break;
                    }
                }

                if (lowest) {
                    lowChar = nextCharacter;
                    result[resultIndex++] = nextCharacter;
                    break;
                }

            }
            if (lowChar == ' ') {
                return null;
            } else {
                characters.remove(lowChar);
                lowChar = ' ';
            }
        }
        return result;
    }

}
