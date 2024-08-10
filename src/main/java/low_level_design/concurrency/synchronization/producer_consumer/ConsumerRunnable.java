package low_level_design.concurrency.synchronization.producer_consumer;

public class ConsumerRunnable implements Runnable{
    final Store store;

    public ConsumerRunnable(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            synchronized (store) {
                if (!store.isEmpty()) {
                    store.removeItem();
                }
            }
        }
    }
}
