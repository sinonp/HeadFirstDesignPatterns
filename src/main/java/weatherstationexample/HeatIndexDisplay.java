package main.java.weatherstationexample;

import java.util.Observable;
import java.util.Observer;

public class HeatIndexDisplay implements DisplayElement, Observer {

    private Observable observable;
    private float temperature;
    private float humidity;
    private float hIndex;

    public HeatIndexDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
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

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.hIndex = calculateHeatIndex();
            display();
        }
    }
}
