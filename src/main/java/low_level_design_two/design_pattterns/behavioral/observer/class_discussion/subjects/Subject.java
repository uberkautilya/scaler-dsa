package low_level_design_two.design_pattterns.behavioral.observer.class_discussion.subjects;

import low_level_design_two.design_pattterns.behavioral.observer.class_discussion.observers.Observer;

public interface Subject {
    //Method used to feed the updates - which are then notified to the observers
    public void setMeasurements(float temperature, float humidity, float pressure);

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
