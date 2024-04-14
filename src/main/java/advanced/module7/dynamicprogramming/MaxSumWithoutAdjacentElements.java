package advanced.module7.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Find maximum subsequence (may or may not be contiguous) sum from a given integer array of size N, where you cannot select adjacent elements.
 * More complex variation is discussed below.
 */
public class MaxSumWithoutAdjacentElements {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        a.add(list1);
        a.add(list2);
        int maxSum = adjacent(a);
        System.out.println("maxSum = " + maxSum);
    }


    /**
     * Without DP
     * Given a 2 x N grid of integers, A, your task is to choose numbers from the grid such that sum of these numbers is maximized.
     * However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally.
     * <p>
     * Return the maximum possible sum.
     * <p>
     * Note: You are allowed to choose more than 2 numbers from the grid.
     */
    public static int adjacent(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> array1 = A.get(0);
        ArrayList<Integer> array2 = A.get(1);

        ArrayList<Integer> maxArray = new ArrayList<>();
        for (int i = 0; i < array1.size(); i++) {
            maxArray.add(array1.get(i) > array2.get(i) ? array1.get(i) : array2.get(i));
        }
        int[] dp = new int[maxArray.size()];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return getMax(maxArray, 0, false, dp);
    }

    public static int getMax(ArrayList<Integer> maxArray, int currentIndex, boolean isPreviousChosen, int[] dp) {
        if (currentIndex == maxArray.size()) return 0;

        if (dp[currentIndex] != Integer.MIN_VALUE && !isPreviousChosen) {
            return dp[currentIndex];
        }
        int val = getMax(maxArray, currentIndex + 1, false, dp);
        int max = val;

        if (!isPreviousChosen) {
            max = Math.max(
                    maxArray.get(currentIndex) + getMax(maxArray, currentIndex + 1, true, dp),
                    val
            );
        }
        if (!isPreviousChosen) {
            dp[currentIndex] = max;
        }
        return max;
    }
}
