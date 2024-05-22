package low_level_design.concurrency.synchronization.synchronization_keyword;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class AddCallable implements Callable<Integer> {
    private Value v;

    public AddCallable(Value v) {
        this.v = v;
    }

    public Integer call() {
        for (int i = 1; i <= 50_000; i++) {
            //region Critical Section
            synchronized (v) {
                // This is not atomic, but three instructions
                this.v.value += 1;
            }
            //endregion
        }
        return this.v.value;
    }
}
