package low_level_design_two.design_pattterns.creational.factory.assignments.six.notification;

import low_level_design_two.design_pattterns.creational.factory.assignments.six.NotificationType;
import low_level_design_two.design_pattterns.creational.factory.assignments.six.template.NotificationTemplate;

public abstract class Notification {

    private String recipient;
    private NotificationTemplate template;

    public Notification(String recipient, NotificationTemplate template) {
        this.recipient = recipient;
        this.template = template;
    }

    public String getRecipient() {
        return recipient;
    }

    public NotificationTemplate getTemplate() {
        return template;
    }

    public abstract NotificationType notificationType();

    public abstract void sendNotification();
}