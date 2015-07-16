package DesignPattern;

/**
 * Created by riyaz on 30/6/15.
 */
class Cake {
    private  double sugar;   //cup
    private  double butter;  //cup

    public static class Builder{
        private double sugar;   //cup
        private double butter;  //cup

        public Builder setSugar(double s) {
            this.sugar = s;
            return this;
        }

        public Builder setButter(double b){
            this.butter = b;
            return this;
        }

        public Cake build() {
            return new Cake(this);
        }
    }

    private Cake(Builder builder){
        this.sugar = builder.sugar;
        this.butter = builder.butter;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "sugar=" + sugar +
                ", butter=" + butter +
                '}';
    }
}
public class BuilderDesignPattern {

    public static void main(String[] args) {
        Cake cake = new Cake.Builder().setButter(10).build();
        System.out.println(cake.toString());
    }
}
