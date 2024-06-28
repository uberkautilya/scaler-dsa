package low_level_design_two.design_pattterns.behavioral.observer.subjects;

import low_level_design_two.design_pattterns.behavioral.observer.observers.Observer;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
