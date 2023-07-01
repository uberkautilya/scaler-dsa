package homeworks_experiments;

import java.util.Arrays;

public class RangeSumQuery {
    public static void main(String[] args) {
        int[] A = new int[]{2, 2, 2};
        int[][] B = new int[][]{{0, 0}, {1, 2}};
        System.out.println(Arrays.toString(rangeSum(A, B)));
    }


    public static long[] rangeSum(int[] A, int[][] B) {

        long[] pf = new long[A.length];
        pf[0] = A[0];
        //Calculate the prefix sum array
        for(int i=1; i<A.length; i++){
            pf[i] = A[i-1] + pf[i];
        }

        long[] sumArray = new long[B.length];
        //For each query, find sums of elements in the range and store it the above array
        for(int i=0; i < B.length; i++){
            //If the left range is not zero, sum of elements preceding the range is subtracted
            sumArray[i] = pf[ B[i][1] ];
            if( B[i][0] > 0 ){
                sumArray[i] = pf[ B[i][1] ] - pf[ B[i][0] - 1];
            }
        }

        return sumArray;
    }
}
