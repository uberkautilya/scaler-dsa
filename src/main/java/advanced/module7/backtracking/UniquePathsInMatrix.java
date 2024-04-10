package advanced.module7.backtracking;

import java.util.Arrays;

/**
 * At each non-blocked cells, we have 4 options - up, right, left and down
 * N x M -2 such cells at max is possible, (barring the starting and ending cell)
 * T.C. = O( 4^(NxM) )
 * S.C. = Recursion Stack = O(NxM)
 */
public class UniquePathsInMatrix {

    static int validPathCount = 0;
    static int[] x = new int[]{1, -1, 0, 0};
    static int[] y = new int[]{0, 0, 1, -1};

    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        int N = A.length;
        int M = A[0].length;

        int countOfValidPaths = findCountOfValidPaths(N, M, A);
        System.out.println("\n\ncountOfValidPaths = " + countOfValidPaths);
    }

    private static int findCountOfValidPaths(int N, int M, int[][] A) {
        int startPosI = -1, startPosJ = -1;
        int unvisitedCellCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 1) {
                    startPosI = i;
                    startPosJ = j;
                } else if (A[i][j] == 0) {
                    unvisitedCellCount++;
                }
            }
        }
        if (startPosI == -1) {
            //There is no start cell in the array provided
            return -1;
        }
        validPathCount = 0;
        // unvisitedCount is incremented here as in the findValidPath method, we reduce its value by 1.
        // However, at the start cell, this is to be compensated.
        recursePaths(startPosI, startPosJ, unvisitedCellCount + 1, A);
        return validPathCount;
    }

    private static void recursePaths(int rowIndex, int columnIndex, int unvisitedCellCount, int[][] A) {
        if (A[rowIndex][columnIndex] == 2) {
            System.out.println("Destination reached");
            //Reached the destination cell
            if (unvisitedCellCount == 0) {
                validPathCount++;
            }
            return;
        }
        // Current recursion stack can't move into this cell - mark as visited
        A[rowIndex][columnIndex] = -1;

        System.out.println("\nunvisitedCellCount = " + unvisitedCellCount);
        for (int i = 0; i < 4; i++) {
            int u = rowIndex + x[i];
            int v = columnIndex + y[i];

            if (isValid(u, v, A)) {
                System.out.println("unvisitedCellCount = " + unvisitedCellCount);
                System.out.println(Arrays.deepToString(A));
                recursePaths(u, v, unvisitedCellCount - 1, A);
            }
        }
    }

    private static boolean isValid(int i, int j, int[][] A) {
        return (0 <= i) && (0 <= j) &&
                (i < A.length) && (j < A[0].length) &&
                (A[i][j] != -1);
    }
}
