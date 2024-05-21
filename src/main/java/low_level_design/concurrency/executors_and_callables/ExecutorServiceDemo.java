package low_level_design.concurrency.executors_and_callables;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        fixedThreadPoolExample();

        cachedPoolExample();
    }

    private static void cachedPoolExample() {
        // On demand thread creation - If no thread is free, a new thread is spawned
        // Only use newCachedThreadPool when the tasks are limited - when no chance of huge number of threads exists
        ExecutorService eS = Executors.newCachedThreadPool();
        for (int i = 0; i < 15000; i++) {
            Runnable runnable = new RunnableImpl(i);
            eS.execute(runnable);
        }
    }

    private static void fixedThreadPoolExample() {
        // 10 Threads created
        ExecutorService executorService = Executors.newFixedThreadPool(16);

        for (int i = 0; i < 150000; i++) {
            RunnableImpl runnable = new RunnableImpl(i);
            executorService.execute(runnable);
        }
        // Will auto shutdown anyway, even when not called
        executorService.shutdown();
    }
}
