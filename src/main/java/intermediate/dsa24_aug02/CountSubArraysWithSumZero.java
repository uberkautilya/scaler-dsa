package intermediate.dsa24_aug02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountSubArraysWithSumZero {
    public static void main(String[] args) {
        CountSubArraysWithSumZero countSubArraysWithSumZero = new CountSubArraysWithSumZero();
//        int result = countSubArraysWithSumZero.solve(new int[]{30, -30, 30, -30}); //Expected: 4
//        int result = countSubArraysWithSumZero.solve(new int[]{-6, -5, 6, -5, 4, -3, -7}); //Expected: 1
        int result = countSubArraysWithSumZero.solve(new int[]{-1, 8, -4, 7, -4, 0, -8, -2, -7}); //Expected: 1
//        int result = countSubArraysWithSumZero.solve(new int[]{1, -1, -2, 2});
        System.out.println("result = " + result);

    }

    public int solve(int[] A) {
        HashMap<Long, List<Integer>> hashMap = new HashMap<>();
        long countOfSubArrays = 0L;

        Long[] prefixSum = new Long[A.length];

        prefixSum[0] = (long) A[0];
        hashMap.put(prefixSum[0], new ArrayList<Integer>() {
            {
                add(0);
            }
        });
        if (A[0] == 0) {
            countOfSubArrays++;
        }
        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
            if (prefixSum[i] == 0) {
                countOfSubArrays++;
            }
            if (hashMap.containsKey(prefixSum[i])) {
                List<Integer> indices = hashMap.get(prefixSum[i]);
                indices.add(i);
                hashMap.put(prefixSum[i], indices);
            } else {
                int finalI = i;
                hashMap.put(prefixSum[i], new ArrayList() {
                    {
                        add(finalI);
                    }
                });
            }
        }

        for (Long key : hashMap.keySet()) {
            if (hashMap.get(key).size() > 1) {
                int repeats = hashMap.get(key).size();
                countOfSubArrays += ((long) repeats * (repeats - 1) / 2) % 1000_000_007;
            }
        }

        return ((int) (countOfSubArrays % 1000_000_007));
    }
}
