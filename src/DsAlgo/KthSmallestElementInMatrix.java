package DsAlgo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by riyaz on 31/5/15.
 */
public class KthSmallestElementInMatrix implements Comparator{
    @Override
    public int compare(Object o, Object t1) {

        Element e1 = (Element)o;
        Element e2 = (Element)t1;
        return e1.e - e2.e;
    }

    static class Element  {
        int e, i, j;

        public Element(int e, int i, int j) {
            this.e = e;
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "e=" + e +
                    ", i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception{
        int [] [] mat = { {10, 20, 30, 40},
            {15, 25, 35, 45},
            {25, 29, 37, 48},
            {32, 33, 39, 50},
        };
        PriorityQueue<Element> pq = new PriorityQueue<Element>(10, new KthSmallestElementInMatrix());
        pq.add(new Element(10,0,0));
        pq.add(new Element(15,1,0));
        pq.add(new Element(25, 2, 0));
        pq.add(new Element(32, 3, 0));
        int m = 4;
        int [] index = new int[m];
        int k =7;
        for (int i= 0; i < k ; ++i) {
            Element element = pq.poll();
            System.out.println(element.e + "\t" + element.i + "\t" + element.j);
            if(index[element.i] < m    && index[element.i] >= 0) {
                index[element.i] += 1;
                pq.add(new Element(mat[element.i][index[element.i]], element.i, index[element.i]));
            } else {
                index[element.j] = -1;
                while(index[element.j] < 0) {
                    ++element.j;
                    ++element.i;
                }
                pq.add(new Element(mat[element.i][index[element.j]], element.i, index[element.j]));
            }
        }
    }
}
