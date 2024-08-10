package low_level_design.concurrency.semaphores;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Store {
    final int maxSize;
    //As we allow multiple threads simultaneously to operate on the collection
    Queue<Object> queue = new ConcurrentLinkedQueue<>();

    public Store(int maxSize) {
        this.maxSize = maxSize;
    }

    public void addItem() {
        this.queue.add(new Object());
        System.out.println("Producer: Items size: " + queue.size());
    }

    public void removeItem() {
        this.queue.remove();
        System.out.println("Consumer: Items size: " + queue.size());
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isAdditionPossible() {
        return queue.size() < maxSize;
    }
}
