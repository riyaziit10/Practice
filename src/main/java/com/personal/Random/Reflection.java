package main.java.com.personal.Random;

import java.lang.reflect.Modifier;

/**
 * Created by riyaz on 21/10/15.
 */

interface XYZ {
void show();
}
class ABC {

}
final class TestDemo extends ABC  implements XYZ{

    public TestDemo(String a) {
        System.out.println("String constructor");
    }

    public TestDemo(Integer i) {
        System.out.println("Integer Constructor");
    }

    public TestDemo() {
    }

    @Override
    public void show() {
        System.out.println("XYZ interface's method");
    }
}
public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
//        String str = "Riyaz";
        Class className = TestDemo.class;

        System.out.println("Reflection Example \t" + className.getName());
        System.out.println("Reflection Example \t" + className.getSimpleName());

        int sepecifier = className.getModifiers();

        System.out.println("Is final \t" + Modifier.isFinal(sepecifier));
        System.out.println("Pakage name \t" + className.getPackage());
        System.out.println("Super class \t " + className.getSuperclass().getSimpleName());
        System.out.println("Interface \t" + className.getInterfaces()[0]);

        System.out.println("Constructore\t" + className.getConstructors()[0]);

//        Class name = Class.forName("main.java.com.personal.Random.Reflection");
//        System.out.println(name);
        ;
    }
}
