package low_level_design_two.design_pattterns.behavioral.observer.observers;

import low_level_design_two.design_pattterns.behavioral.observer.subjects.Subject;

public class Statistics implements Observer, Display {
    Subject subject;

    private float maxTemp = 0.0f;
    private float minTemp = 200.0f;
    private float tempSum = 0.0f;
    private int numOfReadings = 0;

    public Statistics(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        temp += temp;
        numOfReadings++;

        if (temp > maxTemp) {
            maxTemp = temp;
        }
        if (temp < minTemp) {
            minTemp = temp;
        }
        display();
    }

    @Override
    public void display() {
        System.out.println("Avg/ Min/ Max temperatures: " + (tempSum / numOfReadings) + "/ " + maxTemp + "/ " + minTemp);
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
