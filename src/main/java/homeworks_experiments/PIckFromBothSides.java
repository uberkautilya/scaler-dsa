package homeworks_experiments;

import java.util.Arrays;

public class PIckFromBothSides {
    public static void main(String[] args) {
        int maxSum = solve(new int[]{5, -2, 3, 1, 2}, 3);

    }

    /**
     * You are given an integer array A of size N.
     *
     * You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.
     *
     * Find and return the maximum possible sum of the B elements that were removed after the B operations.
     *
     * NOTE: Suppose B = 3, and array A contains 10 elements, then you can:
     *
     * Remove 3 elements from front and 0 elements from the back, OR
     * Remove 2 elements from front and 1 element from the back, OR
     * Remove 1 element from front and 2 elements from the back, OR
     * Remove 0 elements from front and 3 elements from the back.
     * @param A
     * @param B
     * @return
     */
    public static int solve(int[] A, int B) {
        int[] arrayEdgeElements = new int[2 * B];
        int i = 0;
        for (; i < B; i++) {
            arrayEdgeElements[i] = A[B - i - 1];
        }
        for (int j = A.length - 1; j > A.length - 1 - B; j--) {
            arrayEdgeElements[i] = A[j];
            i++;
        }
        System.out.println(Arrays.toString(arrayEdgeElements));
        int maxSum = 0;
        int sum = 0;
        for (int j = 0; j < arrayEdgeElements.length; j++) {
            if (j < B) {
                sum += arrayEdgeElements[j];
                maxSum = sum;
            } else {
                sum -= arrayEdgeElements[j - B];
                sum += arrayEdgeElements[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        System.out.println("Maximum sum: " + maxSum);
        return maxSum;
    }
}
