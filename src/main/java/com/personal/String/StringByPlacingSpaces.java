package main.java.com.personal.String;

/**
 * Created by riyaz on 8/8/15.
 */
public class StringByPlacingSpaces {
    private static void getString(String str,char[] result, int i, int j) {
        if(i == str.length()) {
            String res = new String(result);
            System.out.println(res.trim());
            return;
        }
        result[j] = str.charAt(i);
        getString(str, result, i + 1, j + 1);
        result[j]='-';
        result[j+1]=str.charAt(i);
        getString(str,result,i+1, j+2);

    }

    public static void main(String[] args) {
        String input = "ABCD";
        char []result = new char[input.length() * 2];
        result[0]=input.charAt(0);
        getString(input, result, 1, 1);

    }
}
