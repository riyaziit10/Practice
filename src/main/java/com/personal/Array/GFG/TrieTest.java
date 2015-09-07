package main.java.com.personal.Array.GFG;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by riyaz on 7/9/15.
 */
class TrieNode {
    private char ch;
    private Map<Character, TrieNode> Children;
    private boolean isEnd;

    public TrieNode(char ch) {
        this.ch = ch;
        this.Children = new HashMap<Character, TrieNode>();
        this.isEnd = false;
    }

    public char getCh() {
        return ch;
    }

    public Map<Character, TrieNode> getChildren() {
        return Children;
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {
    private TrieNode  root;

    public Trie() {
        this.root = new TrieNode((char)0);
    }

    public void insert(String str) {
        if(str == null)
            return;
        int length = str.length();
        TrieNode custom_iterator = root;

        for(int i = 0; i < length; ++i) {
            char ch = str.charAt(i);
            Map<Character, TrieNode> child = custom_iterator.getChildren();

            if(child.containsKey(ch)) {
                custom_iterator = child.get(ch);
            } else {
                TrieNode temp = new TrieNode(ch);
                child.put(ch, temp);
                custom_iterator = temp;
            }
        }

        custom_iterator.setIsEnd(true);

    }

    public int search(String str) {
        if(str == null)
            return 0;
        String result = "";
        int length = str.length();
        int max_length = 0;
        TrieNode crawl = root;
        for(int i =0 ;i < length; ++i){
            char character = str.charAt(i);
            Map<Character, TrieNode> trie = crawl.getChildren();
            if(trie.containsKey(character)) {
                if(crawl.isEnd()) {
                    max_length = i + 1;
                }
                result += character;
            }
            if(!trie.containsKey(character)) {
                System.out.println(result);
                return max_length + 1;
            }

            crawl = trie.get(character);
        }
        System.out.println(result);
        return max_length;
    }
}
public class TrieTest {

    public static void main(String[] args) {
        Trie dict = new Trie();
//        dict.insert("area");
//        dict.insert("base");
        dict.insert("cat");
        dict.insert("cater");
//        dict.insert("basement");

        System.out.println(dict.search("caterer"));

    }
}
