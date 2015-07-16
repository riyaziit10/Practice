package MuliThreading;

/**
 * Created by riyaz on 9/7/15.
 */
public class Multi {

    private static class MyThread extends Thread {
        private volatile Thread stopIndicatgor;
        public void start() {
            stopIndicatgor = new Thread(this);
            stopIndicatgor.start();
        }
        public MyThread(String name) {
            super(name);
        }
        public void run() {
            System.out.println(Thread.currentThread().getName());
            while(Thread.currentThread() == stopIndicatgor) {
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e) {

                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread("mythread");
        myThread.run();
    }
}
