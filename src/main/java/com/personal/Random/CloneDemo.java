package Random;


/**
 * Created by riyaz on 11/7/15.
 */
class Diameter implements Cloneable {

    private int height;
    private int length;

    public Diameter(int height, int length) {
        this.height = height;
        this.length = length;
    }

    @Override
    protected Diameter clone() throws CloneNotSupportedException {
        return (Diameter) super.clone();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Diameter{" +
                "height=" + height +
                ", length=" + length +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diameter)) return false;

        Diameter diameter = (Diameter) o;

        if (height != diameter.height) return false;
        return length == diameter.length;

    }

    @Override
    public int hashCode() {
        int result = height;
        result = 31 * result + length;
        return result;
    }
}

public class CloneDemo {
//    private static  final Logger logger = Logger.getLogger(CloneDemo.class);

    public static void main(String[] args) {

        Diameter a = new Diameter(10,20);
        System.out.println(a.toString());
        Diameter clone = null;
        try {
            System.out.println("Creating copy of this object using Clone Method");
            clone  = a.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning is not supported for this object");
        }
        a.setHeight(100);
        System.out.println("Copy != clone \t" + (a != clone));
        System.out.println("Copy.getClass() == clone.getClass() \t" + (a.getClass() == clone.getClass()));
        System.out.println("Copy.equals(clone)" + a.equals(clone));
        System.out.println("================");
        System.out.println(a.toString());
        System.out.println(clone.toString());
    }
}
