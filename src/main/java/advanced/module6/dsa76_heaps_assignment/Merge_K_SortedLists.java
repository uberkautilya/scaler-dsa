package advanced.module6.dsa76_heaps_assignment;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Given a list containing head pointers of N sorted linked lists.
 * Merge these given sorted linked lists and return them as one sorted list.
 */
public class Merge_K_SortedLists {

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode result = null;
        ListNode head = null;
        if (a == null || a.isEmpty()) return result;
        if (a.size() == 1) return a.get(0);

        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        for (ListNode listNodeRef : a) {
            minHeap.add(new Node(listNodeRef));
        }
        if (minHeap.peek() != null) {
            Node node = minHeap.remove();
            if (node.valueRef.next != null) {
                minHeap.add(new Node(node.valueRef.next));
            }
            result = new ListNode(node.value);
            head = result;
        }
        while (minHeap.peek() != null) {
            Node node = minHeap.remove();
            ListNode nextRef = new ListNode(node.value);
            if (node.valueRef.next != null) {
                minHeap.add(new Node(node.valueRef.next));
            }
            result.next = nextRef;
            result = nextRef;
        }
        return head;
    }

    class Node implements Comparable<Node> {
        int value;
        ListNode valueRef;

        public Node(ListNode listNodeRef) {
            this.value = listNodeRef.val;
            this.valueRef = listNodeRef;
        }

        public int compareTo(Node otherNode) {
            int nodeVal = otherNode.value;
            return Integer.compare(value, nodeVal);
        }
    }

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
