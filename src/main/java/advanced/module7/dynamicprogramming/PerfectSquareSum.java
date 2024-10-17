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
        int count = findCountUsingDP(number, dp);

        System.out.println("Count with top-down dp: " + count);
        Arrays.fill(dp, Integer.MAX_VALUE);
        System.out.println("Count with memoization: " + findCountUsingMemoization(number, dp));
    }

    public static int findCountUsingDP(int number, Integer[] dp) {
        if (number == 0) {
            return 0;
        }
        if (dp[number] == Integer.MAX_VALUE) {
            for (int i = 1; (i * i) <= number; i++) {
                dp[number] = Math.min(
                        dp[number], 1 + findCountUsingDP(number - (i * i), dp)
                );
            }
        }
        return dp[number];
    }

    public static int findCountUsingMemoization(int number, Integer[] dp) {
        if (number == 0) {
            return 0;
        }
        dp[0] = 0;
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[number];
    }
}
