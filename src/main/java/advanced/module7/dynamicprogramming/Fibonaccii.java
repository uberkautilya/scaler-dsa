package advanced.module7.dynamicprogramming;

import java.util.Arrays;

public class Fibonaccii {
    /**
     * Fibonaccii start with 0 at index 0.
     * T.C. = O(N) from earlier recursion solution with O(2^N)
     *  -> recursion stack count(N) x time for each recursive call(1) = O(N)
     * S.C. = O(N) from Recursive stack space  + Memoization Array size = O(N+N) = O(N)
     * @param args
     */
    public static void main(String[] args) {

        int N = 4;
        Integer[] dp = new Integer[12 + 1];
        Arrays.fill(dp, -1);
        int result = getNthIndexFibonacciiValue(N, dp);
        System.out.println("result = " + result);
    }

    /**
     * Top Down approach
     * @param N
     * @param dp
     * @return
     */
    public static int getNthIndexFibonacciiValue(int N, Integer[] dp) {
        if (N <= 1) {
            return N;
        }
        if (dp[N] == -1) {
            dp[N] = getNthIndexFibonacciiValue(N - 1, dp) + getNthIndexFibonacciiValue(N - 2, dp);
        }
        return dp[N];
    }
}
