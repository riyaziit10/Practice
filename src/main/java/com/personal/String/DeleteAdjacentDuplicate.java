package main.java.com.personal.String;

/**
 * Created by riyaz on 15/8/15.
 */
public class DeleteAdjacentDuplicate {
    private static void  deleteAdjacentDuplicateCharacter(StringBuilder str) {
        if(str == null || str.length() <=1) {
            return;
        }
        int j = 0;
        int i = 1;
        while(i < str.length()) {
            if(i < str.length() && str.charAt(i) == str.charAt(j)) {
                while (i < str.length() && str.charAt(i) == str.charAt(j)) {
                    str.deleteCharAt(i);
                }

                str.deleteCharAt(j);
                if(j != 0)
                    --j;
                i = j + 1;
            }
            if(i < str.length() && str.charAt(i) != str.charAt(j)){
                str.setCharAt(++j, str.charAt(i));
                ++i;
            }
        }
        System.out.println(str);
    }
    public static void main(String[] args) {


        deleteAdjacentDuplicateCharacter(new StringBuilder( "geeksforgeeg"));

        deleteAdjacentDuplicateCharacter(new StringBuilder("azxxxzy"));

        deleteAdjacentDuplicateCharacter(new StringBuilder("caaabbbaac"));

        deleteAdjacentDuplicateCharacter(new StringBuilder("gghhg"));

        deleteAdjacentDuplicateCharacter(new StringBuilder("aaaacddddcappp"));

        deleteAdjacentDuplicateCharacter(new StringBuilder("aaaaaaaaaa"));

        deleteAdjacentDuplicateCharacter(new StringBuilder("qpaaaaadaaaaadprq"));

        deleteAdjacentDuplicateCharacter(new StringBuilder("acaaabbbacdddd"));

        deleteAdjacentDuplicateCharacter(new StringBuilder("acbbcddc"));



    }
}
