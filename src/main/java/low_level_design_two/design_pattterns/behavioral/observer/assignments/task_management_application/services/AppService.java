package low_level_design_two.design_pattterns.behavioral.observer.assignments.task_management_application.services;

import low_level_design_two.design_pattterns.behavioral.observer.assignments.task_management_application.Observer;
import low_level_design_two.design_pattterns.behavioral.observer.assignments.task_management_application.utils.NotificationUtils;

public class AppService implements Observer {
    public void sendNotification(Long taskId, Long id) {
        String subject = "New task assigned";
        String message = "Task %s assigned to user %s";
        NotificationUtils.sendPush(subject, String.format(message, taskId, id));
    }
}