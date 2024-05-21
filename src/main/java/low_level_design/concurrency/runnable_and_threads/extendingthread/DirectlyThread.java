package low_level_design.concurrency.runnable_and_threads.extendingthread;

/**
 * Not Preferred:
 * 1. Can't extend any other class
 * 2. Not Composition, which is more flexible than inheritance, which is the case here
 * 3. With Lambda, no need to create a separate class using Runnable approach, unlike here which always needs a class definition
 * This is indirectly overriding the run() implementation in Thread class
 */
public class DirectlyThread extends Thread{
    @Override
    public void run() {
        System.out.println("From DirectlyThread");
    }
}
