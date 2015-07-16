package Random;

/**
 * Created by riyaz on 27/6/15.
 */
class Testy {
    int x;
    int y;

    public Testy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Testy() {
        this(10,10);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class MainDemo {

    public static void main(String[] args) {
        int x = -1;
        System.out.println(x >>> 29);
        System.out.println(x >>> 30);
        System.out.println(x >>> 31);

        System.out.println( 10 * 20 + "Riyaz Ali");
        System.out.println("Riyaz Ali" + 10 * 20);
    }
}
