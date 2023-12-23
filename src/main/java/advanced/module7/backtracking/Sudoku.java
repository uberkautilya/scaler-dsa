package advanced.module7.backtracking;

import java.util.HashMap;
import java.util.HashSet;

public class Sudoku {
    public static void main(String[] args) {
        int[][] mat = new int[9][9];
        mat[0] = new int[]{0, 3, 0, 0, 2, 9, 8, 6, 0};
        mat[1] = new int[]{0, 0, 0, 0, 0, 5, 0, 0, 0};
        mat[2] = new int[]{7, 0, 0, 0, 0, 0, 3, 0, 0};
        mat[3] = new int[]{0, 0, 4, 0, 0, 0, 0, 0, 1};
        mat[4] = new int[]{0, 0, 0, 8, 0, 0, 0, 0, 0};
        mat[5] = new int[]{0, 7, 0, 0, 6, 3, 0, 9, 0};
        mat[6] = new int[]{0, 2, 0, 5, 0, 0, 0, 0, 0};
        mat[7] = new int[]{1, 0, 0, 0, 8, 2, 0, 0, 9};
        mat[8] = new int[]{0, 0, 0, 7, 0, 0, 0, 8, 0};
        sudoku(mat, 0, null);
    }

    static void sudoku(int[][] mat, int i, HashMap<Integer, HashSet<Integer>> validityMap) {
        if (null == validityMap) {
            validityMap = makeValidityMap(mat);
        }
        //If the last cell's i value is exceeded, indicates that all cells are successfully filled
        if (i == 81) {
            printMatrix(mat);
            return;
        }

        //Using i, find the row and column
        int row = i / 9;
        int column = i % 9;
        if (mat[row][column] != 0) {
            //Data already present in the cell. Move to the next cell
            sudoku(mat, i + 1, validityMap);
        } else {
            //Fill a value in the current cell and recurse to next cell
            for (int val = 1; val <= 9; val++) {
                if (isValid(row, column, val, validityMap)) {
                    //Explore the solution with each value, see if it can reach the end point
                    mat[row][column] = val;
                    addElementToValidityMap(mat, validityMap, row, column);
                    //Recurse with the next cell
                    sudoku(mat, i + 1, validityMap);
                    //Backtrack, if the above lead to a dead end - couldn't fill all values
                    removeFromValidityMap(mat, validityMap, row, column);
                    mat[row][column] = 0;
                }
            }
        }
    }

    private static boolean isValid(int row, int column, int val,
                                   HashMap<Integer, HashSet<Integer>> valueMap) {
        int miniCount = getMiniCount(row, column);
        return !valueMap.get(row).contains(val) &&
                !valueMap.get(9 + column).contains(val) &&
                !valueMap.get(18 + miniCount).contains(val);
    }

    private static HashMap<Integer, HashSet<Integer>> makeValidityMap(int[][] mat) {
        HashMap<Integer, HashSet<Integer>> validityMap = new HashMap<>();
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[r].length; c++) {
                addElementToValidityMap(mat, validityMap, r, c);
            }
        }
        return validityMap;
    }

    private static void addElementToValidityMap(int[][] mat, HashMap<Integer, HashSet<Integer>> validityMap, int r, int c) {
        //Holds all elements in the row r, index starts at 0
        addToValidityMap(mat, validityMap, r, c, r);
        //Holds all elements in the column c, index starts from 9
        addToValidityMap(mat, validityMap, r, c, 9 + c);
        int miniCount = getMiniCount(r, c);
        //Holds all elements in the miniMatrix, index starts from 18
        addToValidityMap(mat, validityMap, r, c, 18 + miniCount);
    }

    private static void addToValidityMap(int[][] mat, HashMap<Integer, HashSet<Integer>> validityMap, int r, int c, int index) {
        HashSet<Integer> values = validityMap.get(index);
        if (values != null) {
            values.add(mat[r][c]);
        } else {
            HashSet<Integer> set = new HashSet<>();
            set.add(mat[r][c]);
            validityMap.put(index, set);
        }
    }

    private static void removeFromValidityMap(int[][] mat, HashMap<Integer, HashSet<Integer>> validityMap, int r, int c) {
        //Remove from row set
        HashSet<Integer> rowElements = validityMap.get(r);
        if (rowElements != null) {
            rowElements.remove(mat[r][c]);
        }
        //Remove from column set, index in validityMap starts at 9
        HashSet<Integer> columnElements = validityMap.get(9 + c);
        if (columnElements != null) {
            columnElements.remove(mat[r][c]);
        }
        //Remove from miniMatrix set, index in validityMap starts at 18
        int miniCount = getMiniCount(r, c);
        HashSet<Integer> miniMatrixElements = validityMap.get(18 + miniCount);
        if (miniMatrixElements != null) {
            miniMatrixElements.remove(mat[r][c]);
        }
    }

    private static int getMiniCount(int r, int c) {
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

    private static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int cell : row) {
                System.out.print(" " + cell);
            }
            System.out.println();
        }
    }
}
