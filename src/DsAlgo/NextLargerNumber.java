package DsAlgo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by riyaz on 30/5/15.
 */
public class NextLargerNumber {

    static String nextLagerNumber(String number) {
        try {
            Integer.parseInt(number);
        }catch (NumberFormatException e) {
            System.out.println("Not a valid number");
            return null;
        }

        if(number.length() == 1) {
            System.out.println("Larger Number is not possible from single digit");
            return null;
        }

        List<Integer> digits = new ArrayList<Integer>();
        for(int i=0 ; i < number.length(); ++i) {
            Integer digit = Integer.parseInt(number.substring(i,i + 1));
            if(digits.contains(digit)) {
                System.out.println("Not Unique digits");
                return null;
            }
            digits.add(digit);

        }

        int  listSize = digits.size(), i, j, samllerDigit=0;
        for( i = listSize - 1; i > 0; --i) {
            if (digits.get(i) > digits.get(i - 1)) {
                samllerDigit = i - 1;
                break;
            }
        }

        if(i == 0) {
            System.out.println("Next Larger number is not possible ");
            return null;
        }

        int nextGreaterDigit = samllerDigit + 1;
        for(j = samllerDigit + 1; j < listSize; ++j) {
            if (digits.get(j) > digits.get(samllerDigit) && digits.get(j) < digits.get(nextGreaterDigit)) {
                nextGreaterDigit = j;
            }
        }
        swap(digits, samllerDigit, nextGreaterDigit);
        ++samllerDigit;
        while(samllerDigit < nextGreaterDigit) {
            swap(digits,samllerDigit,nextGreaterDigit );
            ++samllerDigit;
            --nextGreaterDigit;
        }
        String output="";
        for (Integer r : digits) {
            output +=r;
        }
        return output;
    }
    static void swap(List<Integer> number, int i, int j) {
        int temp = number.get(i);
        number.set(i, number.get(j));
        number.set(j, temp);
    }
    public static void main(String[] args) throws IOException {
        String output= nextLagerNumber("218765");
        //int output = nextLagerNumber("4321");
        if(output != null) {
            System.out.println(output);
        }
    }
}
