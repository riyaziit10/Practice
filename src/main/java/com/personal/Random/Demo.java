package main.java.com.personal.Random;

import java.util.Scanner;

/**
 * Created by riyaz on 31/8/15.
 */

class Processor extends  Thread {

    private static volatile boolean running  = true;
    @Override
    public void run() {
        while(running) {
            System.out.println("hello");
            try {
                Thread.sleep(100
                );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  void shutSown() {
        running = false;
        System.out.println("Thread has been shut down");
    }
}
public class Demo {
    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 0 ; i < 10; ++i)
//                    System.out.println(i*10);
//            }
//        });
//        t1.start();

       Processor p = new Processor();
        p.start();

        System.out.println("Please hit enter to stop");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();

        p.shutSown();


    }
}
