package homeworks_experiments;

import java.util.ArrayList;
import java.util.List;

public class MaxSumInArrayLimitB {
    public static void main(String[] args) {

        int maxSumLimitB = findMaxSumLimitBSlidingWindowPotentially(5, 7, new int[]{3,8,8,9,7});
//        int maxSumLimitB = findMaxSumLimitBSlidingWindowPotentially(5, 12, new int[]{2, 1, 3, 4, 5});
//        int maxSumLimitB = findMaxSumLimitBSlidingWindowPotentially(3, 1, new int[]{2, 2, 2});
//        int maxSumLimitB = findMaxSumLimitBSlidingWindowPotentially(1, 75, new int[]{4});
//        int maxSumLimitB = findMaxSumLimitBSlidingWindowPotentially(9, 14, new int[]{1,2,4,4,5,5,5,7,5});
        System.out.println("maxSumLimitB = " + maxSumLimitB);
    }

    private static int findMaxSumLimitBSlidingWindowPotentially(int A, int B, int[] C) {
        //Apply sliding window technique
        int highestSum = 0;
        int sum = 0;
        for (int index = 0, startIndex = 0; startIndex < A && index < 2 * A; index++) {
            if (index < A) {
                sum += C[index];
            }

            while (sum > B) {
                sum -= C[startIndex];
                startIndex++;
            }
            if (sum > highestSum && sum <= B) {
                highestSum = sum;
                if (sum == B) return sum;
            }
        }
        return highestSum;
    }

    /**
     * You are given an integer array C of size A.
     * Find a sub array (contiguous elements) so that the sum of contiguous elements is maximized.
     * But the sum must not exceed B.
     *
     * @param A
     * @param B
     * @param C
     * @return
     */
    public int maxSubarray(int A, int B, int[] C) {
        //A is the length of the array C, Return max sum which doesn't exceed B

        int maxSum = 0;
        for (int i = 0; i < A; i++) {

            int sum = 0;
            for (int j = i; j < A; j++) {
                if (sum + C[j] <= B) {
                    sum += C[j];
                } else {
                    break;
                }
                if (sum == B) {
                    return sum;
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return maxSum;
    }
}
