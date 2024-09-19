package advanced.module6.heaps2;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an integer array B of size N.
 * You need to find the Ath largest element in the subarray [1 to i], where i varies from 1 to N.
 * In other words, find the Ath largest element in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].
 * NOTE: If any sub-array [1 : i] has less than A elements, then the output should be -1 at the ith index.
 */
public class AthLargestElement {
    public static void main(String[] args) {
//        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> intList = Arrays.asList(15, 20, 99, 1);
//        int A = 4;
        int A = 2;
        int[] result = solve(A, new int[]{15, 20, 99, 1});
        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] solve(int A, int[] B) {
        int[] result = new int[B.length];
        Arrays.fill(result, -1);
        //Create min heap to hold the A largest numbers
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < B.length && i < A; i++) {
            minHeap.add(B[i]);
        }
        // For getting result for index A-1 (i.e., B[A-1]), get the top element from the minHeap
        // At a given time, minHeap holds the 'A' largest elements
        if (null != minHeap.peek()) {
            result[A-1] = minHeap.peek();
        }

        for (int i = A; i < B.length; i++) {
            if (null == minHeap.peek()) {
                break;
            }
            // At a given time, minHeap holds the 'A' largest elements
            if (B[i] > minHeap.peek()) {
                minHeap.remove();
                minHeap.add(B[i]);
            }
            result[i] = minHeap.peek();
        }
        return result;
    }
}
