package low_level_design.concurrency.executors_and_callables;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        fixedThreadPoolExample();

        cachedPoolExample();
    }

    /**
     * On demand thread creation - If no thread is free, a new thread is spawned
     * Only use newCachedThreadPool when the tasks are limited - when no chance of huge number of threads exists
     */
    private static void cachedPoolExample() {
        try (ExecutorService eS = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 15000; i++) {
                Runnable runnable = new RunnableImpl(i);
                eS.execute(runnable);
            }
        }
    }

    /**
     * 10 Threads created
     */
    private static void fixedThreadPoolExample() {
        try (ExecutorService executorService = Executors.newFixedThreadPool(10)) {

            for (int i = 0; i < 150000; i++) {
                RunnableImpl runnable = new RunnableImpl(i);
                executorService.execute(runnable);
            }
            // Will auto shutdown anyway, even when not called
            executorService.shutdown();
        }
    }
}
