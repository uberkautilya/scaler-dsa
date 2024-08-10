package low_level_design.concurrency.semaphores;

import java.util.concurrent.Semaphore;

public class ProducerRunnable implements Runnable {
    final Store store;
    final Semaphore producerSemaphore;
    final Semaphore consumerSemaphore;

    public ProducerRunnable(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Already semaphores ensure only 5 players are allowed into the store at any moment
            store.addItem();
            consumerSemaphore.release();
        }
    }
}
