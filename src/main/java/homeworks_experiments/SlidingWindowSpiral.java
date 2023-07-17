package homeworks_experiments;

import java.util.Arrays;

public class SlidingWindowSpiral {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(11)));
    }

    public static int[][] generateMatrix(int A) {
        int[][] mat = new int[A][A];
        int i = 0;
        int j = 0;
        int num = 1;
        int N = A;

        while (N > 1) {
            for (int k = 1; k < N; k++) {
                mat[i][j] = num++;
                j++;
            }
            for (int k = 1; k < N; k++) {
                mat[i][j] = num++;
                i++;
            }
            for (int k = 1; k < N; k++) {
                mat[i][j] = num++;
                j--;
            }
            for (int k = 1; k < N; k++) {
                mat[i][j] = num++;
                i--;
            }
            N -= 2;
            i++;
            j++;
        }
        if (N == 1) {
            mat[i][j] = num++;
        }
        printMatrix(mat);
        return mat;
    }

    public static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.printf("%4d ", mat[i][j]);
            }
            System.out.println("\n");
        }
    }
}
