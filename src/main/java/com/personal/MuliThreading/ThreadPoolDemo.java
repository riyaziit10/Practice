package main.java.com.personal.MuliThreading;

/**
 * Created by riyaz on 1/9/15.
 */
class Processor implements  Runnable {

    private int id;

    private String filename;


    public Processor(int id) {
        this.filename = filename;
    }


    @Override
    public void run() {
//        System.out.println("starting thread\t" + id);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Finishing Thread \t" + id);

//        read()



    }
}
public class ThreadPoolDemo {
    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//
//        for(int i = 0; i < 10; ++i) {
//                executor.submit(new Processor("file" + 1));
//        }
//        executor.shutdown();
//
//        try {
//            executor.awaitTermination(1, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("All task finished..");
    }

}
