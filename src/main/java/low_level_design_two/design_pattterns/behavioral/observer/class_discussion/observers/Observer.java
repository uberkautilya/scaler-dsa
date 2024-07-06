package low_level_design_two.design_pattterns.behavioral.observer.class_discussion.observers;

import low_level_design_two.design_pattterns.behavioral.observer.class_discussion.subjects.Subject;

/**
 * Observers need to implement this interface
 */
public interface Observer {
    void update(float temp, float humidity, float pressure);

    public void register();
    public void deregister();
    public void changeSubject(Subject subject);
}
