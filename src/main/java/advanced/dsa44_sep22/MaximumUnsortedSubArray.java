package advanced.dsa44_sep22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximumUnsortedSubArray {
    public static void main(String[] args) {
//        ArrayList<Integer> indices = subUnsort(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        ArrayList<Integer> indices = subUnsort(new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5)));
        System.out.println("indices = " + indices);
    }

    public static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        if (A.size() == 1) {
            return new ArrayList<>(Collections.singletonList(-1));
        }
        //From right maintain the index of the smallest element, from left maintain the index of the largest element

        int i = 1;
        while (i < A.size()) {
            Integer current = A.get(i);
            Integer previous = A.get(i - 1);
            if (current >= previous) {
                i++;
            } else {
                while (current < A.get(i - 1)) {
                    i--;
                }
                break;
            }
        }
        if (i == A.size()) {
            return new ArrayList<>(Collections.singletonList(-1));
        }
        int j = A.size() - 2;
        while (j >= 0) {
            Integer current = A.get(j);
            Integer previous = A.get(j + 1);
            if (current <= previous) {
                j--;
            } else {
                while (current > A.get(j + 1)) {
                    j++;
                }
                break;
            }
        }
        return new ArrayList<>(Arrays.asList(i, j));
    }
}
