package advanced.module7.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3));

        ArrayList<ArrayList<Integer>> result = permutations.permute(arrayList);
        System.out.println("result = " + result);

    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A.isEmpty()) {
            return result;
        }
        permutations(A, 0, result);
        return result;
    }

    private void permutations(ArrayList<Integer> arrayList, Integer index,
                              ArrayList<ArrayList<Integer>> result) {
        ArrayList<Integer> arrayListCopy = new ArrayList<>(arrayList);
        if (index >= arrayList.size()) {
            result.add(arrayListCopy);
            return;
        }

        //At present all numbers till the index 'index' are chosen in the previous recursions
        for (int i = index; i < arrayListCopy.size(); i++) {

            //Choice 1: Swap element at index i to the 'index' position
            swap(arrayListCopy, index, i);
            permutations(arrayListCopy, index + 1, result);

            //Choice 2: Keep the current number at the index 'index'
            swap(arrayListCopy, index, i);
        }
    }

    private void swap(ArrayList<Integer> arrayList, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        arrayList.set(index1, arrayList.get(index1) + arrayList.get(index2));
        arrayList.set(index2, arrayList.get(index1) - arrayList.get(index2));
        arrayList.set(index1, arrayList.get(index1) - arrayList.get(index2));
    }
}
