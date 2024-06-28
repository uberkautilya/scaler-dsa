package low_level_design_two.design_pattterns.behavioral.observer.subjects;

import low_level_design_two.design_pattterns.behavioral.observer.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class AIWeatherData implements Subject {
    List<Observer> observerList;
    float temperature, humidity, pressure;

    public AIWeatherData() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsUpdated();
    }

    private void measurementsUpdated() {
        //Actions before notifying the observers
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        this.observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(temperature, humidity, pressure);
        }
    }
}
