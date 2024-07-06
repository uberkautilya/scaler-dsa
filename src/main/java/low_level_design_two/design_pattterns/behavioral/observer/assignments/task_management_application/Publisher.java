package low_level_design_two.design_pattterns.behavioral.observer.assignments.task_management_application;

import java.util.ArrayList;
import java.util.List;

public abstract class Publisher implements ObserverRegistry {
    List<Observer> observerList = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(Long taskId, Long userId) {
        for (Observer observer : observerList) {
            observer.sendNotification(taskId, userId);
        }
    }
}