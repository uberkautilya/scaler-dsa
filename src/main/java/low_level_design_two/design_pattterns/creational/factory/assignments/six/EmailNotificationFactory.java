package low_level_design_two.design_pattterns.creational.factory.assignments.six;

import low_level_design_two.design_pattterns.creational.factory.assignments.six.notification.EmailNotification;
import low_level_design_two.design_pattterns.creational.factory.assignments.six.notification.Notification;
import low_level_design_two.design_pattterns.creational.factory.assignments.six.sender.EmailNotificationSender;
import low_level_design_two.design_pattterns.creational.factory.assignments.six.sender.NotificationSender;
import low_level_design_two.design_pattterns.creational.factory.assignments.six.template.EmailNotificationTemplate;
import low_level_design_two.design_pattterns.creational.factory.assignments.six.template.NotificationTemplate;

public class EmailNotificationFactory extends NotificationFactory {
    public NotificationType notificationType(){
        return NotificationType.EMAIL;
    }
    public Notification createNotification(String recipient, String sender, NotificationTemplate template){
        return new EmailNotification(recipient, sender, template);
    }
    public NotificationSender createNotificationSender(Notification notification){
        return new EmailNotificationSender(notification);
    }
    public NotificationTemplate createNotificationTemplate(String message){
        return new EmailNotificationTemplate(message);
    }
}