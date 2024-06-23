package low_level_design_two.design_pattterns.creational.factory.assignments.six.sender;

import low_level_design_two.design_pattterns.creational.factory.assignments.six.NotificationType;
import low_level_design_two.design_pattterns.creational.factory.assignments.six.notification.Notification;

public abstract class NotificationSender {
    private final Notification notification;

    public NotificationSender(Notification notification) {
        this.notification = notification;
    }

    public Notification getNotification() {
        return notification;
    }

    public abstract void send();

    public abstract NotificationType notificationType();

}