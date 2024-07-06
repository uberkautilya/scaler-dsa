package low_level_design_two.design_pattterns.behavioral.observer.assignments.weather_monitoring_system;

public interface ObserverRegistry {
    
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(double value);
}