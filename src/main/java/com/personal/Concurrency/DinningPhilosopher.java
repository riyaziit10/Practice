package Concurrency;

/**
 * Created by riyaz on 7/7/15.
 */
public class DinningPhilosopher {
    private Object[] Fork;
    private Philosphor[] philosphors;

    public DinningPhilosopher(int num) {
        Fork = new Object[num];
        philosphors = new Philosphor[num];
        for (int i = 0; i < num; ++i) {
            Fork[i] = new Object();
            int fork1 = i;
            int fork2 = (i + 1) % num;
            if( i == 0)
                this.philosphors[i] = new Philosphor(i, fork2, fork1);
            else
                this.philosphors[i] = new Philosphor(i, fork1, fork2);

        }
    }

    public void eat() throws InterruptedException {
        for (int i = 0; i < philosphors.length; ++i) {
            philosphors[i].start();
        }
//        philosphors[0].join();
    }

    private class Philosphor extends Thread {
        int num;
        int fork1;
        int fork2;

        public Philosphor(int num, int fork1, int fork2) {
            this.num = num;
            this.fork1 = fork1;
            this.fork2 = fork2;
        }

        public void run() {
            pause();
            while (true) {
                synchronized (Fork[fork1]) {
                    System.out.print("picked fork 1 \t" + fork1);
                    synchronized (Fork[fork2]) {
                        System.out.print("picked fork 2 \t" +fork2);
                    }
                    System.out.println("\tStart Eating");
                }
            }
        }
        private void pause() {
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DinningPhilosopher d = new DinningPhilosopher(5);
        d.eat();
    }
}



