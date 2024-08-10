package low_level_design.concurrency.semaphores.leetcode2;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * You have an object printNumber. printNumber.accept(x) can be called with an integer parameter that prints it to the console.
 * <p>
 * You are given an instance of the class ZeroEvenOdd that has three functions: zero, even, and odd. The same instance of ZeroEvenOdd will be passed to three different threads:
 * <p>
 * Thread A: calls zero() that should only output 0's.
 * Thread B: calls even() that should only output even numbers.
 * Thread C: calls odd() that should only output odd numbers.
 * Modify the given class to output the series "010203040506..." where the length of the series must be 2n.
 * <p>
 * Implement the ZeroEvenOdd class:
 * <p>
 * ZeroEvenOdd(int n) Initializes the object with the number n that represents the numbers that should be printed.
 * void zero(printNumber) Calls printNumber to output one zero.
 * void even(printNumber) Calls printNumber to output one even number.
 * void odd(printNumber) Calls printNumber to output one odd number.
 */
public class ZeroOddEven {
    private final int n;
    private final Semaphore zeroS = new Semaphore(1);
    private final Semaphore oddS = new Semaphore(0);
    private final Semaphore evenS = new Semaphore(0);

    public ZeroOddEven(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroS.acquire();

            printNumber.accept(0);

            if (i % 2 != 0) oddS.release();
            else evenS.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i = i + 2) {
            evenS.acquire();
            printNumber.accept(i);
            zeroS.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 2) {
            oddS.acquire();
            printNumber.accept(i);
            zeroS.release();
        }
    }
}
