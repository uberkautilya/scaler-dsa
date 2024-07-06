package low_level_design_two.design_pattterns.behavioral.observer.assignments.weather_monitoring_system;

import java.util.ArrayList;
import java.util.List;

public class WeatherMonitoringApplication implements Publisher {
    List<Observer> observerList = new ArrayList<>();

    private double temperature;
    private double humidity;
    private double pressure;
    private double temperatureThreshold;
    private double humidityThreshold;
    private double pressureThreshold;

    // DO NOT MODIFY THIS CONSTRUCTOR
    public WeatherMonitoringApplication(double initialTemperature, double initialHumidity, double initialPressure,
                                        double temperatureThreshold, double humidityThreshold, double pressureThreshold) {
        this.temperature = initialTemperature;
        this.humidity = initialHumidity;
        this.pressure = initialPressure;
        this.temperatureThreshold = temperatureThreshold;
        this.humidityThreshold = humidityThreshold;
        this.pressureThreshold = pressureThreshold;
    }
    // DO NOT MODIFY THIS CONSTRUCTOR

    public void updateWeatherConditions(double newTemperature, double newHumidity, double newPressure) {
        temperature = newTemperature;
        humidity = newHumidity;
        pressure = newPressure;

        if (temperature > temperatureThreshold) {
            notifyObservers(temperature);
        }

        if (humidity > humidityThreshold) {
            notifyObservers(humidity);
        }

        if (pressure > pressureThreshold) {
            notifyObservers(pressure);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(double value) {
        for (Observer observer : observerList) {
            observer.trigger(value);
        }
    }
}