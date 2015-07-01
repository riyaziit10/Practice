package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by riyaz on 28/6/15.
 */
public class MyDS {
    private  ArrayList<Integer> arr;
    private HashMap<Integer, Integer> hash;

    public MyDS() {
        arr = new ArrayList<Integer>();
        hash = new HashMap<Integer, Integer>();
    }

    void add(Integer element) {
        if(hash.get(element)  != null)
            return;
        int size = arr.size();
        arr.add(element);
        hash.put(element, size);
    }

    void  delete(Integer element)  {
        Integer index = hash.get(element);
        if(index== null) {
            System.out.println(element + "is not present in the DS");
            return;
        }
        hash.remove(element);
        int size = arr.size();
        int lastElement = arr.get(size - 1);
        Collections.swap(arr,index,size - 1);
        arr.remove(size - 1);
        hash.put(lastElement,index);
    }

    Integer search(Integer element) {
        int index = hash.get(element);
        return arr.get(index);
    }

    Integer getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(arr.size());
        return arr.get(index);
    }
    void show() {
        System.out.println(arr);
    }
    public static void main(String[] args) {
        MyDS ds = new MyDS();
        ds.add(10);
        ds.add(20);
        ds.add(30);
        ds.show();
        ds.delete(10);
        ds.show();
    }

}
