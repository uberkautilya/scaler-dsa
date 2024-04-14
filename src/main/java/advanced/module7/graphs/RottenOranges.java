package advanced.module7.graphs;

import java.util.LinkedList;

/**
 * Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
 * Each cell can have three values:
 * The value 0 representing an empty cell.
 * The value 1 representing a fresh orange.
 * The value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1 instead.
 */
public class RottenOranges {
    public static void main(String[] args) {
        int turns = solve(new int[][]{
                {2, 0, 2, 2, 2, 0, 2, 1, 1, 0},
                {0, 1, 2, 0, 2, 0, 0, 1, 0, 1},
                {0, 1, 1, 1, 2, 0, 1, 1, 2, 1},
                {2, 0, 2, 0, 1, 1, 2, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 2, 0, 2, 2},
                {0, 2, 1, 1, 2, 2, 0, 2, 1, 2},
                {2, 1, 0, 2, 0, 0, 0, 0, 1, 1},
                {2, 2, 0, 2, 2, 1, 1, 1, 2, 2}
        });
        System.out.println("turns = " + turns);
    }

    public static int solve(int[][] A) {
        LinkedList<int[]> rottenOrangeLocations = new LinkedList<>();
        int freshOrangeCount = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    freshOrangeCount++;
                } else if (A[i][j] == 2) {
                    rottenOrangeLocations.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = new int[][]{
                {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };

        int turns = 0;
        while (!rottenOrangeLocations.isEmpty()) {
            LinkedList<int[]> newLocations = new LinkedList<>();
            for (int[] c_node : rottenOrangeLocations) {
                for (int[] dir : dirs) {
                    int n_r = c_node[0] + dir[0];
                    int n_c = c_node[1] + dir[1];
                    if (isValid(n_r, n_c, A)) {
                        freshOrangeCount--;
                        // Mark this location as having a rotten orange
                        A[n_r][n_c] = 2;
                        newLocations.offer(new int[]{n_r, n_c});
                    }
                }
            }
            rottenOrangeLocations = newLocations;
            turns++;
            if (freshOrangeCount == 0) {
                return turns;
            }
        }
        // If the rottenOrangeLocations is empty, but fresh oranges count is positive, return -1;
        return -1;
    }

    private static boolean isValid(int rowIndex, int columnIndex, int[][] matrix) {
        if (null == matrix) {
            return false;
        }
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        return rowIndex >= 0 && columnIndex >= 0 &&
                rowIndex < rowLength && columnIndex < columnLength &&
                matrix[rowIndex][columnIndex] == 1;
    }
}
