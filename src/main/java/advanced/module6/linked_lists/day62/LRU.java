package advanced.module6.linked_lists.day62;

import java.util.HashMap;
import java.util.Map;

/**
 * The data structure has a fixed capacity. It should hold th most recent N nodes.
 * When an existing data appears, it should be updated as the most recent one.
 *
 * Least Recently Used (LRU) cache should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
 * The LRU Cache will be initialized with an integer corresponding to its capacity maximum number of unique keys it can hold at a time.
 *
 * There is 1 lines in the input
 * Line 1 ( Corresponds to arg 1 ) : The line starts with a pair of numbers - numOperations, capacity.
 * Then numOperation operations follow.
 * Each operation is either :
 *  * G  : This corresponds to a function call get()
 *  * S   : This corresponds to a function call set(num1, num2)
 * Note that the function calls are made in order.
 */
public class LRU {
    Integer capacity;

    public LRU(Integer capacity) {
        this.capacity = capacity;
    }

    Node head = null, tail = null;
    Map<Integer, Node> map = new HashMap<>();

    public void insertData(Integer value) {
        boolean valueExists = map.containsKey(value);
        Node node;
        if (valueExists) {
            node = map.get(value);
            node.prev = null;
            removeNode(node);
        } else {
            node = new Node(value);
            map.put(value, node);
        }

        updateHead(node);
        if (map.size() >= capacity) {
            removeTail();
            if (!valueExists) {
                map.remove(tail.data);
            }
        }
    }

    private void updateHead(Node node) {
        if(head == null) {
            head = node;
            tail = node;
            head.next = tail;
            tail.prev = head;
            tail.next = null;
            head.prev = null;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    private void removeTail() {
        if (tail != null) {
            if (tail.prev != null) {
                tail.prev.next = null;
            }
            tail = tail.prev;
        }
    }

    private void removeNode(Node node) {
        // Delete the node from current position
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private static class Node {
        public Node prev, next;
        public Integer data;

        public Node(Integer data) {
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
