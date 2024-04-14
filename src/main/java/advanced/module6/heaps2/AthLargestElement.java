package advanced.module6.heaps2;

import java.util.Arrays;
import java.util.Comparator;
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
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < B.length; i++) {
            priorityQueue.add(B[i]);
            int val = getAthHighest(new PriorityQueue<>(priorityQueue), A);
            result[i] = val;
        }
        return result;
    }

    private static Integer getAthHighest(PriorityQueue<Integer> integers, int popCount) {
        int count = 0;
        Integer value = null;
        while (integers.peek() != null && count < popCount) {
            value = integers.remove();
            count++;
        }
        if (count == popCount) {
            return value;
        }
        return -1;
    }
}
