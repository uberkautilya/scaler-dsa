package advanced.module7.dynamicprogramming;

import java.util.Arrays;

/**
 * Find minimum number of perfect squares whose sum is number N
 * T.C. = No. of recursion calls x T.C. in each recursion = O(N) x O(sqrtN) = O(N x sqrtN)
 * S.C. = Height of tree = O(N)
 */
public class PerfectSquareSum {
    public static void main(String[] args) {

        int number = 10;
        Integer[] dp = new Integer[number + 1];
        //Max no. of perfect squares whose sum is number is 1^2 + 1^2 +.. = number. Max count is number.
        Arrays.fill(dp, Integer.MAX_VALUE);
        int count = findCount(number, dp);
        System.out.println("count = " + count);
    }

    public static int findCount(int number, Integer[] dp) {
        if (number == 0) {
            return 0;
        }
        if (dp[number] == Integer.MAX_VALUE) {
            for (int i = 1; (i * i) <= number; i++) {
                dp[number] = Math.min(
                        dp[number], 1 + findCount(number - (i * i), dp)
                );
            }
        }
        return dp[number];
    }
}
