package dsa23_july31;

import java.util.Arrays;
import java.util.HashMap;

public class FrequencyOfElementInQuery {
    public static void main(String[] args) {
        FrequencyOfElementInQuery frequencyOfElementInQuery = new FrequencyOfElementInQuery();
        int[] result = frequencyOfElementInQuery.solve(new int[]{6, 3, 3, 6, 7, 8, 7, 3, 7}, new int[]{10, 9, 8});
        System.out.println("result = " + Arrays.toString(result));

    }

    public int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int[] result = new int[B.length];

        for (int val : A) {
            frequencyMap.put(val, frequencyMap.getOrDefault(val, 0) + 1);
        }

        for (int i = 0; i < B.length; i++) {
            int value = frequencyMap.getOrDefault(B[i], 0);
            result[i] = value;
        }
        return result;
    }
}
