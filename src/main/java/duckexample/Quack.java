package main.java.duckexample;

/**
 * Created by prs on 4/3/17.
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
