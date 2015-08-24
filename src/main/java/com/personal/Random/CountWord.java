//package main.java.com.personal.Random;
//
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicLong;
//
///**
// * Created by riyaz on 23/8/15.
// */
//public class CountWord {
//    private ConcurrentMap<String , AtomicLong> map = new ConcurrentHashMap<String, AtomicLong>();
//    public void  addWord(String word) {
//        AtomicLong l = map.get(word);
//        if(l == null) {
//            l = new AtomicLong(1);
//            l = map.putIfAbsent(word,l);
//            if(l != null) {
//                l.incrementAndGet();
//            }
//        } else {
//            l.incrementAndGet();
//        }
//
//    }
//
//
//    public Long getCount(String word) {
//        AtomicLong l = map.get(word);
//        if(l != null) {
//            return l.longValue();
//        }
//        return 0l;
//    }
//    public static void main(String[] args) {
//        ExecutorService executorService1 = Executors.newFixedThreadPool(20);
//        ExecutorService executorService2 = Executors.newFixedThreadPool(20);
//        ExecutorService executorService3 = Executors.newFixedThreadPool(20);
//        int total = 1000;
//        CountDownLatch latch = new CountDownLatch(3 * total);
//        CountWord cw = new CountWord();
//        for(int i = 0; i < total; ++i) {
////            executorService1.execute(() -> cw.addWord("word1"));
//            executorService1.execute(() -> cw.addWord("word1"));
//        }
//    }
//}
