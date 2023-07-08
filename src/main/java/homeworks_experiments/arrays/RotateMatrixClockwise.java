package homeworks_experiments.arrays;

public class RotateMatrixClockwise {

    public static void main(String[] args) {
        int[][] A = new int[][]{
                {1, 2},
                {3, 4}
        };
        solve(A);
        printMatrix(A);
    }

    public static void solve(int[][] A) {
        //This is a N*N matrix
        //To rotate a matrix clockwise by 90 degrees, first need to get the transpose matrix, then flip it horizontally

        //Taking the transpose of the matrix
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        for (int col = 0; col < (A.length / 2); col++) {
            for (int row = 0; row < A.length; row++) {

                int temp = A[row][col];
                A[row][col] = A[row][A.length - 1 - col];
                A[row][A.length - 1 - col] = temp;
            }
        }
    }

    public static void printMatrix(int[][] A) {

        System.out.println("---------------------------------------");
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
    }
}
