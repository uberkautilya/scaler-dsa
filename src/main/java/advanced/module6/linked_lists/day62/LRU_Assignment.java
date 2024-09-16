package advanced.module6.linked_lists.day62;

import java.util.HashMap;
import java.util.Map;

/**
 * The data structure has a fixed capacity. It should hold th most recent N nodes.
 * When an existing data appears, it should be updated as the most recent one.
 * <p>
 * Least Recently Used (LRU) cache should support the following operations: get and set.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
 * The LRU Cache will be initialized with an integer corresponding to its capacity maximum number of unique keys it can hold at a time.
 * <p>
 * There is 1 lines in the input
 * Line 1 ( Corresponds to arg 1 ) : The line starts with a pair of numbers - numOperations, capacity.
 * Then numOperation operations follow.
 * Each operation is either :
 * * G  : This corresponds to a function call get()
 * * S   : This corresponds to a function call set(num1, num2)
 * Note that the function calls are made in order.
 */
public class LRU_Assignment {
    Integer capacity;
    static Map<Integer, Node> map = new HashMap<>();
    Node head = null, tail = null;

    public LRU_Assignment(Integer capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRU_Assignment cache = new LRU_Assignment(1);
        cache.printContent("Start");
        cache.set(2, 1);
        cache.printContent("\nAfter insertion of 2-1");

        cache.set(2, 2);
        cache.printContent("\nAfter insertion of 2-2");

        cache.set(1, 1);
        cache.printContent("\nAfter insertion of 1-1");


        cache.set(4, 1);
        cache.printContent("\nAfter insertion of 4-1");
//        System.out.println("Value at key = 2: " + cache.get(2));

        System.out.println("Map entries: ");
        map.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v.data));
    }

    public void set(Integer key, Integer value) {
        boolean keyExists = map.containsKey(key);
        Node node;
        if (keyExists) {
            node = map.get(key);
            node.data = value;
            removeNode(node);
        } else {
            node = new Node(key, value);
            map.put(key, node);
            //If the size exceeds the capacity, remove the tail node
            if (map.size() > capacity) {
                map.remove(tail.key);
                removeTail();
            }
        }
        //Add the node at the head position
        setHead(node);
    }

    public Integer get(Integer key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        setHead(node);
        return node.data;
    }

    private void setHead(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            head.next = tail;
            tail.prev = head;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        head.prev = null;
        tail.next = null;
    }

    private void removeTail() {
        if (tail == head) {
            tail = null;
            head = null;
        }
        if (tail != null) {
            if (tail.prev != null) {
                tail.prev.next = null;
            }
            tail = tail.prev;
        }
    }

    private void removeNode(Node node) {
        // Delete the node from current position
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            removeTail();
        }
    }

    public void printContent(String context) {
        System.out.println("Context: " + context);
        if (head == null) {
            System.out.println("Nothing to print");
        }
        Node temp = head;
        while (temp != null) {
            System.out.println("Entry: " + temp.key + " - " + temp.data);
            temp = temp.next;
        }
    }

    private static class Node {
        public Integer key;
        public Node prev, next;
        public Integer data;

        public Node(Integer key, Integer data) {
            this.key = key;
            this.data = data;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}