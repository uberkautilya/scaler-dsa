package low_level_design_two.design_pattterns.behavioral.observer.class_discussion.subjects;

import low_level_design_two.design_pattterns.behavioral.observer.class_discussion.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    List<Observer> observerList;
    private float temp, humidity, pressure;

    public WeatherData() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
        System.out.println("Observer added: " + o);
    }

    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
        System.out.println("Observer removed: " + o);
    }

    @Override
    public void notifyObservers() {
        System.out.println("Notifying observers");
        for (Observer observer : observerList) {
            observer.update(temp, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        //Actions before notifying the observers
        notifyObservers();
    }

    /**
     * This method can be called by the feeder - in this case the Weather Station
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temp = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemp() {
        return temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
