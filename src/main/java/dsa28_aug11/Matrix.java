package dsa28_aug11;

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
        while (rCount++ < rowCount) {
            String row = sc.nextLine();
            String[] numArray = row.split(" ");
            int cCount = 0;
            for (String num : numArray) {
                matrix[rCount][cCount] = Integer.valueOf(num);
                cCount++;
            }
        }
    }

    Matrix add(Matrix x) {
        // Complete the function
        int[][] sumArray = x.matrix;
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < columnCount; c++) {
                sumArray[r][c] = matrix[r][c] + sumArray[r][c];
            }
        }
        return x;
    }

    Matrix subtract(Matrix x) {
        // Complete the function
        int[][] diffArray = x.matrix;
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < columnCount; c++) {
                diffArray[r][c] = matrix[r][c] - diffArray[r][c];
            }
        }
        return x;
    }

    Matrix transpose() {
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
