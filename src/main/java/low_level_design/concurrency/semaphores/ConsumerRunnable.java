package low_level_design.concurrency.semaphores;

import java.util.concurrent.Semaphore;

public class ConsumerRunnable implements Runnable{
    final Store store;
    final Semaphore producerSemaphore;
    final Semaphore consumerSemaphore;

    public ConsumerRunnable(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Only 5 players are allowed at any time, no need to check if the list is empty
            store.removeItem();
            producerSemaphore.release();
        }
    }
}
