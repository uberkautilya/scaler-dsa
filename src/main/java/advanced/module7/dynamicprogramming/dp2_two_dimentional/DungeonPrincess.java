package advanced.module7.dynamicprogramming.dp2_two_dimentional;

import java.util.Arrays;

public class DungeonPrincess {
    public static void main(String[] args) {
        int[][] health = {{1, 2, 3, 4, 5}, {2, 3, 4, 5, 6}, {3, 4, 5, 6, 7}, {4, 5, 6, 7, 8}, {5, 6, 7, 8, -9}};
        int[][] dp = new int[5][5];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        int minHealthRequired = minHealth(0, 0, health, dp);
        System.out.println("minHealthRequired = " + minHealthRequired);
    }
    static int minHealth(int row, int col, int[][] health, int[][] dp) {
        int N = health.length;
        int M = health[0].length;
        if (row >= N || col >= M) {
            return Integer.MAX_VALUE;
        }
        if (row == N - 1 && col == M - 1) {
            return Math.max(1, 1 - health[N - 1][M - 1]);
        }
        if (dp[row][col] == -1) {
            int a = minHealth(row, col + 1, health, dp);
            int b = minHealth(row + 1, col, health, dp);
            int minHealthToReachCellEntry = Math.min(a, b);
            dp[row][col] = Math.max(1, minHealthToReachCellEntry);
        }
        return dp[row][col];
    }
}
