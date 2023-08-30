package intermediate.dsa28_aug11;

import java.util.Scanner;

public class Matrix {
    // Define properties here
    int rowCount;
    int columnCount;
    int[][] matrix;


    // Define constructor here
    public Matrix(int r, int c) {
        this.rowCount = r;
        this.columnCount = c;
        this.matrix = new int[rowCount][columnCount];
    }


    void input(Scanner sc) {
        // Use the Scanner object passed as argument for taking input and not a new Scanner object
        // Complete the function
        int rCount = 0;
        int cCount = 0;

        while (rCount < rowCount) {
            int num = sc.nextInt();
            matrix[rCount][cCount++] = num;
            if(cCount == columnCount){
                cCount = 0;
                rCount++;
            }
        }
    }

    Matrix add(Matrix x) {
        // Complete the function
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < columnCount; c++) {
                x.matrix[r][c] = matrix[r][c] + x.matrix[r][c];
            }
        }
        return x;
    }

    Matrix subtract(Matrix x) {
        // Complete the function
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < columnCount; c++) {
                x.matrix[r][c] = matrix[r][c] - x.matrix[r][c];
            }
        }
        return x;
    }

    Matrix transpose() {
        // Complete the function
        Matrix transpose = new Matrix(columnCount, rowCount);
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                transpose.matrix[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    void print() {
        // Complete the function
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
5
----------------------------
4
1
--
3
3
6
7
--
8
7
3
7
----------------------------
3
5
--
9 8 7 7 6
6 3 1 5 7
5 2 1 7 5
--
8 8 6 7 10
3 10 10 3 10
9 1 1 6 6
----------------------------
2
2
6 4
9 5
6 1
9 1
-------------------
4
1
--
2
2
7
1
--
3
7
5
2
--------------------------
4
3
--
5 9 1
3 3 2
2 5 4
1 7 1
--
2 9 5
8 6 10
2 9 9
4 5 10
 */