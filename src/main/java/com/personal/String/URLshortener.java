package main.java.com.personal.String;

/**
 * Created by riyaz on 8/8/15.
 */
public class URLshortener {
    public static void main(String[] args) {
        int n = 123456;
        String shorturl = idToShortURL(n);
        System.out.println("Generated short url is \t"  + shorturl );
        System.out.println("original id was \t" + shortURLtoID(shorturl));
    }

    private static int shortURLtoID(String shorturl) {
        if(shorturl == null || shorturl.length() == 0)
            return 0;
        int length = shorturl.length();
        int result = 0;
        int i = 0 ;
        while(i < length) {
            char ch = shorturl.charAt(i);
            if(ch >= 'a' && ch <= 'z')
                result += (ch - 'a') * Math.pow(62, i);
            else if(ch >= 'A' && ch <= 'Z')
                result +=  (ch - 'A' + 26)  * Math.pow(62, i);
            else result += (ch - '0' + 52)  * Math.pow(62, i);
            ++i;
        }
        return result;
    }

    private static String idToShortURL(int id) {

        char [] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        String shortUrl = "";
        while(id != 0) {
            shortUrl += map[id%62];
            id = id / 62;
        }
        return shortUrl;
    }
}
