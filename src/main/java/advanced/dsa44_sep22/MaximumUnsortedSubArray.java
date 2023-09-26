package advanced.dsa44_sep22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximumUnsortedSubArray {
    public static void main(String[] args) {
//        ArrayList<Integer> indices = subUnsort(new ArrayList<>(Arrays.asList(3, 3, 4, 5, 5, 9, 11, 13, 14, 15, 15, 16, 15, 20, 16))); //11, 14 expected
        ArrayList<Integer> indices = subUnsort(new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 5, 6, 6, 14, 17, 18, 17, 18, 15, 15, 17, 19, 14, 19, 18))); // 9, 19 expected
//        ArrayList<Integer> indices = subUnsort(new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5)));
        System.out.println("indices = " + indices);
    }

    public static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        if (A.size() == 1) {
            return new ArrayList<>(Collections.singletonList(-1));
        }
        //From right maintain the lIndex of the smallest element, from left maintain the lIndex of the largest element
        int lIndex = 0;
        int hIndex = A.size() - 1;

        int i = 1;
        Integer minVal = Integer.MAX_VALUE;
        boolean isSorted = true;
        while (i < A.size()) {
            Integer current = A.get(i);
            Integer previous = A.get(i - 1);
            if (current < previous) {
                isSorted = false;
                if (current < minVal) {
                    minVal = current;
                    lIndex = i;
                }
            }
            i++;
        }
        if (isSorted) {
            return new ArrayList<>(Collections.singletonList(-1));
        }
        int j = A.size() - 2;
        Integer maxVal = Integer.MIN_VALUE;
        while (j >= 0) {
            Integer current = A.get(j);
            Integer previous = A.get(j + 1);
            if (current > previous) {
                if (current > maxVal) {
                    maxVal = current;
                    hIndex = i;
                }
            }
            j--;
        }
        return new ArrayList<>(Arrays.asList(lIndex, hIndex));
    }
}
