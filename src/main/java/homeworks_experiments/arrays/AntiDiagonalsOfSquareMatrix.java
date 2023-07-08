package homeworks_experiments.arrays;

public class AntiDiagonalsOfSquareMatrix {

    public static void main(String[] args) {
        int[][] ar = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printMatrix(diagonal(ar));
    }


    public static int[][] diagonal(int[][] A) {

        int N = A.length;
        int[][] antiDiagonals = new int[2 * N - 1][N];
        //No. of antidiagonals found at a point
        int count = 0;

        //Finding anti-diagonals that begin with the elements on the top row
        for (int col = 0; col < N; col++) {
            int c = col;
            for (int row = 0; row < N && c >= 0; row++) {
                antiDiagonals[count][row] = A[row][c--];
            }
            count++;
        }

        //Finding anti-diagonals that begin with the elements on the rightmost column
        for (int row = 1; row < N; row++) {
            int r = row;
            for (int col = N - 1; col >= 0 && r < N; col--) {
                antiDiagonals[count][N - 1 - col] = A[r++][col];
            }
            count++;
        }
        return antiDiagonals;

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
