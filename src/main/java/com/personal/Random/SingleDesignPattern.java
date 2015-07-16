package Random;

/**
 * Created by riyaz on 7/6/15.
 */

public class SingleDesignPattern {
    public static SingleDesignPattern sdp = new SingleDesignPattern();

    private SingleDesignPattern() {
    }

    public static SingleDesignPattern getInstance() {
        return  sdp;
    }

    void show () {
        System.out.println("SinglePattern");
    }

    public static void main(String[] args) {
        SingleDesignPattern.getInstance().show();

        SingleDesignPattern sd = new SingleDesignPattern();
        sd.show();
    }
}
