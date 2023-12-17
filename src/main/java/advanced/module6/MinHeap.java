package advanced.module6;

import java.util.ArrayList;

public class MinHeap {
    //Heaps can be represented in a tree visualization. It is stored in an ArrayList, in the backend
    ArrayList<Integer> minHeap = new ArrayList<>();
    int size = 0;

    void insert(Integer val) {
        //Previously would have held up to index size - 1.
        minHeap.add(size, val);
        int index = size;

        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (minHeap.get(parentIndex) > minHeap.get(index)) {
                swap(minHeap, parentIndex, index);
                index = parentIndex;
            } else {
                break;
            }
        }
        //The size is updated to factor in this element addition
        size = size + 1;
    }

    Integer getMin() {
        //This is the minimum value in the minHeap
        Integer min = minHeap.get(0);
        //Now put the rightmost element in the root position and heapify
        minHeap.add(0, minHeap.get(size - 1));
        //Once the min element is removed from the heap, size -> size - 1
        size = size - 1;
        int i = 0;

        while (i < size) {
            //Index holding the left child element of current node
            int leftC = 2 * i + 1;
            int rightC = 2 * i + 2;
            if (rightC < size) {
                if (minHeap.get(leftC) <= minHeap.get(i) && minHeap.get(leftC) <= minHeap.get(rightC)) {
                    swap(minHeap, leftC, i);
                    i = leftC;
                } else if (minHeap.get(rightC) <= minHeap.get(i) && minHeap.get(rightC) <= minHeap.get(leftC)) {
                    swap(minHeap, rightC, i);
                    i = rightC;
                }
            } else if (leftC < size) {
                if (minHeap.get(leftC) <= minHeap.get(i)) {
                    swap(minHeap, leftC, i);
                    i = leftC;
                }
            } else {
                break;
            }
        }
        return min;
    }

    private void swap(ArrayList<Integer> minHeap, int index1, int index2) {
        int size = minHeap.size();
        if (index1 < 0 || index2 < 0 || size >= index1 || size >= index2) {
            System.out.println("Invalid values passed as arguments");
            return;
        }
        Integer temp = minHeap.get(index1);
        minHeap.add(index1, minHeap.get(index2));
        minHeap.add(index2, temp);
    }
}
