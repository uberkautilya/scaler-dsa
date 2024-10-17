package advanced.module7.dynamicprogramming.dp2_two_dimentional;

import java.util.Arrays;

public class DungeonPrincess {
    public static void main(String[] args) {
        int[][] health = {{1, 2, 3, 4, 5}, {2, 3, 4, 5, 6}, {3, 4, 5, 6, 7}, {4, 5, 6, 7, 8}, {5, 6, 7, 8, -9}};
        int[][] dp = new int[5][5];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        int minHealthRequiredToReachTargetCell = minHealth(0, 0, health, dp);
        System.out.println("minHealthRequiredToReachTargetCell = " + minHealthRequiredToReachTargetCell);
    }
    static int minHealth(int startRow, int startCol, int[][] health, int[][] dp) {
        int N = health.length;
        int M = health[0].length;
        //Out of bounds from the matrix
        if (startRow >= N || startCol >= M) {
            return Integer.MAX_VALUE;
        }
        int healthImpact = health[startRow][startCol];
        //Target cell reached
        if (startRow == N - 1 && startCol == M - 1) {
            return Math.max(1, 1 - healthImpact);
        }
        if (dp[startRow][startCol] == -1) {
            int a = minHealth(startRow, startCol + 1, health, dp);
            int b = minHealth(startRow + 1, startCol, health, dp);
            int minHealthToReachTarget = Math.min(a, b);
            dp[startRow][startCol] = Math.max(1, minHealthToReachTarget - healthImpact);
        }
        return dp[startRow][startCol];
    }
}
