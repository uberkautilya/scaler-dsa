package homeworks_experiments;

import java.util.Arrays;

public class ProductArrayIndexExcluded {

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(
                calculateProductArray(A)
        ));
    }

    /**
     * Given an array of integers A,
     * find and return the product array of the same size
     * where the ith element of the product array will be equal to the product of all the elements divided by the ith element of the array.
     * </p>
     * Note: It is always possible to form the product array with integer (32 bit) values.
     * Solve it without using the division operator.
     *
     * @param A
     * @return
     */
    private static int[] calculateProductArray(int[] A) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {

            result[i] = 1;
            int index = 0;

            while (index < A.length) {
                if (i != index) {
                    result[i] = result[i] * A[index];
                }
                index++;
            }

        }
        return result;
    }
}
