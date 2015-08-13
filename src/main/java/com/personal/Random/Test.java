package  main.java.com.personal.Random;


import java.util.ArrayList;
import java.util.List;

public class Test {
    private static void divideStringNEqualParts(String str, int k) {
        if(str == null)
            return;
        int length = str.length();

        if(length % k != 0) {
            return;
        }
        int size =length / k;
        System.out.println(size + "\t" + length);
        int i  = 0;
        List<String> list = new ArrayList<String>();
        while(i < length) {
            list.add(str.substring(i, i + size));
            i = i + size;
        }
        System.out.println(list);
    }

    public static void main(String[] args) throws Exception {
            String str = "a_simple_divide_string_quest";
        divideStringNEqualParts(str, 4);
    }
}

