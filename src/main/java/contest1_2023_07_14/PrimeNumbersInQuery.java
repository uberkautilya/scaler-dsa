package contest1_2023_07_14;

import java.util.Arrays;

public class PrimeNumbersInQuery {

    public static void main(String[] args) {
        int[] ar = new int[]{
                1, 5, 2, 5, 2
        };
        int[][] Q = new int[][]{
                {5, 5},
                {1, 3}
        };
/*
int[] ar = new int[]{
                2, 2, 3, 3, 1, 1, 7, 4
        };
        int[][] Q = new int[][]{
                {8,8},
                {1,8}
        };
*/

        System.out.println(Arrays.toString(solve(ar, Q)));
    }

    public static int[] solve(int[] A, int[][] B) {
        System.out.println(Arrays.toString(A));

        int[] result = new int[B.length];
        //Find carry forward of count of prime numbers
        for (int i = 0; i < A.length; i++) {
            //If element is 1
            if (A[i] == 1) {
                if (i == 0) {
                    A[0] = 0;
                    continue;
                }
                A[i] = A[i - 1] + 0;
                continue;
            }
            //If element is 2
            if (A[i] == 2) {
                if (i == 0) {
                    A[0] = 1;
                    continue;
                }
                A[i] = A[i - 1] + 1;
            }
            int flag = 0;
            for (int j = 2; j <= A[i] / j; j++) {
                if (A[i] % j == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                if (i == 0) {
                    A[0] = 1;
                    continue;
                }
                A[i] = A[i - 1] + 1;
            } else {
                if (i == 0) {
                    A[0] = 0;
                    continue;
                }
                A[i] = A[i - 1];
            }
        }
        System.out.println(Arrays.toString(A));

        //Finding for each query
        for (int i = 0; i < B.length; i++) {
            int startIndex = B[i][0] - 1;
            int endIndex = B[i][1] - 1;
            if (startIndex == 0) {
                result[i] = A[endIndex];
            } else {
                result[i] = A[endIndex] - A[startIndex - 1];
            }
        }
        return result;
    }
}


/**
 * public int[] solve(int[] A, int[][] B) {
 * <p>
 * int[] result = new int[B.length];
 * //Find carry forward of count of prime numbers
 * for(int i=0; i<A.length; i++){
 * //If element is 1
 * if(A[i] == 1){
 * if(i==0){
 * A[0] = 0;
 * continue;
 * }
 * A[i] = A[i-1];
 * continue;
 * }
 * //If element is 2
 * if(A[i] == 2){
 * if(i==0){
 * A[0] = 1;
 * continue;
 * }
 * A[i] = A[i-1] + 1;
 * continue;
 * }
 * int flag=0;
 * for(int j=2; j<=A[i]/j; j++){
 * if(A[i] % j == 0){
 * flag = 1;
 * break;
 * }
 * }
 * if(flag == 0){
 * if(i==0){
 * A[0] = 1;
 * continue;
 * }
 * A[i] = A[i-1] + 1;
 * } else {
 * if(i==0){
 * A[0] = 0;
 * continue;
 * }
 * A[i] = A[i-1];
 * }
 * }
 * <p>
 * //Finding for each query
 * for(int i=0; i<B.length; i++){
 * int startIndex = B[i][0] - 1;
 * int endIndex = B[i][1] - 1;
 * if(startIndex == 0){
 * result[i] = A[endIndex];
 * }else{
 * result[i] = A[endIndex] - A[startIndex - 1];
 * }
 * }
 * return result;
 * }
 */