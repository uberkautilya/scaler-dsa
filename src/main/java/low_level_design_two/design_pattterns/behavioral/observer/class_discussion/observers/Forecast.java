package low_level_design_two.design_pattterns.behavioral.observer.class_discussion.observers;

import low_level_design_two.design_pattterns.behavioral.observer.class_discussion.subjects.Subject;

public class Forecast implements Observer, Display {
    Subject subject;
    private float currentPressure = 29.92f;
    private float previousPressure;

    public Forecast(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.previousPressure = currentPressure;
        this.currentPressure = pressure;

        display();
    }

    @Override
    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure > previousPressure) {
            System.out.println("Improving weather");
        } else if (currentPressure == previousPressure) {
            System.out.println("Same conditions");
        } else {
            System.out.println("Brace for cooler, rainy weather");
        }
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
