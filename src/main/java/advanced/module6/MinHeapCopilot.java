package advanced.module6;

import java.util.Arrays;

public class MinHeapCopilot {

    private final int[] heap;
    private final int size;

    public MinHeapCopilot(int[] array) {
        this.heap = array;
        this.size = array.length;
        buildHeap();
    }

    // Method to build the heap
    private void buildHeap() {
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    // Method to heapify a subtree rooted at index i
    private void heapify(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    // Utility method to swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Method to print the heap
    public void printHeap() {
        System.out.println(Arrays.toString(heap));
    }

    public static void main(String[] args) {
        int[] array = {4, 10, 3, 5, 1};
        MinHeapCopilot minHeap = new MinHeapCopilot(array);
        minHeap.printHeap(); // Output: [1, 4, 3, 10, 5]
    }

}
