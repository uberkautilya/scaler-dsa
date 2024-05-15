package lld.oops4.assignments;

import java.util.Iterator;

public class Node implements Iterable<Node>{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node node) {
        this.data = data;
        this.next = node;
    }

    @Override
    public Iterator<Node> iterator() {
        return new NodeIterator(this);
    }
}

class NodeIterator implements Iterator<Node> {
    Node head;

    public NodeIterator(Node node) {
        this.head = node;
    }

    @Override
    public boolean hasNext() {
        return head == null;
    }

    @Override
    public Node next() {
        Node temp = head;
        head = head.next;

        return temp;
    }
}