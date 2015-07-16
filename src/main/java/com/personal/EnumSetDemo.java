package main.java.com.personal;

import java.util.EnumSet;

/**
 * Created by riyaz on 12/7/15.
 */
public class EnumSetDemo {
    private enum Color {
        RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 255);
        private int r;
        private int g;
        private int b;

        Color(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public int getR() {
            return r;
        }

        public int getG() {
            return g;
        }

        public int getB() {
            return b;
        }
    }
    private static void drawLine(EnumSet<Color> set) {
        System.out.println("Set is \t" + set);
        for(Color c : set){
            System.out.print(c  + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        EnumSet<Color> yellow = EnumSet.of(Color.RED, Color.GREEN, Color.GREEN);
        drawLine(yellow);
        EnumSet<Color> white = EnumSet.of(Color.RED,Color.BLUE,Color.BLUE);
        drawLine(white);
        EnumSet<Color> pink = EnumSet.of(Color.RED,Color.BLUE);
        drawLine(pink);
    }
}
