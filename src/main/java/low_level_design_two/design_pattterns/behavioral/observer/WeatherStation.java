package low_level_design_two.design_pattterns.behavioral.observer;

import low_level_design_two.design_pattterns.behavioral.observer.observers.CurrentConditions;
import low_level_design_two.design_pattterns.behavioral.observer.observers.Forecast;
import low_level_design_two.design_pattterns.behavioral.observer.observers.Statistics;
import low_level_design_two.design_pattterns.behavioral.observer.subjects.WeatherData;

/**
 * This class is like a supplier to the Subject
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        //Any push to the above subject should notify all its observers below

        //I feel that - a super abstract class should allow a level of dependency inversion here as well
        CurrentConditions currentConditionsObserver = new CurrentConditions(weatherData);
        Forecast forecastObserver = new Forecast(weatherData);
        Statistics statisticsObserver = new Statistics(weatherData);

        System.out.println();
        weatherData.setMeasurements(80, 65, 30.4f);
        System.out.println();
        weatherData.setMeasurements(82, 70, 29.2f);
        System.out.println();
        weatherData.setMeasurements(80, 65, 30.4f);
        System.out.println();

        currentConditionsObserver.deregister();
        weatherData.setMeasurements(62, 90, 28.1f);
        System.out.println();
        currentConditionsObserver.register();
        weatherData.setMeasurements(99, 90, 28.1f);
    }
}
