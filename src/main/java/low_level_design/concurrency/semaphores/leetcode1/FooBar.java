package low_level_design.concurrency.semaphores.leetcode1;

import java.util.concurrent.Semaphore;

public class FooBar {
    private final int n;
    private final Semaphore fooSemaphore;
    private final Semaphore barSemaphore;

    public FooBar(int n) {
        this.n = n;
        this.fooSemaphore = new Semaphore(1);
        this.barSemaphore = new Semaphore(0);
    }

    public void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire();
            System.out.print("foo");
            barSemaphore.release();
        }
    }
    public void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            System.out.print("bar ");
            fooSemaphore.release();
        }
    }
}
