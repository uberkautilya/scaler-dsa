package low_level_design_two.design_pattterns.behavioral.observer.observers;

import low_level_design_two.design_pattterns.behavioral.observer.subjects.Subject;

/**
 * Observers need to implement this interface
 */
public interface Observer {
    void update(float temp, float humidity, float pressure);

    public void register();
    public void deregister();
    public void changeSubject(Subject subject);
}
