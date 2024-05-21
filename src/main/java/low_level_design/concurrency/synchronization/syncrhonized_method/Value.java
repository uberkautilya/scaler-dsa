package low_level_design.concurrency.synchronization.syncrhonized_method;

public class Value {
    int value;
    static int x = 0;

    Value(int val) {
        this.value = val;
    }

    synchronized void increment(int i) {
        value += i;
    }

    synchronized void decrement(int i) {
        value -= i;
    }

    static synchronized void incrementStatic(int i) {
        x += i;
    }

    static synchronized void decrementStatic(int i) {
        x -= i;
    }
}
