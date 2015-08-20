package main.java.com.personal.String;

/**
 * Created by riyaz on 12/8/15.
 */
public class IsInterleave {
    private static boolean isInterleaved(String str1, int m, String str2, int n, String interleavedString, int index) {
        if (str1 == null || str2 == null || interleavedString == null)
            return false;
        int str1Length = str1.length();
        int str2Length = str2.length();
        if (index == str1Length + str2Length)
            return true;
        if (m < str1Length && interleavedString.charAt(index) == str1.charAt(m))
            return isInterleaved(str1, m + 1, str2, n, interleavedString, index + 1);
        else if (n < str2Length && interleavedString.charAt(index) == str2.charAt(n))
            return isInterleaved(str1, m, str2, n + 1, interleavedString, index + 1);
        return false;

    }

    private static boolean isInterleavedV2(String str1, int m, String str2, int n, String str3, int i) {
        if (str1 == null || str2 == null || str3 == null)
            return false;
        if (str3.length() != str1.length() + str2.length())
            return false;
        if (i == str3.length() && m == str1.length() && n == str2.length()) {
            return true;
        }
        if (m < str1.length() && n < str2.length() && str1.charAt(m) == str2.charAt(n) && str3.charAt(i) == str2.charAt(n)) {
            return isInterleavedV2(str1, m + 1, str2, n, str3, i + 1) || isInterleavedV2(str1, m, str2, n + 1, str3, i + 1);
        } else if (m < str1.length() && str3.charAt(i) == str1.charAt(m)) {
            return isInterleavedV2(str1, m + 1, str2, n, str3, i + 1);
        } else if (n < str2.length() && str3.charAt(i) == str2.charAt(n)) {
            return isInterleavedV2(str1, m, str2, n + 1, str3, i + 1);
        }
        return false;
    }

    private static boolean isInterleavedDp(String str1, String str2, String str3) {
        if (str1 == null && str2 == null && str3 == null)
            return true;
        if (str1 == null || str2 == null || str3 == null)
            return false;
        if (str3.length() != str1.length() + str2.length())
            return false;
        int str1_length = str1.length();
        int str2_length = str2.length();

        boolean[][] memo = new boolean[str1_length + 1][str2_length + 1];
        for (int i = 0; i <= str1_length; ++i) {
            for (int j = 0; j <= str2_length; ++j) {
                if (i == 0 && j == 0)
                    memo[i][j] = true;
                else if (i == 0) {
                    memo[i][j] = str2.charAt(j - 1) == str3.charAt(i + j - 1) ? memo[i][j - 1] : false;
                } else if (j == 0) {
                    memo[i][j] = str1.charAt(i - 1) == str1.charAt(i + j - 1) ? memo[i - 1][j] : false;
                } else if (str1.charAt(i - 1) == str3.charAt(i + j - 1) && str2.charAt(j - 1) != str3.charAt(i + j - 1))
                    memo[i][j] = memo[i - 1][j];
                else if (str2.charAt(j - 1) == str3.charAt(i + j - 1) && str1.charAt(i - 1) != str3.charAt(i + j - 1))
                    memo[i][j] = memo[i][j - 1];
                else if (str1.charAt(i - 1) == str3.charAt(i + j - 1) && str2.charAt(j - 1) == str3.charAt(i + j - 1))
                    memo[i][j] = (memo[i - 1][j] || memo[i][j - 1]);
            }
        }
        return memo[str1_length][str2_length];
    }

    public static void main(String[] args) {
        String str1 = "AB";
        String str2 = "CD";
        String str3 = "ACBD";
//        System.out.println(isInterleaved(str1, 0, str2, 0, str3, 0));
//        System.out.println(isInterleavedV2(str1, 0, str2, 0, str3, 0));

        System.out.println(isInterleavedV2("XXY", 0, "XXZ", 0, "XXZXXXY", 0));
        System.out.println(isInterleavedDp("XXY", "XXZ", "XXZXXXY"));
        System.out.println("============================================");
        System.out.println(isInterleavedV2("XY", 0, "WZ", 0, "WZXY", 0));
        System.out.println(isInterleavedDp("XY", "WZ", "WZXY"));
        System.out.println("==========================================");
        System.out.println(isInterleavedV2("XY", 0, "X", 0, "XXY", 0));
        System.out.println(isInterleavedDp("XY", "X", "XXY"));
        System.out.println("==========================================");
        System.out.println(isInterleavedV2("YX", 0, "X", 0, "XXY", 0));
        System.out.println(isInterleavedDp("YX", "X", "XXY"));
        System.out.println("=================================");
        System.out.println(isInterleavedV2("XXY", 0, "XXZ", 0, "XXXXZY", 0));
        System.out.println(isInterleavedDp("XXY", "XXZ", "XXXXZY"));
    }
}
