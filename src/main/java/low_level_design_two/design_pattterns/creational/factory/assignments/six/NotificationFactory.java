package low_level_design_two.design_pattterns.creational.factory.assignments.six;

import low_level_design_two.design_pattterns.creational.factory.assignments.six.notification.Notification;
import low_level_design_two.design_pattterns.creational.factory.assignments.six.sender.NotificationSender;
import low_level_design_two.design_pattterns.creational.factory.assignments.six.template.NotificationTemplate;

public abstract class NotificationFactory {
    public abstract NotificationType notificationType();
    public abstract Notification createNotification(String recipient, String sender, NotificationTemplate template);
    public abstract NotificationSender createNotificationSender(Notification notification);
    public abstract NotificationTemplate createNotificationTemplate(String message);

}