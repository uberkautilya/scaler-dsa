package dsa05_june30;

import java.util.ArrayList;
import java.util.List;

public class EquilibriumIndicesInArray {
    public static void main(String[] args) {
        int[] array = {3, -1, -2, 0, 0};
        List<Integer> indices = equilibriumIndicesInArray(array);
        System.out.println("The indices at which the array is at equilibrium are: " + indices);
    }

    /**
     * An equilibrium array is one where the sum of elements prior to a given element is equal to the sum of all the elements that come after it
     *
     * @param array
     * @return
     */
    private static List<Integer> equilibriumIndicesInArray(int[] array) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + array[i];
        }
        if (array[array.length - 1] - array[0] == 0) {
            indices.add(0);
        }
        //Right edge is handled, as at index i = n-1,
        // left = pf[n-2],
        // right = pf[maxSumAt = n-1] - pf[tillLastElement = n-1] = 0
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] == array[array.length - 1] - array[i]) {
                indices.add(i);
            }
        }
        return indices;
    }
}
