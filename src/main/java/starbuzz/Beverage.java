package main.java.starbuzz;

/**
 * Created by prs on 4/6/17.
 */
public abstract class Beverage {
    String description  = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
