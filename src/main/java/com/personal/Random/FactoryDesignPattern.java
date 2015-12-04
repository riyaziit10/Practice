package main.java.com.personal.Random;

import com.sun.java.swing.plaf.motif.MotifOptionPaneUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by riyaz on 19/11/15.
 */
interface Currency {
    String getCurrency();
}
class Rupee implements Currency {

    @Override
    public String getCurrency() {
        return "Rupee";
    }
}
class Doller implements Currency {

    @Override
    public String getCurrency() {
        return "Doller";
    }
}

class FactoryMethod {
    public static Currency getInstance(String str) {
        if("Rupee".equalsIgnoreCase(str))
            return new Rupee();
        if("Doller".equalsIgnoreCase(str))
            return new Doller();
        throw new IllegalArgumentException("Class not found");
    }
}
public class FactoryDesignPattern {

    public static void main(String[] args) {
        Currency currency = FactoryMethod.getInstance("Rupee");
        System.out.println("Input was \t" + currency.getCurrency());

    }
}
