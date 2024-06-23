package low_level_design_two.design_pattterns.creational.factory.assignments.six.template;

import low_level_design_two.design_pattterns.creational.factory.assignments.six.NotificationType;

public abstract class NotificationTemplate {
    private String message;
    
    public NotificationTemplate(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
    public abstract String applyTemplate();
    public abstract NotificationType notificationType();

}