package main.java.com.personal.String;

/**
 * Created by riyaz on 8/8/15.
 */
public class RemoveSpacesInString {
    public static void main(String[] args) {
        String str = "g  eeks     for ge  eeks  ";
        str = str.replaceAll("\\s+","");
        System.out.println(str);

    }
}
