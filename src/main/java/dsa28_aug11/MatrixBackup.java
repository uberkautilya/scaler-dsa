package dsa28_aug11;

import java.util.Scanner;

public class MatrixBackup {
    // Define properties here
    int rowCount;
    int columnCount;
    int[][] matrix;


    // Define constructor here
    public MatrixBackup(int r, int c) {
        this.rowCount = r;
        this.columnCount = c;
        this.matrix = new int[rowCount][columnCount];
    }


    void input(Scanner sc) {
        // Use the Scanner object passed as argument for taking input and not a new Scanner object
        // Complete the function
        int rCount = 0;
        while (rCount++ < rowCount) {
            String row = sc.nextLine();
            String[] numArray = row.split(" ");
            int cCount = 0;
            for (String num : numArray) {
                matrix[rCount][cCount] = Integer.parseInt(num);
                cCount++;
            }
        }
    }

    MatrixBackup add(MatrixBackup x) {
        // Complete the function
        int[][] sumArray = x.matrix;
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < columnCount; c++) {
                sumArray[r][c] = matrix[r][c] + sumArray[r][c];
            }
        }
        return x;
    }

    MatrixBackup subtract(MatrixBackup x) {
        // Complete the function
        int[][] diffArray = x.matrix;
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < columnCount; c++) {
                diffArray[r][c] = matrix[r][c] - diffArray[r][c];
            }
        }
        return x;
    }

    MatrixBackup transpose() {
        // Complete the function
        for (int i = 0; i < rowCount; i++) {
            for (int j = i; j < columnCount; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return this;
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