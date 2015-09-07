package main.java.com.personal.Array.GFG;

import java.util.*;

/**
 * Created by riyaz on 27/8/15.
 */
public class MyDS {
    private  List<Integer> array;
    private Map<Integer, Integer> hashMap;

    public MyDS() {
        this.array = new ArrayList<Integer>();
        this.hashMap = new HashMap<Integer, Integer>();
    }

    private  void add(int element) {
        if(hashMap.containsKey(element))
            return;
        int size = array.size();
        array.add(element);
        hashMap.put(element, size);
    }

    private Integer search(int element) {
        return hashMap.get(element);
    }

    private  void delete(int element) {
        if(!hashMap.containsKey(element))
            return;
        int deletedElementIndex = hashMap.get(element);
        hashMap.remove(element);

        int size = array.size();
        int lastElement = array.get(size - 1);
        Collections.swap(array, deletedElementIndex, size - 1);
        array.remove(size -  1);

        hashMap.put(lastElement, deletedElementIndex);

    }

    private int getRandom() {
        Random rand = new Random() ;
        int index = rand.nextInt(array.size() - 1);
        return array.get(index);
    }

    private void display() {
        Iterator it = array.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        MyDS  ds = new MyDS();
        ds.add(10);
        ds.add(20);
        ds.add(30);
        ds.add(40);
        ds.add(50);

        System.out.println(ds.search(30));
        ds.delete(30);
        System.out.println(ds.search(30));

        System.out.println(ds.getRandom());
//        ds.display();
    }
}
