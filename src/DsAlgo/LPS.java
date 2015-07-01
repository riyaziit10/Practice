package DsAlgo;

/**
 * Created by riyaz on 9/6/15.
 */
public class LPS {
    private static int LPS(String str, int i , int j) {
        if(str == "" || str == null)
            return 0;
        if( i == j)
            return 1;
        if(i > j)
            return 0;
        if(str.charAt(i) == str.charAt(j))
            return 2 + LPS(str, i + 1, j - 1);
        else
            return Math.max(LPS(str, i + 1, j), LPS(str, i, j - 1));

    }
    public static void main(String[] args) {
        String  str  = "BBABCBCAB";
        int length = str.length();

    System.out.println(LPS(str, 0, length - 1));
    }
}
