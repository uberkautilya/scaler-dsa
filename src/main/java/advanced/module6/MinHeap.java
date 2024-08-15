package advanced.module6;

import java.util.ArrayList;

public class MinHeap {
    //Heaps can be represented in a tree visualization. It is stored in an ArrayList, in the backend
    ArrayList<Integer> minHeap = new ArrayList<>();
    int size = 0;

    public void insert(Integer val) {
        //Previously would have held up to index size - 1.
        minHeap.add(size, val);
        int index = size;

        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            Integer parentElement = minHeap.get(parentIndex);
            Integer currentElement = minHeap.get(index);

            if (parentElement > currentElement) {
                swap(minHeap, parentIndex, index);
                index = parentIndex;
            } else {
                break;
            }
        }
        //The size is updated to factor in this element addition
        size = size + 1;
    }

    public Integer getMin() {
        //This is the minimum value in the minHeap
        Integer min = minHeap.get(0);
        //Now put the rightmost element in the root position and heapify
        minHeap.set(0, minHeap.get(size - 1));
        //Once the min element is removed from the heap, size -> size - 1
        size--;
        int index = 0;

        while (index < size) {
            //Index holding the left child element of current node
            int lChildIndex = 2 * index + 1;
            int rChildIndex = 2 * index + 2;

            Integer currentElement = minHeap.get(index);
            Integer leftChild = minHeap.get(lChildIndex);
            Integer rightChild = minHeap.get(rChildIndex);

            if (rChildIndex < size) {
                // rChildIndex exists
                if (leftChild <= currentElement && leftChild <= rightChild) {
                    swap(minHeap, lChildIndex, index);
                    index = lChildIndex;
                } else if (rightChild <= currentElement && rightChild <= leftChild) {
                    swap(minHeap, rChildIndex, index);
                    index = rChildIndex;
                }
            } else if (lChildIndex < size) {
                // rChildIndex is out of bounds
                if (leftChild <= currentElement) {
                    swap(minHeap, lChildIndex, index);
                    index = lChildIndex;
                }
            } else {
                break;
            }
        }
        return min;
    }

    public Integer peek() {
        if (minHeap.isEmpty()) {
            return null;
        }
        return minHeap.get(0);
    }

    private void swap(ArrayList<Integer> minHeap, int index1, int index2) {
        int size = minHeap.size();
        if (index1 < 0 || index2 < 0 || size <= index1 || size <= index2) {
            System.out.println("index1 = " + index1);
            System.out.println("index2 = " + index2);
            System.out.println("size = " + size);
            return;
        }
        Integer temp = minHeap.get(index1);
        minHeap.set(index1, minHeap.get(index2));
        minHeap.set(index2, temp);
    }
}
