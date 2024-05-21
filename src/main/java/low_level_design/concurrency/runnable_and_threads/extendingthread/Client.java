package low_level_design.concurrency.runnable_and_threads.extendingthread;

public class Client {
    public static void main(String[] args) {
        Thread directlyThread = new DirectlyThread();
        directlyThread.start();
    }
}
