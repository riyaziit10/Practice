package main.java.com.personal.Random;

/**
 * Created by riyaz on 28/10/15.
 */
public class Last10Lines {

    private static void print_last_lines(String str, int n) {

        if(n < 0)
            return;

        int lastIndex = str.lastIndexOf('\n');

        if(lastIndex == -1) {
            System.out.println("FILE is not properly ended");
            return;
        }

        int count = 0;
        int i=lastIndex;
        while(true) {
            while(i>=0 && str.charAt(i) != '\n')
                --i;
            if(i>=0 && str.charAt(i) == '\n') {
                count++;
                --i;
                if(count == 10)
                    break;
            } else
                break;

        }
        System.out.println(str.substring(i + 1));
    }
    public static void main(String[] args) {
        String str1 = "str1\nstr2\nstr3\nstr4\nstr5\nstr6\nstr7\nstr8\nstr9" +
                    "\nstr10\nstr11\nstr12\nstr13\nstr14\nstr15\nstr16\nstr17" +
                    "\nstr18\nstr19\nstr20\nstr21\nstr22\nstr23\nstr24\nstr25";
        String  str2 = "str1\nstr2\nstr3\nstr4\nstr5\nstr6\nstr7";
        String  str3 = "\n";
        String  str4 = "";

        print_last_lines(str1, 10);
        System.out.println("-----------------\n");
//
        print_last_lines(str2, 10);
        System.out.println("-----------------\n");
//
        print_last_lines(str3, 10);
        System.out.println("-----------------\n");
//
        print_last_lines(str4, 10);
        System.out.println("-----------------\n");

    }


}
