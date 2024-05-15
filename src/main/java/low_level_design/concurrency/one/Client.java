package low_level_design.concurrency.one;

public class Client {
    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo();

        System.out.println("Main Thread: " + Thread.currentThread().getName());
        Thread thread = new Thread(runnableDemo);
        // Internally calls the run() in the runnableDemo, managing the thread life cycle
        thread.start();
    }
}
