package low_level_design.concurrency.synchronization.producer_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Store store = new Store(5);

        for (int i = 0; i < 25; i++) {
            executorService.execute(new ConsumerRunnable(store));
        }

        for (int i = 0; i < 10; i++) {
            executorService.execute(new ProducerRunnable(store));
        }
    }
}
