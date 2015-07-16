package Random;

/**
 * Created by riyaz on 7/6/15.
 */
class vehicale {
    void show() {
        System.out.println("vehicle");
    }
}
class Bus extends vehicale{
    void show() {
        System.out.println("Bus");
    }
}
class Car extends vehicale{
    void show() {
        System.out.println("Car Car");
    }
}
class BMW  extends Car{
    void show() {
        System.out.println("BMW");
    }
}
public class Casting {
    public static void main(String[] args) {
        vehicale v1 = new Car();
        v1.show();
        vehicale v2 = new vehicale();
        v2.show();
        Car c = (Car) v2;
        c.show();
    }
}
