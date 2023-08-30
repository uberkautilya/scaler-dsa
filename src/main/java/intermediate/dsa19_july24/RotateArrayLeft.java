package intermediate.dsa19_july24;

import java.util.Arrays;

/**
 * Given an array of integers A and multiple values in B, which represents the number of times array A needs to be left rotated.
 * <p>
 * Find the rotated array for each value and return the result in the form of a matrix where ith row represents the rotated array for the ith value in B.
 */
public class RotateArrayLeft {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        int[] B = new int[]{2, 3};
        System.out.println("solve(A, B) = " + Arrays.deepToString(solve(A, B)));
    }

    public static int[][] solve(int[] A, int[] B) {
        int[][] result = new int[B.length][A.length];

        for (int i = 0; i < B.length; i++) {
            result[i] = rotateLeft(A.clone(), B[i]);
        }
        return result;
    }

    private static int[] rotateLeft(int[] array, int rotation) {
        rotation = rotation % array.length;
        rotate(array, 0, array.length - 1);
        rotate(array, 0, array.length - 1 - rotation);
        rotate(array, array.length - rotation, array.length - 1);

        return array;
    }

    private static void rotate(int[] array, int startIndex, int endIndex) {
        for (int i = startIndex, j = endIndex; i <= (startIndex + endIndex) / 2; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
