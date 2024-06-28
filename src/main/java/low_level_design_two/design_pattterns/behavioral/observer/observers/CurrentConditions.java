package low_level_design_two.design_pattterns.behavioral.observer.observers;

import low_level_design_two.design_pattterns.behavioral.observer.subjects.Subject;

public class CurrentConditions implements Observer, Display {
    Subject subject;
    private float temperature;
    private float humidity;

    public CurrentConditions(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: temp: " + temperature + "°F and " + humidity + "% humidity");
    }

    //I feel this should ideally be extracted into a super abstract class, along with the subject field
    public void register() {
        this.subject.registerObserver(this);
    }

    public void deregister() {
        this.subject.removeObserver(this);
    }

    public void changeSubject(Subject subject) {
        this.subject = subject;
    }
}
