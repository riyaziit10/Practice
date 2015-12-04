package main.java.com.personal.Company;

/**
 * Created by riyaz on 18/11/15.
 */

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class LineSegmentIntersect {

    private static boolean onSegment(Point p1, Point q1, Point r) {
        if(r.x <= Math.max(p1.x, q1.x) && r.x >= Math.min(p1.x, q1.x) && r.y <= Math.max(p1.y, q1.y) && r.y >= Math.min(p1.y, q1.y) )
            return true;

        return  false;
    }

    private static int isIntersect(Point p1, Point q1, Point r) {
        int value = (q1.y - p1.y) * (r.x - q1.x) - (q1.x - p1.x) * (r.y - q1.y);

        if(value == 0) return  0;

        return (value > 0) ? 1 : 2;
    }

    private static boolean doInterSect(Point p1, Point q1, Point p2, Point q2) {

        int o1 = isIntersect(p1, q1, p2);
        int o2 = isIntersect(p1, q1, q2);
        int o3 = isIntersect(p2, q2, p1);
        int o4 = isIntersect(p2, q2, q1);

        if(o1 != o2 && o3 != o4)
            return true;

        if(o1 == 0 && onSegment(p1, q1, p2)) return true;

        if(o2 == 0 && onSegment(p1, q1, q2)) return true;

        if(o3 == 0 && onSegment(p2, q2, p1)) return  true;

        if(o4 == 0 && onSegment(p2, q2, q1)) return true;

        return false;

    }
    public static void main(String[] args) {
//        Point p1 = new Point(1,1);
//        Point q1 = new Point(10,1);
//        Point p2 = new Point(1,2);
//        Point q2 = new Point(10,2);
//
//        if(doInterSect(p1, q1, p2, q2))
//            System.out.println("Line segment intersect");
//        else
//            System.out.println("Line Segement don't intersect");


        Point p1 = new Point(10,0);
        Point q1 = new Point(0,10);
        Point p2 = new Point(0,0);
        Point q2 = new Point(10,10);

        if(doInterSect(p1, q1, p2, q2))
            System.out.println("Line segment intersect");
        else
            System.out.println("Line Segement don't intersect");
    }
}
