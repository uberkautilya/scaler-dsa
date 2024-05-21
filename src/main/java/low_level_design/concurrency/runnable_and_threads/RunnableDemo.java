package low_level_design.concurrency.runnable_and_threads;

public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        // The task to be performed
        System.out.println("run() method \nChild Thread: " + Thread.currentThread().getName());
    }
}
