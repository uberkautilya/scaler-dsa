package intermediate.dsa23_july31;

import java.util.HashSet;
//Todo: Not correct on the platform
public class SubArrayWithSumZero {
    public static void main(String[] args) {
        SubArrayWithSumZero subArrayWithSumZero = new SubArrayWithSumZero();
        int result = subArrayWithSumZero.solve(new int[]{
                1, 2, -3, 4, 8, -12
        });
        System.out.println("result = " + result);

    }

    public int solve2(int[] A) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.

        int[] prefixSum = new int[A.length];
        prefixSum[0] = A[0];
        //Find prefix sum array. If a prefix sum repeats or if any value in the prefix sum array is zero, it exists
        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }
        HashSet<Integer> pfSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (prefixSum[i] == 0) {
                return 1;
            }
            //.contains checks for object. May fail for some values
            if (pfSet.contains(prefixSum[i])) {
                System.out.println("Set has: " + prefixSum[i] + "at position: " + i);
                return 1;
            }
            if (prefixSum[i] == 1927507616) System.out.println("i = " + i);
            pfSet.add(prefixSum[i]);
        }
        return 0;
    }

    public int solve(int[] A) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.

        int[] prefixSum = new int[A.length];
        HashSet<Integer> pfSet = new HashSet<>();
        if (A[0] == 0) {
            return 1;
        }
        prefixSum[0] = A[0];
        pfSet.add(prefixSum[0]);
        //Find prefix sum array. If a prefix sum repeats or if any value in the prefix sum array is zero, it exists
        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
            if (prefixSum[i] == 0 || A[i] == 0) {
                return 1;
            }
            pfSet.add(prefixSum[i]);
        }

        if (pfSet.size() < A.length) {
            //Implies there were duplicate prefix sums
            return 1;
        }
        return 0;
    }
}
