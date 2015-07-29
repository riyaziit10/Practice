//package main.java.com.personal.String;
//
//import java.util.HashSet;
//import java.util.Set;
//import java.util.Stack;
//
///**
// * Created by riyaz on 26/7/15.
// */
//public class SeparateWordsInSentence {
//    private static  String []  getSeparatedWords(String sentence, String [] dictionary) {
//        Set<String> validWords = new HashSet<String>();
//        for(String word: dictionary){
//            validWords.add(word);
//        }
//        Stack<String> word = new Stack<String>();
//        return null;
//    }
//    private static boolean isSeperable(String sentence, Set<String> validWords, int startIndex, Stack<String> words) {
//        if(startIndex == sentence.length())
//            return true;
//        boolean hasWords = false;
//        for(int i = startIndex + 1; i <= sentence.length(); ++i){
//            String currentSubString = sentence.substring(startIndex, i);
//            if(validWords.contains(currentSubString)) {
//                words.push(currentSubString);
//            }
//        }
//    }
//    public static void main(String[] args) {
//        String sentence = "therearesomewordshiddenhere";
//        String[] dictionary =
//                { "the", "a", "i", "here", "so", "hid", "there", "are",
//                        "some", "word", "words", "hid", "hi", "hidden", "he",
//                        "here", "her", "rear", "me", "den" };
//        String [] words =  getSeparatedWords(sentence, dictionary);
//        for(String word : words) {
//            System.out.print(word);
//        }
//        System.out.println();
//    }
//}
