package main.java.com.personal.Random;

import java.util.*;

/**
 * Created by riyaz on 27/10/15.
 */
public class KFrequentWords {

    private static Map<String, Integer> hashMapSortedByValues(Map<String, Integer> map) {
        List list = new LinkedList(map.entrySet());

        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object t1, Object t2) {
                return (Integer)(((Map.Entry) t2).getValue()) - ((Integer)((Map.Entry) t1).getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iterator.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static void main(String[] args) {
        String text = "Welcome to the world of Geeks " +
                "This portal has been created to provide well written well thought and well explained " +
                "solutions for selected questions If you like Geeks for Geeks and would like to contribute " +
                "here is your chance You can write article and mail your article to contribute at " +
                "geeksforgeeks org See your article appearing on the Geeks for Geeks main page and help " +
                "thousands of other Geeks";
        String [] words = text.split(" ");

        Map<String, Integer> map = new HashMap<>();
        for(String word: words) {
            if(!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        map = hashMapSortedByValues(map);
        Iterator iterator = map.entrySet().iterator();
        System.out.println("Sorted By Keys");
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> entry= (Map.Entry<String, Integer>) iterator.next();
            System.out.println(entry.getKey() + "\t=\t" + entry.getValue());
        }



    }
}
