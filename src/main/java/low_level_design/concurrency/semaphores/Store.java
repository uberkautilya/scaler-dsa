package low_level_design.concurrency.semaphores;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Store {
    int maxSize;
    //As we allow multiple threads simultaneously to operate on the collection
    Queue<Object> queue = new ConcurrentLinkedQueue<>();

    public Store(int maxSize) {
        this.maxSize = maxSize;
    }

    public void addItem() {
        System.out.println("Producer: Items size: " + queue.size());
        this.queue.add(new Object());
    }

    public void removeItem() {
        System.out.println("Consumer: Removing item at index: " + (queue.size() - 1));
        this.queue.remove(this.queue.size() - 1);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isAdditionPossible() {
        return queue.size() < maxSize;
    }
}
