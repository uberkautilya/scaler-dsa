package low_level_design.concurrency.synchronization.synchronized_method;

/**
 * synchronized methods execute only when a lock is achieved on the Value object on whom the method is called
 */
public class Value {
    int value;
    static int staticVal = 0;

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
        staticVal += i;
    }

    static synchronized void decrementStatic(int i) {
        staticVal -= i;
    }
}
