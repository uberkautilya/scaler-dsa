package low_level_design_two.design_pattterns.creational.factory.assignments.six.notification;

import low_level_design_two.design_pattterns.creational.factory.assignments.six.NotificationType;
import low_level_design_two.design_pattterns.creational.factory.assignments.six.template.NotificationTemplate;

public class EmailNotification extends Notification{
    private String sender;

    public EmailNotification(String recipient, String sender, NotificationTemplate template) {
        super(recipient, template);
        this.sender = sender;
    }


    public String getSender() {
        return sender;
    }

    @Override
    public void sendNotification() {
        // Logic to send an email
        System.out.println("Email sent to " + getRecipient() + " from " + sender);
        System.out.println("Message: " + getTemplate().getMessage());
    }

    public NotificationType notificationType() {
        return NotificationType.EMAIL;
    }
}