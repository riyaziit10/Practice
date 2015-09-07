package main.java.com.personal.Random;

import java.util.concurrent.*;

/**
 * Created by riyaz on 7/9/15.
 */
class Demo1 {

    private static int variable = 0;
    public int add(int start, int end) {
        int sum = 0;
        for(int i= start; i < end; ++i)
            sum += i;

        return sum;
    }


    public void printEven() {
        while(true) {
            if(variable % 2 ==0 )
            System.out.println("Thread1" + variable);
            ++variable;
        }

    }

}
public class Test1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final Demo1 demo1 = new Demo1();
        Integer start = 1;
        Integer end = 10;
        ExecutorService workers = Executors.newCachedThreadPool();
        int total = 0;
        for(int i = 0; i < 10; ++i) {
            total += addFn(workers,demo1,start,end);
//            start = ;
//            end = end + 10;
        }

        System.out.println("Total number is \t" + total);

    }

    public static int addFn(ExecutorService workers, final Demo1 demo1, final Integer one, final Integer two) throws ExecutionException, InterruptedException {
        int total = 0;
        Future<Integer> sum = workers.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return demo1.add(one, two);
            }
        });

        return sum.get();
    }
}
