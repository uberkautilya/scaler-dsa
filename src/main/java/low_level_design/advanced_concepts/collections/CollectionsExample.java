package low_level_design.advanced_concepts.collections;

import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) {
        //ArrayList and LinkedList are not thread safe
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Vectors and Stacks are synchronized - thread safe
        List<Integer> vector = new Vector<>();
        List<Integer> stack = new Stack<>();

        //Concurrency enabled data structures are present in java.util.concurrent.* package

        //Set: Doesn't support duplicates, allows one null in a set - 3 implementations
        //No order guarantee
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(16);
        hashSet.add(23);
        hashSet.add(3);
        hashSet.add(1);
        hashSet.add(91);
        hashSet.add(9);
        System.out.println("hashSet = " + hashSet);

        //Natural sort order - also supports a Constructor with a Comparator
        //Uses Balanced Binary Search Tree - Red Black Tree (Self Balancing)
        //T.C. is Logarithmic
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(16);
        treeSet.add(23);
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(91);
        treeSet.add(9);
        System.out.println("treeSet = " + treeSet);

        //Order of insertion maintained
        //LinkedHashSet uses LRU: Least Recently Used Cache structure - Doubly Linked List(For Insertion order) and a HashSet(For quick search)
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(16);
        linkedHashSet.add(23);
        linkedHashSet.add(3);
        linkedHashSet.add(1);
        linkedHashSet.add(91);
        linkedHashSet.add(9);
        System.out.println("linkedHashSet = " + linkedHashSet);

        //Queue: Implements Deque - Doubly ended Queue, along with List
        //Deque has an array implementation as well: ArrayDeque
        Queue<Integer> linkedListQueue = new LinkedList<>();
        //The other implementation that can have any ordering - is a Heap
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(23);
        priorityQueue.add(5);
        priorityQueue.add(2);
        priorityQueue.add(91);
        priorityQueue.add(21);
        priorityQueue.add(4);
        System.out.println("priorityQueue = " + priorityQueue);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

        //Maps - 3 Implementations
        //Backed by a HashTree
        Map<Integer, Integer> hashMap = new HashMap<>();
        //DLL(ordering) + HashMap(for search)
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        //Natural ordering based on the key
        Map<Integer, Integer> treeMap = new TreeMap<>();

        /*
        HashTable is the thread-safe alternative to HashMap
        However it blocks every other function when a method is executing
        Alternative optimized version is the ConcurrentHashMap - has partitions
        ConcurrentHashMap - separate segments/ buckets within the single hashmap
        Updates/ Writes block only that bucket. Reads does not take any lock - performant
        */

    }
}
