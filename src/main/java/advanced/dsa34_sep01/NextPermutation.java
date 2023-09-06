package advanced.dsa34_sep01;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
 * <p>
 * If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.
 */
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        ArrayList<Integer> result = nextPermutation.nextPermutation(new ArrayList<>(Arrays.asList(
                7, 3, 4, 5, 2, 1, 3, 3, 1
        )));
        System.out.println("result = " + result);

    }

    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        //734521313 -> Start from the rightmost element. The first element less than it should be swapped
        for (int j = 1; j < A.size() - 1; j++) {

            for (int i = A.size() - 1; i > 0 && i - j >= 0; i--) {
                if (A.get(i - j).toString().compareTo(A.get(i).toString()) < 0) {
                    swap(A, i - j, i);
                    return A;
                }
            }
        }

        return A;
    }

    void swap(ArrayList<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}
