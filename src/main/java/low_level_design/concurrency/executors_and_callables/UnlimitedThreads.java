package low_level_design.concurrency.executors_and_callables;

public class UnlimitedThreads {
    public static void main(String[] args) {

        for (int i = 0; i < 15000; i++) {
            Runnable runnable = new RunnableImpl(i);
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
