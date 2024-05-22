package low_level_design.concurrency.synchronization.synchronized_method;

import java.util.concurrent.Callable;

public class AddCallable implements Callable<Void> {
    private Value v;

    public AddCallable(Value v) {
        this.v = v;
    }

    public Void call() {
        for (int i = 1; i <= 50_000; i++) {
            // Call synchronized methods of v
            Value.incrementStatic(i);
            v.increment(i);
        }
        return null;
    }
}
