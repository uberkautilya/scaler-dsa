package contest1_2023_07_14;

import java.util.Arrays;

public class PrimeNumbersInQuery {

    public static void main(String[] args) {
        int[] ar = new int[]{
                1, 2, 5, 8, 5, 2
        };
        int[][] Q = new int[][]{
                //The indices are 1 based, not zero indexed
                {5, 5},
                {1, 3}
        };
        System.out.println("No. of prime numbers in the index(1 indexed) range: \n" + Arrays.toString(solve(ar, Q)));
    }

    public static int[] solve(int[] A, int[][] B) {
        System.out.println("The original array: \n" + Arrays.toString(A));

        int[] result = new int[B.length];
        //Find carry forward of count of prime numbers
        for (int i = 0; i < A.length; i++) {
            boolean isPrime = checkForPrime(A[i]);
            //If the element is 1
            if (isPrime) {
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
        System.out.println("Cumulative no. of primes for each index: \n" + Arrays.toString(A));

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

    private static boolean checkForPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

/*
int[] ar = new int[]{
                2, 2, 3, 3, 1, 1, 7, 4
        };
        int[][] Q = new int[][]{
                {8,8},
                {1,8}
        };
*/

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