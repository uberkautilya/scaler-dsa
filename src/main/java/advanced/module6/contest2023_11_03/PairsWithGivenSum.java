package advanced.module6.contest2023_11_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairsWithGivenSum {
    public static void main(String[] args) {
        PairsWithGivenSum pairsWithGivenSum = new PairsWithGivenSum();
        List<Integer> list = Arrays.asList(2, 3, 3, 5, 7, 8, 9, 9, 10, 10);
        list = Arrays.asList(4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666);
        int result = pairsWithGivenSum.solve(new ArrayList<>(list), 9259332);
        System.out.println("result = " + result);

    }

    public int solve(ArrayList<Integer> A, int B) {
        final int mod = 1000_000_007;
        long count = 0;
        int size = A.size();
        A.sort((a, b) -> a - b);
        int i = 0, j = size - 1;

        while (i < j) {
            if (A.get(i) + A.get(j) == B) {
                if (A.get(i).equals(A.get(j))) {
                    long c = j - i + 1;
                    count = (count % mod + (c * (c - 1) / 2) % mod) % mod;
                    return (int) count;
                }
                int startI = i;
                while (i < j && A.get(i) == A.get(i + 1)) {
                    i++;
                }
                int startJ = j;
                while (i < j && A.get(j) == A.get(j - 1)) {
                    j--;
                }
                long countI = i - startI + 1;
                long countJ = startJ - j + 1;
                count = (count % mod + (countI * countJ) % mod) % mod;
            } else if (A.get(i) + A.get(j) < B) {
                i++;
            } else {
                j--;
            }
        }
        return (int) count;
    }
}
