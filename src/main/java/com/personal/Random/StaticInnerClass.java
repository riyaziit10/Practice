package Random;

/**
 * Created by riyaz on 7/6/15.
 */
public class StaticInnerClass {

    private static int a = 1000;

    static class InnerStatic {
        public static void show() {
            System.out.println("Value from innner class " + a);
        }
    }
    public class InnerClass {
        void show () {
            System.out.println(a);
        }
    }
    public static void main(String[] args) {
        StaticInnerClass.InnerStatic.show();
        StaticInnerClass outerObject = new StaticInnerClass();
        StaticInnerClass.InnerClass innerObject = outerObject.new InnerClass();
        innerObject.show();
    }
}
