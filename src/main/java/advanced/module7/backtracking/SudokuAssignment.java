package advanced.module7.backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SudokuAssignment {
    public static void main(String[] args) {
        String[] str = new String[]{"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
        char[][] mat = new char[9][9];
        int k = 0;
        for (String s : str) {
            mat[k] = s.toCharArray();
            k++;
        }
        new SudokuAssignment().solveSudoku(mat);
        for (char[] chars : mat) {
            System.out.println(Arrays.toString(chars));
        }
    }

    public void solveSudoku(char[][] A) {
        char[][] solutionMatrix = new char[9][9];
        sudoku(A, 0, solutionMatrix);

        //Copy the solution matrix formed into the original matrix.
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = solutionMatrix[i][j];
            }
        }
    }

    void sudoku(char[][] mat, int index, char[][] solutionMatrix) {
        //Base condition: If the last cell is filled, solution is identified
        if (index == 81) {

            //Assign the mat values as the solution identified.
            for (int row = 0; row < mat.length; row++) {
                for (int col = 0; col < mat[row].length; col++) {
                    solutionMatrix[row][col] = mat[row][col];
                }
            }
            return;
        }
        //Using index, find the row and col
        int row = index / 9;
        int col = index % 9;
        if (mat[row][col] != '.') {
            //Represents a cell already filled from the question. Move to the next cell
            sudoku(mat, index + 1, solutionMatrix);
        } else {
            //Fill a value in the current cell and recurse to next cell
            for (char value = '1'; value <= '9'; value++) {
                if (isValid(mat, row, col, value)) {
                    //Explore the solution with each value, see if it can reach the end point
                    mat[row][col] = value;
                    sudoku(mat, index + 1, solutionMatrix);

                    //Backtrack, if the above resulted in a dead end - couldn't fill all values
                    mat[row][col] = '.';
                }
            }
        }
    }

    boolean isValid(char[][] mat, int row, int column, char val) {
        HashMap<Integer, HashSet<Character>> valueMap = new HashMap<>();

        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[r].length; c++) {
                if (mat[r][c] == '.') {
                    continue;
                }
                //Holds all elements in the row r
                valueMap.putIfAbsent(r, new HashSet<>());
                HashSet<Character> values = valueMap.get(r);
                values.add(mat[r][c]);

                //Holds all elements in the column c
                valueMap.putIfAbsent(9 + c, new HashSet<>());
                HashSet<Character> colVals = valueMap.get(9 + c);
                colVals.add(mat[r][c]);

                //Holds all elements in the miniMatrix
                int miniCount = getMiniSquareCount(r, c);
                valueMap.putIfAbsent(18 + miniCount, new HashSet<>());
                HashSet<Character> miniVals = valueMap.get(18 + miniCount);
                miniVals.add(mat[r][c]);
            }
        }
        int miniCount = getMiniSquareCount(row, column);
        return !valueMap.get(row).contains(val) &&
                !valueMap.get(9 + column).contains(val) &&
                !valueMap.get(18 + miniCount).contains(val);
    }


    int getMiniSquareCount(int row, int col) {
        int miniCount = Integer.MIN_VALUE;
        int rowIndex = row / 3;
        int columnIndex = col / 3;

        if (rowIndex == 2 && columnIndex == 2) {
            miniCount = 8;
        } else if (rowIndex == 2 && columnIndex == 1) {
            miniCount = 7;
        } else if (rowIndex == 2 && columnIndex == 0) {
            miniCount = 6;
        } else if (rowIndex == 1 && columnIndex == 2) {
            miniCount = 5;
        } else if (rowIndex == 1 && columnIndex == 1) {
            miniCount = 4;
        } else if (rowIndex == 1 && columnIndex == 0) {
            miniCount = 3;
        } else if (rowIndex == 0 && columnIndex == 2) {
            miniCount = 2;
        } else if (rowIndex == 0 && columnIndex == 1) {
            miniCount = 1;
        } else if (rowIndex == 0 && columnIndex == 0) {
            miniCount = 0;
        }
        return miniCount;
    }
}
