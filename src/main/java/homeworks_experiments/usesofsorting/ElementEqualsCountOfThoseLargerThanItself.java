package homeworks_experiments.usesofsorting;

import java.util.Arrays;

/**
 * Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.
 * 1 <= |A| <= 2*105
 * -10^8 <= A[i] <= 10^8
 */
public class ElementEqualsCountOfThoseLargerThanItself {
    public static void main(String[] args) {
        int[] array = new int[]{
                -4, -2, 0, -1, -6
        };
        System.out.println("solve(array) = " + solve(array));
    }

    public static int solve(int[] A) {
        Arrays.sort(A);
        int length = A.length;
        int[] count = new int[length];

        //Greater elements for the last elements in a sorted array is 0;
        count[length - 1] = 0;
        if (A[length - 1] == 0) {
            return 1;
        }

        for (int i = length - 2; i >= 0; i--) {
            if (A[i] != A[i + 1]) {
                //This is the first occurance of the element at i
                count[i] = length - 1 - i;
            } else {
                count[i] = count[i + 1];
            }
            if (count[i] == A[i]) {
                return 1;
            }
        }
        System.out.println("A = " + Arrays.toString(A));
        System.out.println("count = " + Arrays.toString(count));
        return -1;
    }
}
