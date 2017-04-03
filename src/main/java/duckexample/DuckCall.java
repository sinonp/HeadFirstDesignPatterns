package main.java.duckexample;

/**
 * Created by sinonp on 4/3/17.
 */
public class DuckCall {
    QuackBehavior quackBehavior;

    public DuckCall() {
        quackBehavior = new Quack();
    }

    public void performQuack() {
        quackBehavior.quack();
    }
}
