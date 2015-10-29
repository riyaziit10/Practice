package main.java.com.personal.Random;

import java.util.*;

/**
 * Created by riyaz on 27/10/15.
 */

class CustomHashSet<E> {
    private transient HashMap<E, Object> hashMap;
    private static final Object PRESENT = new Object();

    public CustomHashSet() {
        this.hashMap = new HashMap<>();
    }

    public boolean add(E e) {
        return hashMap.put(e, PRESENT) == null;
    }
    public Iterator<E> iterator() {
        return hashMap.keySet().iterator();
    }
}

public class HashSetDemo {
    public static void main(String[] args) {
        CustomHashSet<String> set = new CustomHashSet<String>();
        set.add("Riyaz");
        set.add("ali");
        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        List<String> list = Arrays.asList("Z", "A", "X");

        Collections.sort(list,Collections.reverseOrder());

        System.out.println(list);
    }
}