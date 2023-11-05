package advanced.module6.linked_lists.day62;

public class DeepCopyLinkedListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        insertCopy(head);
        RandomListNode x = head;
        while (x != null) {
            RandomListNode y = x.next;
            if (x.random != null) {
                y.random = x.random.next;
            }
            x = x.next.next;
        }
        //Remove the old nodes
        RandomListNode newHead = head.next;
        x = head;
        while (x != null) {
            RandomListNode y = x.next;
            x.next = x.next.next;
            if (y.next != null) {
                y.next = y.next.next;
            }
            x = x.next;
        }
        return newHead;
    }

    //Adds a copy after the node itself
    public void insertCopy(RandomListNode head) {
        RandomListNode x = head;
        while (x != null) {
            RandomListNode n = new RandomListNode(x.label);
            n.next = x.next;
            x.next = n;
            x = x.next.next;
        }
    }

    //This being a member of the outer class, static indicates an instance can be created without instantiating the outer class
    public static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
