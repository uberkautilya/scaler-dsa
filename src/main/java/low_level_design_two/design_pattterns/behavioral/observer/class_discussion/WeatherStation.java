package low_level_design_two.design_pattterns.behavioral.observer.class_discussion;

import low_level_design_two.design_pattterns.behavioral.observer.class_discussion.observers.CurrentConditions;
import low_level_design_two.design_pattterns.behavioral.observer.class_discussion.observers.Forecast;
import low_level_design_two.design_pattterns.behavioral.observer.class_discussion.observers.Observer;
import low_level_design_two.design_pattterns.behavioral.observer.class_discussion.observers.Statistics;
import low_level_design_two.design_pattterns.behavioral.observer.class_discussion.subjects.AIWeatherData;
import low_level_design_two.design_pattterns.behavioral.observer.class_discussion.subjects.Subject;
import low_level_design_two.design_pattterns.behavioral.observer.class_discussion.subjects.WeatherData;

/**
 * This class is like a supplier to the Subject
 */
public class WeatherStation {
    public static void main(String[] args) {
        //Any push to the below subject should be notify all its observers below
        Subject subject = new WeatherData();

        //I feel that - a super abstract class should allow a level of dependency inversion here as well
        Observer currentConditionsObserver = new CurrentConditions(subject);
        Observer forecastObserver = new Forecast(subject);
        Observer statisticsObserver = new Statistics(subject);

        System.out.println();
        subject.setMeasurements(80, 65, 30.4f);
        System.out.println();
        subject.setMeasurements(82, 70, 29.2f);
        System.out.println();
        subject.setMeasurements(80, 65, 30.4f);
        System.out.println();

        currentConditionsObserver.deregister();
        subject.setMeasurements(62, 90, 28.1f);
        System.out.println();

        System.out.println("Changing subject to AIWeatherData");
        Subject aiSubject = new AIWeatherData();
        currentConditionsObserver.changeSubject(aiSubject);
        currentConditionsObserver.register();
        aiSubject.setMeasurements(100, 100, 89.1f);
    }
}
