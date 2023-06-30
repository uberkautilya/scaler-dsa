package dsa05_june30;

import java.util.Arrays;

public class PrefixSum {
    public static void main(String[] args) {

        int left = 0;
        int right = 5;
        int[] array = {3, 2, 6, 9, 1, 3};
        System.out.println("The original Array: " + Arrays.toString(array));
        calculateSumOfElementsFromLeftToRight(array, left, right);

    }

    private static void calculateSumOfElementsFromLeftToRight(int[] array, int left, int right) {
        //Making it prefix sum array
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + array[i];
        }
        System.out.println("Cumulative / Prefix Sum array: " + Arrays.toString(array));

        int sumOfElementsFromLtoR = array[right];
        if (left != 0) {
            //sum till left, exclusive. Hence sum till left-1 should be removed
            sumOfElementsFromLtoR = array[right] - array[left - 1];
        }
        System.out.printf("Sum of elements from index %d to %d: %d", left, right, sumOfElementsFromLtoR);
    }
}
