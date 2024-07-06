package low_level_design_two.design_pattterns.behavioral.observer.assignments.weather_monitoring_system.services;

import low_level_design_two.design_pattterns.behavioral.observer.assignments.weather_monitoring_system.Observer;
import low_level_design_two.design_pattterns.behavioral.observer.assignments.weather_monitoring_system.utils.NotificationUtils;

public class HumidityService implements Observer {
    public void trigger(double value) {
        NotificationUtils.sendNotification("New value is " + value);
    }
}