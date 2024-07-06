package low_level_design_two.design_pattterns.behavioral.observer.assignments.task_management_application;

public interface ObserverRegistry {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(Long taskId, Long userId);
}
