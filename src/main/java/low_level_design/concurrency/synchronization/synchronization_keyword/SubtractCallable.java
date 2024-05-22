package low_level_design.concurrency.synchronization.synchronization_keyword;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class SubtractCallable implements Callable<Integer> {
    private Value v;

    public SubtractCallable(Value v) {
        this.v = v;
    }

    public Integer call() {
        for (int i = 1; i <= 50_000; i++) {
            //The below is the same as the approach with ReentrantLock() in the sibling package
            synchronized (v) {
                // This is not atomic, but three instructions
                this.v.value -= 1;
            }
        }
        return this.v.value;
    }
}
