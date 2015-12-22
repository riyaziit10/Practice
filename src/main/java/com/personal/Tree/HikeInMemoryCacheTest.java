//package main.java.com.personal.Tree;
//
//import org.apache.commons.collections.MapIterator;
//import org.apache.commons.collections.map.LRUMap;
//
//import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;
//
//
//import static java.util.concurrent.TimeUnit.MICROSECONDS;
//
//interface ExpiryCache<K, V> {
//    void put(K key,V value,int ttl, TimeUnit timeUnit);
//
//    V get(K key);
//
//}
//class HikeInMemoryCache<K, V> implements ExpiryCache<K, V>{
//    private LRUMap CacheMap;
//
//    protected class CacheObject {
//        public long lastAccessed = System.currentTimeMillis();
//
//        public V value;
//
//        public int ttl;
//
//        public TimeUnit timeunit;
//
//        protected CacheObject(V value, int ttl, TimeUnit timeUnit) {
//            this.value = value;
//            this.ttl = ttl;
//            this.timeunit = timeUnit;
//        }
//    }
//
//    public HikeInMemoryCache(final long timerInterval, int maxItems) {
//        CacheMap = new LRUMap(maxItems);
//
//        if (timerInterval > 0) {                                            //Time interval use for removing stale items
//
//            Thread t = new Thread(new Runnable() {
//                public void run() {
//                    while (true) {
//                        try {
//                            Thread.sleep(timerInterval * 1000);
//                        } catch (InterruptedException ex) {
//                        }
//                        cleanup();
//                    }
//                }
//            });
//
//            t.setDaemon(true);
//            t.start();
//        }
//    }
//
//    public void put(K key, V value, int ttl  , TimeUnit timeUnit) {
//        synchronized (CacheMap) {
//            CacheMap.put(key, new CacheObject(value, ttl, timeUnit));
//        }
//    }
//
//    public V get(K key) {
//        synchronized (CacheMap) {
//            CacheObject c = (CacheObject) CacheMap.get(key);
//            if (c == null)
//                return null;
//            else {
//                long expiryTime = TimeUnit.MILLISECONDS.convert(c.ttl, c.timeunit);
//                long currentTime  = System.currentTimeMillis();
//                if(expiryTime > currentTime) {
//                    CacheMap.remove(key);
//                    return null;
//                }
//                return c.value;
//            }
//        }
//    }
//
//    public void remove(K key) {
//        synchronized (CacheMap) {
//            CacheMap.remove(key);
//        }
//    }
//
//    public int size() {
//        synchronized (CacheMap) {
//            return CacheMap.size();
//        }
//    }
//
//    public void cleanup() {
//
//        long now = System.currentTimeMillis();
//        ArrayList<K> deleteKey = null;
//
//        synchronized (CacheMap) {
//            MapIterator itr = CacheMap.mapIterator();
//            deleteKey = new ArrayList<K>();
//            K key = null;
//            CacheObject c = null;
//            while (itr.hasNext()) {
//                key = (K) itr.next();
//                c = (CacheObject) itr.getValue();
//
//                if (c != null && (now > (c.ttl + c.lastAccessed))) {
//                    deleteKey.add(key);
//                }
//            }
//        }
//        for (K key : deleteKey) {
//            synchronized (CacheMap) {
//                CacheMap.remove(key);
//            }
//
//            Thread.yield();
//        }
//    }
//}
//
//public class HikeInMemoryCacheTest {
//
//    public static void main(String[] args) throws InterruptedException {
//
//        HikeInMemoryCacheTest hikeCache = new HikeInMemoryCacheTest();
//
//        System.out.println("\n\n==========Test1: AddRemoveObjects ==========");
//        hikeCache.hikeTestAddRemoveObjects();
//        System.out.println("\n\n==========Test2: ExpiredCacheObjects ==========");
//        hikeCache.hikeTestExpiredCacheObjects();
//        System.out.println("\n\n==========Test3: ObjectsCleanupTime ==========");
//        hikeCache.hikeTestObjectsCleanupTime();
//    }
//
//    private void hikeTestAddRemoveObjects() {
//
//        HikeInMemoryCache<String, String> cache = new HikeInMemoryCache<String, String>(500, 6);
//
//        cache.put("eBay", "eBay", 10, MICROSECONDS);
//        cache.put("Paypal", "Paypal", 10, MICROSECONDS);
//        cache.put("Paypal", "Paypal", 10, MICROSECONDS);
//        cache.put("Google", "Google", 10, MICROSECONDS);
//        cache.put("Microsoft", "Microsoft", 10, MICROSECONDS);
//        cache.put("IBM", "IBM", 10, MICROSECONDS);
//        cache.put("Facebook", "Facebook", 10, MICROSECONDS);
//
//        System.out.println("6 Cache Object Added.. cache.size(): " + cache.size());
//        cache.remove("IBM");
//        System.out.println("One object removed.. cache.size(): " + cache.size());
//
//        cache.put("Twitter", "Twitter", 10, MICROSECONDS);
//        cache.put("SAP", "SAP", 10, MICROSECONDS);
//        System.out.println("Two objects Added but reached maxItems.. cache.size(): " + cache.size());
//
//    }
//
//    private void hikeTestExpiredCacheObjects() throws InterruptedException {
//
//        HikeInMemoryCache<String, String> cache = new HikeInMemoryCache<String, String>(1, 10);
//
//        cache.put("eBay", "eBay",10, MICROSECONDS);
//        cache.put("Paypal", "Paypal", 10, MICROSECONDS);
//        Thread.sleep(3000);
//
//        System.out.println("Two objects are added but reached timeToLive. cache.size(): " + cache.size());
//
//    }
//
//    private void hikeTestObjectsCleanupTime() throws InterruptedException {
//        int size = 500000;
//
//        HikeInMemoryCache<String, String> cache = new HikeInMemoryCache<String, String>(100, 500000);
//
//        for (int i = 0; i < size; i++) {
//            String value = Integer.toString(i);
//            cache.put(value, value, 10, MICROSECONDS);
//        }
//
//        Thread.sleep(200);
//
//        long start = System.currentTimeMillis();
//        cache.cleanup();
//        double finish = (double) (System.currentTimeMillis() - start) / 1000.0;
//
//        System.out.println("Cleanup times for " + size + " objects are " + finish + " s");
//
//    }
//}