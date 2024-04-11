package advanced.module7.dynamicprogramming.dp2_two_dimentional;

import java.util.ArrayList;

/**
 * Find maximum subsequence (may or may not be contiguous) sum from a given integer array of size N, where you cannot select adjacent elements.
 * More complex variation is discussed below.
 */
public class MaxSumWithoutAdjacentElementsWithDP {
    public static void main(String[] args) {

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
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> array1 = A.get(0);
        ArrayList<Integer> array2 = A.get(1);

        ArrayList<Integer> maxArray = new ArrayList<>();
        for (int i = 0; i < array1.size(); i++) {
            maxArray.add(array1.get(i) > array2.get(i) ? array1.get(i) : array2.get(i));
        }
        return findBestWay(maxArray);
    }

    public static int findBestWay(ArrayList<Integer> maxArray) {
        int max1 = getMax(maxArray, maxArray.size() - 1, false, 0);
        int max2 = getMax(maxArray, maxArray.size() - 1, false, 0);

        return Math.max(max1, max2);
    }
    static int ans = 0;
    public static int getMax(ArrayList<Integer> maxArray, int currentIndex, boolean isLastChosen, int sum) {
        if (currentIndex < 0) {
            ans = Math.max(ans, sum);
        }
        if (isLastChosen) {
            return maxArray.get(currentIndex) +
                    getMax(maxArray, currentIndex - 1, true, sum);
        } else {
            return Math.max(
                    getMax(maxArray, currentIndex - 1, true, sum),
                    getMax(maxArray, currentIndex - 1, false, sum)
            );
        }
    }
}
