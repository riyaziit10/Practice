package DsAlgo;

/**
 * Created by riyaz on 30/5/15.
 */
public class NextSmallestPallindrome {

    static StringBuffer reverse(String str) {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse();
    }
    static String evenPallindrome(String num) {
        String firstHalf = num.substring(0, num.length() / 2);
        String secondHalf= num.substring(num.length() / 2, num.length());
        System.out.println("First of the string is \t" + firstHalf);
        System.out.println("Second half of the string is \t" + secondHalf);
        StringBuffer firstHalfReverse= reverse(firstHalf);
        System.out.println("Reverse of First half of the string is\t " + firstHalfReverse);
        if(Integer.parseInt(firstHalfReverse.toString()) > Integer.parseInt(secondHalf.toString()))
            return firstHalf.concat(firstHalfReverse.toString());
        else {
           Integer incre = Integer.parseInt(firstHalf.toString()) + 1;
            return incre.toString()   + new StringBuffer(incre.toString()).reverse();
        }
    }

    static String oddPallindrome(String num) {
        String firstHalf = num.substring(0, num.length() / 2);
        String secondHalf = num.substring(num.length() / 2 + 1, num.length());
        System.out.println("firstHalf\t" + firstHalf + "\tsecond half\t" + secondHalf);
        StringBuffer firstHalfReverse = reverse(firstHalf);
        System.out.println("Reverse of first half is\t" + firstHalfReverse);
        if(Integer.parseInt(firstHalfReverse.toString()) > Integer.parseInt(secondHalf))
            return firstHalf + num.charAt(num.length()/2) + firstHalfReverse.toString();
        else {
            Integer inc = Integer.parseInt(firstHalfReverse.toString()) + 1;
            return inc.toString() + (new StringBuffer(inc.toString()).reverse()).substring(1,inc.toString().length());
        }
    }
    public static void main(String[] args) {
        String num = "999";
        int i=0;
        for(i = 0; i < num.length(); ++i) {
            String s = num.substring(i, i+1);
            if(Integer.parseInt(s) != 9)
                break;
        }
        if( i == num.length()) {
            System.out.println(Integer.parseInt(num) + 2);
            return;
        }
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException e) {
            System.out.println("Please provide a valid number");
            return ;
        }



        int length = num.length();
        if(length % 2 == 0)
            System.out.println("Next Larger Pallindrom is even" + evenPallindrome(num));
        else
            System.out.println("Next Larger Pallindrome is odd " + oddPallindrome(num));

    }
}
