package low_level_design_two.design_pattterns.creational.factory.assignments.six;

import low_level_design_two.design_pattterns.creational.factory.assignments.six.notification.Notification;
import low_level_design_two.design_pattterns.creational.factory.assignments.six.notification.PushNotification;
import low_level_design_two.design_pattterns.creational.factory.assignments.six.sender.NotificationSender;
import low_level_design_two.design_pattterns.creational.factory.assignments.six.sender.PushNotificationSender;
import low_level_design_two.design_pattterns.creational.factory.assignments.six.template.NotificationTemplate;
import low_level_design_two.design_pattterns.creational.factory.assignments.six.template.PushNotificationTemplate;

public class PushNotificationFactory extends NotificationFactory {
    public NotificationType notificationType(){
        return NotificationType.PUSH;
    }
    public Notification createNotification(String recipient, String sender, NotificationTemplate template){
        return new PushNotification(recipient, template);
    }
    public NotificationSender createNotificationSender(Notification notification){
        return new PushNotificationSender(notification);
    }
    public NotificationTemplate createNotificationTemplate(String message){
        return new PushNotificationTemplate(message);
    }
}