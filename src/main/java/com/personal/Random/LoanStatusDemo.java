package main.java.com.personal.Random;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by riyaz on 21/10/15.
 */
enum LoanStatus {

    DISABLED(-2), NOT_ALLOWED(-1), NOT_APPLIED(0), APPROVED_IN_PRINCIPAL(1), APPROVED(2), REJECTED(3);

    private int                             code;
    private static Map<Integer, LoanStatus> codeToValueMap = new HashMap<Integer, LoanStatus>();
    private static int min, max;

    static {
        min=Integer.MAX_VALUE;
        max=Integer.MIN_VALUE;

        for (LoanStatus type : LoanStatus.values()) {
            codeToValueMap.put(type.code, type);

            if(type.code<min)
                min=type.code;

            if(type.code>max)
                max=type.code;
        }
    }

    private LoanStatus(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    public static LoanStatus getLoanStatusByCode(int code) {
        return codeToValueMap.get(code);
    }

    public static int getMinCode() {
        return min;
    }

    public static int getMaxCode() {
        return max;
    }
}


public class LoanStatusDemo {
    public static LoanStatus loanStatus=LoanStatus.APPROVED;
    public static void main(String[] args) {
        System.out.println(loanStatus.name());
    }
}