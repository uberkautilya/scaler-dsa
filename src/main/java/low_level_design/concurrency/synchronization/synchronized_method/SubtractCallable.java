package low_level_design.concurrency.synchronization.synchronized_method;

import java.util.concurrent.Callable;

public class SubtractCallable implements Callable<Void> {
    private Value v;

    public SubtractCallable(Value v) {
        this.v = v;
    }

    public Void call() {
        for (int i = 1; i <= 50_000; i++) {
            //Call the synchronized methods on v
            Value.decrementStatic(i);
            v.decrement(i);
        }
        return null;
    }
}
