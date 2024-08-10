package low_level_design.concurrency.synchronization.reentrantlock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class AddCallable implements Callable<Integer> {
    private final Value v;
    private final Lock lock;

    public AddCallable(Value v, Lock reentrantLock) {
        this.lock = reentrantLock;
        this.v = v;
    }

    @Override
    public Integer call() {
        for (int i = 1; i <= 50_000; i++) {
            this.lock.lock();
            //region Critical Section

            // This is not atomic, but three instructions
            this.v.value += 1;

            //endregion
            this.lock.unlock();
        }
        return this.v.value;
    }
}
