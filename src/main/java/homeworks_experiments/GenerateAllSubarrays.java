package homeworks_experiments;

import java.util.Arrays;

public class GenerateAllSubarrays {

    public static void main(String[] args) {
        int[][] allSubArrays = solve(new int[]{5, 2, 1, 4});
        System.out.println(Arrays.deepToString(allSubArrays));
    }

    public static int[][] solve(int[] A) {
        int l = A.length;
        int[][] subArrays = new int[l * (l + 1) / 2][];
        int count = 0;

        for (int i = 0; i < A.length; i++) {

            for (int j = i; j < A.length; j++) {

                int[] ithSubArray = getSubArray(A, i, j);
                subArrays[count++] = ithSubArray;
            }
        }
        return subArrays;
    }

    public static int[] getSubArray(int[] A, int startIndex, int endIndex) {
        int[] subArray = new int[endIndex - startIndex + 1];

        for (int i = startIndex; i <= endIndex; i++) {
            subArray[i - startIndex] = A[i];
        }
        return subArray;
    }
}
