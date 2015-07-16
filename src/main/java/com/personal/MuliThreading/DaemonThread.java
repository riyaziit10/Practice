package MuliThreading;

/**
 * Created by riyaz on 9/7/15.
 * A daemon thread is a thread whose execution state is not evaluated when the JVM decides if it should stop or not
 */
public class DaemonThread {
    private static class MyDaemon extends Thread {
        public MyDaemon() {
            setDaemon(true);
        }

        public void run () {
            System.out.println("Hello");
            while(true) {
                try {
                    System.out.println("hi");
                    Thread.sleep(1);
                }catch (InterruptedException e){
                    System.out.println("Interruptes");
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread d  = new MyDaemon();
        d.start();
        System.out.println("After thread");
    }
}
