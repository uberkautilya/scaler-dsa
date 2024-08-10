package low_level_design.concurrency.semaphores.leetcode2;

import java.util.function.IntConsumer;

public class Client {
    static ZeroOddEven zeroOddEven = new ZeroOddEven(3);
    static IntConsumer printNumber = System.out::print;

    static Thread zeroThread = new Thread(() -> {
        try {
            zeroOddEven.zero(printNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });
    static Thread oddThread = new Thread(() -> {
        try {
            zeroOddEven.odd(printNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });
    static Thread evenThread = new Thread(() -> {
        try {
            zeroOddEven.even(printNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    public static void main(String[] args) {
        evenThread.start();
        oddThread.start();
        zeroThread.start();
    }
}
