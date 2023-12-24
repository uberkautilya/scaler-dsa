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
        char[][] ans = new char[9][9];
        sudoku(A, 0, ans);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = ans[i][j];
            }
        }
    }

    void sudoku(char[][] mat, int i, char[][] ans) {
        //If the last cell's ith value is exceeded, this implies all cells are filled successfully
        if (i == 81) {
            for (int j = 0; j < mat.length; j++) {
                for (int k = 0; k < mat[j].length; k++) {
                    ans[j][k] = mat[j][k];
                }
            }
            return;
        }
        //Using i, find the row and column
        int row = i / 9;
        int column = i % 9;
        if (mat[row][column] != '.') {
            //Data already present in the cell. Move to the next cell
            sudoku(mat, i + 1, ans);
        } else {
            //Fill a value in the current cell and recurse to next cell
            for (char val = '1'; val <= '9'; val++) {
                if (isValid(mat, row, column, val)) {
                    //Explore the solution with each value, see if it can reach the end point
                    mat[row][column] = val;
                    //Recurse with the next cell
                    sudoku(mat, i + 1, ans);
                    //Backtrack, if the above lead to a dead end - couldn't fill all values
                    mat[row][column] = '.';
                }
            }
        }
    }

    boolean isValid(char[][] mat, int row, int column, char val) {
        HashMap<Integer, HashSet<Character>> valueMap = new HashMap<>();
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[r].length; c++) {
                //Holds all elements in the row r
                HashSet<Character> values = valueMap.get(r);
                if (values != null) {
                    values.add(mat[r][c]);
                } else {
                    HashSet<Character> set = new HashSet<>();
                    set.add(mat[r][c]);
                    valueMap.put(r, set);
                }
                //Holds all elements in the column c
                HashSet<Character> colVals = valueMap.get(9 + c);
                if (colVals != null) {
                    colVals.add(mat[r][c]);
                } else {
                    HashSet<Character> set = new HashSet<>();
                    set.add(mat[r][c]);
                    valueMap.put(9 + c, set);
                }
                //Holds all elements in the miniMatrix
                int miniCount = getMiniCount(r, c);
                HashSet<Character> miniVals = valueMap.get(18 + miniCount);
                if (miniVals != null) {
                    miniVals.add(mat[r][c]);
                } else {
                    HashSet<Character> set = new HashSet<>();
                    set.add(mat[r][c]);
                    valueMap.put(18 + miniCount, set);
                }
            }
        }
        int miniCount = getMiniCount(row, column);
        return !valueMap.get(row).contains(val) &&
                !valueMap.get(9 + column).contains(val) &&
                !valueMap.get(18 + miniCount).contains(val);
    }


    int getMiniCount(int r, int c) {
        int miniCount = Integer.MIN_VALUE;
        if (r / 3 == 2 && c / 3 == 2) {
            miniCount = 8;
        } else if (r / 3 == 2 && c / 3 == 1) {
            miniCount = 7;
        } else if (r / 3 == 2 && c / 3 == 0) {
            miniCount = 6;
        } else if (r / 3 == 1 && c / 3 == 2) {
            miniCount = 5;
        } else if (r / 3 == 1 && c / 3 == 1) {
            miniCount = 4;
        } else if (r / 3 == 1 && c / 3 == 0) {
            miniCount = 3;
        } else if (r / 3 == 0 && c / 3 == 2) {
            miniCount = 2;
        } else if (r / 3 == 0 && c / 3 == 1) {
            miniCount = 1;
        } else if (r / 3 == 0 && c / 3 == 0) {
            miniCount = 0;
        }
        return miniCount;
    }
}
