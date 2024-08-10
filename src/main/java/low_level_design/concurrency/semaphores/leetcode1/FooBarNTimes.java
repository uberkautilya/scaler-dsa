package low_level_design.concurrency.semaphores.leetcode1;

public class FooBarNTimes {
    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(3);
        Thread fooThread = new Thread(() -> {
            try {
                fooBar.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread barThread = new Thread(() -> {
            try {
                fooBar.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        fooThread.start();
        barThread.start();
    }
}
