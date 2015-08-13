package main.java.com.personal.String;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by riyaz on 9/8/15.
 */
public class ComputerSimulation {
    private static  int runCustomerSimulation(int k , String str) {
        if(str == null ||  str.length() == 0)
            return 0;
        if(k > str.length())
            return 0;
        int length = str.length();
        int i = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while(i < length) {
            if(!map.containsKey(str.charAt(i)) && map.size() < k) {
                map.put(str.charAt(i), 1);
            } else if(!map.containsKey(str.charAt(i)) && map.size() ==k) {
                ++count;
            }else {
                map.keySet().remove(str.charAt(i));
            }
            ++i;
        }
        return  count / 2;
    }
    public static void main(String[] args) {
        System.out.println(runCustomerSimulation(2, "ABBAJJKZKZ"));
        System.out.println(runCustomerSimulation(3, "GACCBDDBAGEE"));
        System.out.println(runCustomerSimulation(3, "GACCBGDDBAEE"));
        System.out.println(runCustomerSimulation(1, "ABCBCA"));
        System.out.println(runCustomerSimulation(1, "ABCBCADEED"));

    }
}
