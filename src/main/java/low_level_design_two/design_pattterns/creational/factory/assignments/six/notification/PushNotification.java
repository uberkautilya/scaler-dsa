package low_level_design_two.design_pattterns.creational.factory.assignments.six.notification;

import low_level_design_two.design_pattterns.creational.factory.assignments.six.NotificationType;
import low_level_design_two.design_pattterns.creational.factory.assignments.six.template.NotificationTemplate;

public class PushNotification extends Notification {

    public PushNotification(String recipient, NotificationTemplate template) {
        super(recipient, template);
    }

    public void sendNotification() {
        // Logic to send a push notification
        System.out.println("Push notification sent to device " + getRecipient());
        System.out.println("Message: " + getTemplate().getMessage());
    }

    public NotificationType notificationType() {
        return NotificationType.PUSH;
    }
}