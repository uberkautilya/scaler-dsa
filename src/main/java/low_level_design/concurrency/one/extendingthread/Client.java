package low_level_design.concurrency.one.extendingthread;

public class Client {
    public static void main(String[] args) {
        Thread directlyThread = new DirectlyThread();
        directlyThread.start();
    }
}
