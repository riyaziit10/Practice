package Random;

/**
 * Created by riyaz on 7/6/15.
 */
public class ThreadDemo extends  Thread {
    private static int i = 0;

    public void run() {
        for(int k= 0; k < 10; k++) {
            ++i;
            try {
                sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("from thread"+this.getName() +" \t" + i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo td1 = new ThreadDemo();
        ThreadDemo td2 = new ThreadDemo();
        System.out.println(td1.getId() + "\t" + td1.getName());

        System.out.println(td2.getId() + "\t" + td2.getName());
            td1.start();
            td2.start();
    }
}
