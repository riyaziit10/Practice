package  main.java.com.personal.Random;

import java.util.*;


public class Test {

    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i <= 10; ++i)
            list.add(i);

        System.out.println(list);
        ListIterator iterator = list.listIterator();
        while(iterator.hasNext()) {
            if(((Integer)iterator.next()) % 5 == 0) {
                iterator.remove();
                iterator.add(100);
            }
        }

        System.out.println(list);

    }
}

