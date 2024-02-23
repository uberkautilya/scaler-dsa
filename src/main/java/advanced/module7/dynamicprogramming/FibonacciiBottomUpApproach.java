package advanced.module7.dynamicprogramming;

import java.util.Arrays;

public class FibonacciiBottomUpApproach {
    /**
     * S.C. = O(N) from Recursive stack space  + Memoization Array size = O(N+N) = O(N)
     * @param args
     */
    public static void main(String[] args) {

        int index = 4;
        Integer[] dp = new Integer[index + 1];
        int result = getNthIndexFibonacciiValue(index, dp);
        System.out.println("result = " + result);
    }

    /**
     Bottom Up Approach
     * @param N
     * @param dp
     * @return
     */
    public static int getNthIndexFibonacciiValue(int N, Integer[] dp) {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }
}
