package Random;

/**
 * Created by riyaz on 4/7/15.
 */
public class Test {

    static void fun(int[] arr) {
        if (arr[0] == 10)
            return;
        ++arr[0];
        fun(arr);
        System.out.println(arr[0]);
    }
    static class Points {
        int i;
        int j;

        public Points(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) {
        Points [] p = new Points[4];
        p[0] = new Points(3,4);
        p[0] = new Points(4,5);
        System.out.println(p.length);
        for(Points m: p) {
            if(m != null)
                 System.out.println("(" + m.i + " , " +  m.j + ")");
        }

    }
}
