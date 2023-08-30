package intermediate.dsa23_july31;

import java.util.Arrays;

public class SortIntegerArray {
    public static void main(String[] args) {

        int[] solve = new SortIntegerArray().solve(new int[]{10, 9, 8});
//        int[] solve = new SortIntegerArray().solve(new int[]{2, 4, 2, 1, 7, 3});
        System.out.println("solve = " + Arrays.toString(solve));
    }

    public int[] solve(int[] A) {
        int[] freqArray = new int[100_001];

        for (int a : A) {
            freqArray[a] = freqArray[a] + 1;
        }
        int count = 0;
        for (int i = 1; i < freqArray.length; i++) {
            while (freqArray[i] > 0) {
                A[count++] = i;
                freqArray[i]--;
            }
        }
        return A;
    }
}
