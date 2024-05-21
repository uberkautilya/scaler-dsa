package low_level_design.concurrency.executors_and_callables;

public class RunnableImpl implements Runnable{
    int num;

    public RunnableImpl(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(num + " on " + Thread.currentThread().getName());
    }
}
