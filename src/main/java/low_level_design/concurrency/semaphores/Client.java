package low_level_design.concurrency.semaphores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {
        /**
         * The internal count below - 5 and 0, will be decreased and increased on calling semaphore.acquire() and semaphore.release() respectively.
         * The 5 here in producerSemaphore acts like the shelf max size - 5 in the previous class inside the store.
         * We can also contain the count in Store additionally - otherwise, the list size can increase well beyond 5.
         * To preserve earlier behavior, use Concurrent friendly data structures like {@code ConcurrentLinkedQueue<Object>()}, or bring back the list.size() checks.
         */
        public static void main(String[] args) {
            try (ExecutorService executorService = Executors.newCachedThreadPool()) {
                Store store = new Store();

                Semaphore producerSemaphore = new Semaphore(5);
                Semaphore consumerSemaphore = new Semaphore(0);

                executorService.execute(new ConsumerRunnable(store, producerSemaphore, consumerSemaphore));
                executorService.execute(new ProducerRunnable(store, producerSemaphore, consumerSemaphore));
            }
        }
}
