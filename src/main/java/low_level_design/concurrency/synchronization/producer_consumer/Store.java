package low_level_design.concurrency.synchronization.producer_consumer;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int maxSize;
    List<Object> list = new ArrayList<>();

    public Store(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean isAdditionPossible() {
        return list.size() < maxSize;
    }

    public void addItem() {
        System.out.println("Producer: Items size: " + list.size());
        this.list.add(new Object());
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void removeItem() {
        System.out.println("Consumer: Removing item at index: " + (list.size() - 1));
        this.list.remove(this.list.size() - 1);
    }
}
