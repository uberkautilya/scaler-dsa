package dsa23_july31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommonElementsInBothArrays {
    public static void main(String[] args) {
        CommonElementsInBothArrays commonElementsInBothArrays = new CommonElementsInBothArrays();
        int[] result = commonElementsInBothArrays.solve(
                new int[]{1, 2, 2, 1},
                new int[]{2, 3, 1, 2}
        );
        System.out.println("result = " + Arrays.toString(result));
    }

    public int[] solve(int[] A, int[] B) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.

        HashMap<Integer, Integer> frequencyMapA = new HashMap<>();
        HashMap<Integer, Integer> frequencyMapB = new HashMap<>();
        for (int a : A) {
            frequencyMapA.put(a, frequencyMapA.getOrDefault(a, 0) + 1);
        }
        for (int b : B) {
            frequencyMapB.put(b, frequencyMapB.getOrDefault(b, 0) + 1);
        }
        List<Integer> valueList = new ArrayList<>();
        for (Integer key : frequencyMapA.keySet()) {
            Integer frequencyA = frequencyMapA.get(key);
            Integer frequencyB = frequencyMapB.getOrDefault(key, 0);
            while (frequencyA > 0 && frequencyB > 0) {
                valueList.add(key);
                frequencyA--;
                frequencyB--;
            }
        }
        return valueList.stream().mapToInt(Integer::intValue).toArray();
    }
}
