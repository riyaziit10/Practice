package Random;

/**
 * Created by riyaz on 29/6/15.
 */
public class StringReverse {
    static void iterativeReverse(String str){
        StringBuilder strBuilder = new StringBuilder();
        char [] ch = str.toCharArray();
        for(int i = ch.length - 1; i >=0; --i)
            strBuilder.append(ch[i]);
        System.out.println("iterative\t" + strBuilder.toString());
    }

    static String stringReverse(String str) {
        if(str.length() < 2)
            return str;
        return stringReverse(str.substring(1)) + str.charAt(0);
    }


    public static void main(String[] args) {
        String str = "ABCD";

//        String revString = new StringBuffer(str).reverse().toString();

//        System.out.println("Original String \t" + str);
//        System.out.println("Reverse String \t" + revString);
//        iterativeReverse(str);

        System.out.println("Recursive reverse \t" + stringReverse(str).toString());
    }
}
