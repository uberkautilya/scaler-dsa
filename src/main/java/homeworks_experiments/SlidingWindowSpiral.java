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
        return mat;
    }
}
