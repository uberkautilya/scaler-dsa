package low_level_design.concurrency.one.runnable_preferred;

/**
 * Print numbers 1 to 100 in distinct threads
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("Main Thread: " + Thread.currentThread().getName());

        for (int i = 1; i <= 100; i++) {
            Task taskRunnable = new Task(i);
            Thread thread = new Thread(taskRunnable);
            thread.start();
        }
    }
}
