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
        int[] result = solve(A, intList.stream().mapToInt(Integer::intValue).toArray());
        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] solve(int A, int[] B) {
        int[] result = new int[B.length];
        Arrays.fill(result, -1);
        //Create min heap to hold the A largest numbers
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < B.length && i < A; i++) {
            priorityQueue.add(B[i]);
        }
        // For Ath element, which is at index A-1, get the min element from the PQ, as Ath min is present at top
        if (null != priorityQueue.peek()) {
            result[A-1] = priorityQueue.peek();
        }

        for (int i = A; i < B.length; i++) {
            if (null == priorityQueue.peek()) {
                break;
            }
            if (priorityQueue.peek() < B[i]) {
                priorityQueue.remove();
                priorityQueue.add(B[i]);
            }
            result[i] = priorityQueue.peek();
        }
        return result;
    }
}
