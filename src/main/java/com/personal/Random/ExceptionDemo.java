package main.java.com.personal.Random;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by riyaz on 12/7/15.
 */
class NoSuchProductException extends RuntimeException {
    Integer productId;

    public NoSuchProductException() {
        super();
    }

    public NoSuchProductException(String message, Throwable cause, Integer productId) {
        super(message, cause);
        this.productId = productId;
    }

    public NoSuchProductException(String message, Integer productId) {
        super(message);
        this.productId = productId;
    }
}
public class ExceptionDemo {
    private static final Map<Integer, String> map =  new HashMap<Integer, String>();

    public String getProduct(Integer productId) {
        return map.get(productId);
    }

    static {
        map.put(1000, "Honda bike");
        map.put(2000, "Royal Enfield Classic");
        map.put(3000, "Royaz Enfield Classic 500 CC");
    }

    public static void main(String[] args) {
        ExceptionDemo ed = new ExceptionDemo();
        Integer productId = 1020;
        if (ed.getProduct(productId) == null)
            throw  new NoSuchProductException("No such product" , productId);

    }
}
