package low_level_design_two.design_pattterns.behavioral.observer.assignments.task_management_application;

public interface Observer {
    void sendNotification(Long taskId, Long id);
}