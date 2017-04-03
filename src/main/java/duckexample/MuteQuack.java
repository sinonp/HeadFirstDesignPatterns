package main.java.duckexample;

/**
 * Created by prs on 4/3/17.
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
