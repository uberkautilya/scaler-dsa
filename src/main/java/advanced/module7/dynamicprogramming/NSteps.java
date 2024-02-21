package advanced.module7.dynamicprogramming;

import java.util.Arrays;

public class NSteps {
    public static void main(String[] args) {

        int noOfSteps = 6;
        int noOfPathways = getCountOfWaysToReachNthStep(noOfSteps);
        System.out.println("noOfPathways = " + noOfPathways);

        int[] dp = new int[noOfSteps + 1];
        Arrays.fill(dp, -1);
        int countWithDP = getCountWithDP_TopDown(noOfSteps, dp);
        System.out.println("countWithDP = " + countWithDP);

        int countWithDPBottomUp = getCountWithDP_BottomUp(noOfSteps, new int[noOfSteps + 1]);
        System.out.println("countWithDPBottomUp = " + countWithDPBottomUp);
    }

    public static int getCountOfWaysToReachNthStep(int N) {
        if (N <= 3) {
            return N;
        }
        //The Nth step is reachable from either N-1th step or N-2th step, each representing one jump
        return getCountOfWaysToReachNthStep(N - 1) + getCountOfWaysToReachNthStep(N - 2);
    }

    public static int getCountWithDP_TopDown(int N, int[] dp) {
        if (N <= 3) {
            return N;
        }
        if (dp[N] == -1) {
            dp[N] = getCountWithDP_TopDown(N - 1, dp) + getCountWithDP_TopDown(N - 2, dp);
        }
        return dp[N];
    }

    public static int getCountWithDP_BottomUp(int N, int[] bottomUp) {
        if (N <= 3) {
            return N;
        }
        bottomUp[0] = 0;
        bottomUp[1] = 1;
        bottomUp[2] = 2;

        for (int i = 3; i <= N; i++) {
            bottomUp[i] = bottomUp[i - 1] + bottomUp[i - 2];
        }
        return bottomUp[N];
    }
}
