package main.java.com.personal.Random;

/**
 * Created by riyaz on 28/7/15.
 */
public class BuilderDesignPatternsDemo {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
    public  static class Builder {
        private final int servingSize;
        private final int servings;
        private int calories = -1;
        private int fat = -1;
        private int sodium = -1;
        private int carbohydrate = -1;
        Builder(int servingSize, int serving) {
            this.servingSize = servingSize;
            this.servings = serving;
        }

        public Builder calories(int a) {
            this.calories = a;
            return this;
        }

        public Builder fat(int f) {
            this.fat = f;
            return this;
        }

        public BuilderDesignPatternsDemo build() {
            return new BuilderDesignPatternsDemo(this);
        }
    }
    private BuilderDesignPatternsDemo(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;

    }

    @Override
    public String toString() {
        return "BuilderDesignPatternsDemo{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }

    public static void main(String [] args) {
        BuilderDesignPatternsDemo obj = new BuilderDesignPatternsDemo.Builder(10, 20).calories(15).build();
        System.out.println(obj.toString());
    }

}