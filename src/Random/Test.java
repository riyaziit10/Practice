package Random;

import java.util.HashMap;
import java.util.IdentityHashMap;

/**
 * Created by riyaz on 21/6/15.
 */

public class Test {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Riyaz","ali");
        map.put("Riyaz", "ali");
        System.out.println(map.size());

        IdentityHashMap<String, String> iMap = new IdentityHashMap<String, String>();
        iMap.put("Riyaz","ali");
        iMap.put("Riyaz","ali");

    }

}
