package advanced.module7.graphs;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CustomQueue implements Queue<Node> {
    LinkedList<Node> linkedList = new LinkedList<>();

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return linkedList.contains(o);
    }

    @Override
    public Iterator<Node> iterator() {
        return linkedList.iterator();
    }

    @Override
    public Object[] toArray() {
        return linkedList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Node node) {
        return linkedList.add(node);
    }

    @Override
    public boolean remove(Object o) {
        return linkedList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return linkedList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Node> c) {
        return linkedList.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return linkedList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return linkedList.retainAll(c);
    }

    @Override
    public void clear() {
        linkedList.clear();
    }

    @Override
    public boolean offer(Node node) {
        return linkedList.offer(node);
    }

    @Override
    public Node remove() {
        return linkedList.remove();
    }

    @Override
    public Node poll() {
        return linkedList.poll();
    }

    @Override
    public Node element() {
        return linkedList.element();
    }

    @Override
    public Node peek() {
        return linkedList.peek();
    }
}
