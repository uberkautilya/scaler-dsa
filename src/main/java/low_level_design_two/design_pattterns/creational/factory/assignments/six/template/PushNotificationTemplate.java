package low_level_design_two.design_pattterns.creational.factory.assignments.six.template;

import low_level_design_two.design_pattterns.creational.factory.assignments.six.NotificationType;

public class PushNotificationTemplate extends NotificationTemplate{
    public PushNotificationTemplate(String message) {
        super(message);
    }

    @Override
    public String applyTemplate() {
        System.out.println("Applying Push notification template");
        return getMessage();
    }

    @Override
    public NotificationType notificationType() {
        return NotificationType.PUSH;
    }
}