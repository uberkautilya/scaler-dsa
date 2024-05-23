package low_level_design.concurrency.synchronization.producer_consumer;

import java.util.concurrent.ExecutorService;

public class ProducerRunnable implements Runnable {
    Store store;

    public ProducerRunnable(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (store) {
                if (store.list.size() < store.maxSize) {
                    store.addItem();
                }
            }
        }
    }
}
