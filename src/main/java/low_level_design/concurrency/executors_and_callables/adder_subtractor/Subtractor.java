package low_level_design.concurrency.executors_and_callables.adder_subtractor;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Integer> {
    private Value v;

    public Subtractor(Value v) {
        this.v = v;
    }

    public Integer call() {
        for (int i = 0; i < 100; i++) {
            this.v.value--;
        }
        return this.v.value;
    }
}
