package main.java.com.personal.DP;

/**
 * Created by riyaz on 6/12/15.
 */

abstract class Animal {
    abstract void makeSound();
}

class  Dog extends Animal {

    @Override
    void makeSound() {
        System.out.println("Dog");
    }
}

class Cat  extends Animal {

    @Override
    void makeSound() {
        System.out.println("Cat");
    }
}
public class Polymorphism {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.makeSound();
    }
}
