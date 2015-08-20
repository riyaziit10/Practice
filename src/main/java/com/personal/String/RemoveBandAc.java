package main.java.com.personal.String;

/**
 * Created by riyaz on 15/8/15.
 */
public class RemoveBandAc {
    private static void removeBandAC(String str) {
        if (str == null || str.length() == 0)
            return;
        StringBuilder sb = new StringBuilder(str);
        int i = 0;
        while (i < sb.length()) {
            if (i + 1 < sb.length()) {
                if (sb.charAt(i) == 'a' && sb.charAt(i + 1) == 'c') {
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                    continue;
                }
            }
            if (sb.charAt(i) == 'b') {
                sb.deleteCharAt(i);
                continue;
            }
            ++i;
        }

    System.out.println(str + "\tString \t" + sb);
}

    public static void main(String[] args) {
        String str = "acbac";
        removeBandAC(str);
        String str1 = "aaac";
        removeBandAC(str1);
        String str2 = "ababac";
        removeBandAC(str2);
        String  str3 = "bbbbd";
        removeBandAC(str3);
        String  str4 = "ad";
        removeBandAC(str4);

        String str5 = "acbac";
        removeBandAC(str5);

        String str6 = "aaac";
        removeBandAC(str6);

        String str7 = "react";
        removeBandAC(str7);

        String str8 = "aa";
        removeBandAC(str8);

        String str9 = "ababaac";
        removeBandAC(str9);

    }
}
