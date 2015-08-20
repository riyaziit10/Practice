package main.java.com.personal.String;

/**
 * Created by riyaz on 16/8/15.
 */
public class ExcelColumnName {
    private static void getColumnName(String str) {
        if(str == null || str.length() == 0)
            return;
        int number = 0;
        try {
            number  = Integer.parseInt(str);
        }catch(NumberFormatException e) {
            System.out.println(e);
            return;
        }
        int remender = 0;
        StringBuilder sb = new StringBuilder();
        while(number != 0) {
            remender = number % 26;
            if(remender != 0)
            sb.insert(0,(char) (remender + 64));
            else {
                number = number - 26;
                sb.insert(0,'Z');
            }
            number = number/ 26;
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        String str1 = "26";
        getColumnName(str1);
        System.out.println("=============================");
        String str2 = "51";
        getColumnName(str2);
        System.out.println("=================");
        String str3 = "52";
        getColumnName(str3);
        System.out.println("================");
        String str4 = "80";
        getColumnName(str4);
        System.out.println("==================");
        String str5 = "676";
        getColumnName(str5);
        System.out.println("=============");
        String str6 = "702";
        getColumnName(str6);
        System.out.println("=================");
        String str7 ="705";
        getColumnName(str7);

    }
}
