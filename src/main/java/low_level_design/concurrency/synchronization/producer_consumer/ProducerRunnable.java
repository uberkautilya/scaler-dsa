package low_level_design.concurrency.synchronization.producer_consumer;

import java.util.concurrent.ExecutorService;

public class ProducerRunnable implements Runnable {
    final Store store;

    public ProducerRunnable(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (store) {
                if (store.isAdditionPossible()) {
                    store.addItem();
                }
            }
        }
    }
}
