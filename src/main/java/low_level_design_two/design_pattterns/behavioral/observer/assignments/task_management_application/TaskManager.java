package low_level_design_two.design_pattterns.behavioral.observer.assignments.task_management_application;

public class TaskManager extends Publisher {

    public void assignTask(Long taskId, Long userId) {
        notifyObservers(taskId, userId);
    }
}