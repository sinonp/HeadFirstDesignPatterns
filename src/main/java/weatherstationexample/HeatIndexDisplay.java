package main.java.weatherstationexample;

/**
 * Created by prs on 4/5/17.
 */
public class HeatIndexDisplay implements DisplayElement, Observer {

    private float temperature;
    private float humidity;
    private float hIndex;

    private Subject weatherData;

    public HeatIndexDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        hIndex = calculateHeatIndex();
        display();
    }

    @Override
    public void display() {
        System.out.println("Heat index is " + hIndex);
    }

    private float calculateHeatIndex() {
        float hIndex;

        hIndex = -42.379f + 2.04901523f * temperature + 10.14333127f * humidity;
        hIndex = hIndex - 0.22475541f * temperature * humidity - 6.83783f * (float)Math.pow(10, -3) * temperature * temperature;
        hIndex = hIndex - 5.481717f * (float)Math.pow(10, -2) * humidity * humidity;
        hIndex = hIndex + 1.22874f * (float)Math.pow(10, -3) * temperature * temperature * humidity;
        hIndex = hIndex + 8.5282f * (float)Math.pow(10, -4) * temperature * humidity * humidity;
        hIndex = hIndex - 1.99f * (float)Math.pow(10, -6) * temperature * temperature * humidity * humidity;

        return hIndex;
    }
}
