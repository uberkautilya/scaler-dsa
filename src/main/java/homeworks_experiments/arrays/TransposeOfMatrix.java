package homeworks_experiments.arrays;

import java.util.Arrays;

public class TransposeOfMatrix {

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {1, 2},
                {4, 5},
                {7, 8}
        };
        int[][] result = solve(arr);
        System.out.println(Arrays.deepToString(result));
    }


    public static int[][] solve(int[][] A) {

        int[][] transposeArray = new int[A[0].length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                transposeArray[j][i] = A[i][j];
            }
        }
        return transposeArray;
    }

}
