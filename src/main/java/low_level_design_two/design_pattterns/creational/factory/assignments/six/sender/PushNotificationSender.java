package low_level_design_two.design_pattterns.creational.factory.assignments.six.sender;

import low_level_design_two.design_pattterns.creational.factory.assignments.six.NotificationType;
import low_level_design_two.design_pattterns.creational.factory.assignments.six.notification.Notification;

public class PushNotificationSender extends NotificationSender {

    public PushNotificationSender(Notification notification) {
        super(notification);
    }

    @Override
    public void send() {
        System.out.println("Sending Push notification to " + getNotification().getRecipient());
    }

    @Override
    public NotificationType notificationType() {
        return NotificationType.PUSH;
    }
}