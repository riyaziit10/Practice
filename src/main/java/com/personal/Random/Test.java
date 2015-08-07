package  main.java.com.personal.Random;


public class Test {

    protected void finalize() {
        System.out.println("RIP");
    }

    public static void main(String[] args) throws Exception {

        Test  t = new Test();
        System.out.println("========Tests=============");
    }
}

