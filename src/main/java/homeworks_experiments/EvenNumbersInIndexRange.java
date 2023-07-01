package homeworks_experiments;

import java.util.Arrays;

public class EvenNumbersInIndexRange {

    public static void main(String[] args) {
        int[] solution = solve(new int[]{1, 2, 3, 4, 5}, new int[][]{ {0, 2}, {2, 4}, {1, 4} });
        System.out.println(Arrays.toString(solution));
    }

    public static int[] solve(int[] A, int[][] B) {
        A[0] = A[0] % 2 == 0 ? 1 : 0;

        for (int i = 1; i < A.length; i++) {
            //If the number at ith index is even, number of even numbers till this index is incremented
            if (A[i] % 2 == 0) {
                A[i] = A[i - 1] + 1;
            } else {
                A[i] = A[i - 1];
            }
        }
        int[] evenNumberInBthArray = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            //If the left index is 0, even numbers in the index range is cumulative even numbers till the right index
            evenNumberInBthArray[i] = A[B[i][1]];
            if(B[i][0] > 0){
                evenNumberInBthArray[i] = A[B[i][1]] - A[B[i][0] - 1];
            }
        }
        return evenNumberInBthArray;
    }

}
