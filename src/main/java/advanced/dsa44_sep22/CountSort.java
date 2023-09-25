package advanced.dsa44_sep22;

import java.util.ArrayList;
import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(23, 1, 9));
        ArrayList<Integer> resultList = countSort(intList);
        System.out.println("resultList = " + resultList);
    }

    public static ArrayList<Integer> countSort(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        for (int val : A) {
            if (val > max) {
                max = val;
            }
        }
        int[] counter = new int[max + 1];
        for (int val : A) {
            counter[val] += 1;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            int count = counter[i];
            while (count > 0) {
                result.add(i);
                count--;
            }
        }
        return result;
    }
}
