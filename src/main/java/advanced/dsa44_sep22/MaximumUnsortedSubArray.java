package advanced.dsa44_sep22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximumUnsortedSubArray {
    public static void main(String[] args) {
//        ArrayList<Integer> indices = subUnsort(new ArrayList<>(Arrays.asList(3, 3, 4, 5, 5, 9, 11, 13, 14, 15, 15, 16, 15, 20, 16))); //11, 14 expected
        ArrayList<Integer> indices = subUnsort(new ArrayList<>(Arrays.asList(1,2,2,3,3,5,6,6,14,17,18,17,18,15,15,17,19,14,19,18))); // 9, 19 expected
//        ArrayList<Integer> indices = subUnsort(new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5)));
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
                i--;
                while (i != -1 && current < A.get(i)) {
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
                j++;
                while (j != A.size() && current > A.get(j)) {
                    j++;
                }
                break;
            }
        }
        //Current is greater than A[j], but increment happens to the next
        return new ArrayList<>(Arrays.asList(i + 1, j - 1));
    }
}
