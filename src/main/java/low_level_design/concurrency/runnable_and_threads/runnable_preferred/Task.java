package low_level_design.concurrency.runnable_and_threads.runnable_preferred;

public class Task implements Runnable{
    int val;

    public Task(int val) {
        this.val = val;
    }
    @Override
    public void run() {
        // Can have access to all the fields of this class, even though arguments are not allowed
        System.out.println(Thread.currentThread().getName() + " val: " + val);
    }
}
