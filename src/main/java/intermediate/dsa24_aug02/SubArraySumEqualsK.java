package intermediate.dsa24_aug02;

import java.util.ArrayList;
import java.util.HashMap;

public class SubArraySumEqualsK {

    public static void main(String[] args) {
        SubArraySumEqualsK subArraySumEqualsK = new SubArraySumEqualsK();
        int result = subArraySumEqualsK.solve(new int[]{-18, -1, -13, -15, 18, 5, -4, 5, 9}, 14); //Expected: 1
//        int result = subArraySumEqualsK.solve(new int[]{19, -10, -13, 10, -13, 6, 7, 2, 18, -19, -4}, 19); //Expected: 0
//        int result = subArraySumEqualsK.solve(new int[]{-1, -8, -13, 5, -4, 13, 10, 13}, 4); //Expected: 0
        System.out.println("result = " + result);

    }


    public int solve(int[] A, int B) {
        int count = 0;
        HashMap<Long, ArrayList<Integer>> hashMap = new HashMap<>();

        Long[] prefixSum = new Long[A.length];
        //Edge case
        prefixSum[0] = (long) A[0];
        hashMap.put(prefixSum[0], new ArrayList<Integer>() {
            {
                add(0);
            }
        });
        if (prefixSum[0] == B) {
            count++;
        }

        //Logic
        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
            //If prefixSum is equal to B
            if (prefixSum[i] == B) {
                count++;
            }

            //Check how many times B - prefixSum[i] occurs before the current element
            Long checkValue = (prefixSum[i] - B);
            ArrayList<Integer> desiredOccurrences = hashMap.getOrDefault(checkValue, new ArrayList<>());
            count += desiredOccurrences.size();

            ArrayList<Integer> indices = hashMap.getOrDefault(prefixSum[i], new ArrayList<>());
            indices.add(i);
            hashMap.put(prefixSum[i], indices);
        }
        return count;
    }
}
