package Random;

/**
 * Created by riyaz on 24/6/15.
 */
public class CountWords {
    public static void main(String[] args) {
        String str = "     My                name is Riyaz Ali           ";
        String sb = str.trim();
        if(sb.length() == 0) {
            System.out.println("No of Words 0");
            return;
        }
        System.out.println("No of words are \n " + sb.split("\\s+").length);
    }
}
