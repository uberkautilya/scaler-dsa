package advanced.module7.dynamicprogramming;

import java.util.ArrayList;

public class MaxSumWithoutAdjacentElements {
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
        int max1 = getMax(maxArray, maxArray.size() - 1, false);
        int max2 = getMax(maxArray, maxArray.size() - 1, true);

        return Math.max(max1, max2);
    }

    public static int getMax(ArrayList<Integer> maxArray, int currentIndex, boolean isCurrentChosen) {
        if (currentIndex < 0) return 0;
        if (isCurrentChosen) {
            return maxArray.get(currentIndex) +
                    getMax(maxArray, currentIndex - 1, false);
        } else {
            return Math.max(
                    getMax(maxArray, currentIndex - 1, true),
                    getMax(maxArray, currentIndex - 1, false)
            );
        }
    }
}
