package advanced.module7.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class AllSubsetsInArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(9, -20, -11, -8, -4, 2, -12, 14, 1, -18));
        ArrayList<ArrayList<Integer>> subsets = subsets(list);

        subsets.forEach(System.out::println);
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        addSubsets(A, 0, new ArrayList<>(), result);

        result.sort((a1, a2) -> {
            int smallerArraySize = Math.min(a1.size(), a2.size());
            //Find 1st differing element
            for (int i = 0; i < smallerArraySize; i++) {
                Integer e1 = a1.get(i);
                Integer e2 = a2.get(i);
                if (!Objects.equals(e1, e2)) {
                    if (e1 < e2) return -1;
                    return 1;
                }
            }
            //No difference till the last element in shorter array
            return Integer.compare(a1.size(), a2.size());
        });

        System.out.println("The number of subarrays: " + result.size());
        return result;
    }

    private static void addSubsets(final ArrayList<Integer> sortedElements, int index,
                                   ArrayList<Integer> currentArray,
                                   ArrayList<ArrayList<Integer>> result) {
        ArrayList<Integer> arrayListUnderConstruction = new ArrayList<>(currentArray);

        //Base condition: No more elements in the original array to chose from
        if (index >= sortedElements.size()) {
            result.add(arrayListUnderConstruction);
            return;
        }

        //Choice 1: Not choosing the current element
        addSubsets(sortedElements, index + 1, arrayListUnderConstruction, result);

        //Choice 2: Choose the current element
        arrayListUnderConstruction.add(sortedElements.get(index));
        addSubsets(sortedElements, index + 1, arrayListUnderConstruction, result);
    }
}
