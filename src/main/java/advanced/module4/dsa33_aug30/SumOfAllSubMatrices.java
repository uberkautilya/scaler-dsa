package advanced.module4.dsa33_aug30;

public class SumOfAllSubMatrices {
    public static void main(String[] args) {
        SumOfAllSubMatrices obj = new SumOfAllSubMatrices();
        obj.solve(new int[][]{
                {1, 2},
                {1, 3}
        });
    }

    public int solve(int[][] A) {
        int rowCount = A.length;
        if (rowCount == 0) return 0;
        int columnCount = A[0].length;
        int sum = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                //Contribution technique is employed.
                // An element at index i, j occurs (i + 1) * (j + 1) * (rowCount - i) * (columnCount - j) times
                sum += A[i][j] * (i + 1) * (j + 1) * (rowCount - i) * (columnCount - j);
            }
        }
        return sum;
    }
}
