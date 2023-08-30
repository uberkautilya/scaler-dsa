package advanced.dsa32_aug28;

import java.util.Arrays;

public class ContinuousSumQuery {
    public static void main(String[] args) {
        ContinuousSumQuery continuousSumQuery = new ContinuousSumQuery();

        int[][] B = new int[][]{
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25}
        };
        int[] result = continuousSumQuery.solve(5, B);
        System.out.println("result = " + Arrays.toString(result));

    }

    public int[] solve(int A, int[][] B) {
        int[] result = new int[A];

        for (int[] contribution : B) {
            int startIndex = contribution[0];
            int endIndex = contribution[1];
            int amount = contribution[2];
            //Indexing starts at 0
            result[startIndex - 1] += amount;
            //Resetting from endIndex + 1
            if (endIndex < A) result[endIndex] -= amount;
        }

        int val = 0;
        for (int i = 0; i < A; i++) {
            val += result[i];
            result[i] = val;
        }
        return result;
    }
}
