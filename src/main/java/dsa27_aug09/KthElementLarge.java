package dsa27_aug09;

import java.util.ArrayList;
import java.util.List;

/**
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 * <p>
 * Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).
 * Problem Constraints
 * 1 <= A <= 100_000
 * 0 <= B <= min(2^(A - 1) - 1 , 10^18)
 */
public class KthElementLarge {

    /**
     * Not the right approach. Bisect the array and merge after processing - try this
     *
     * @param args
     */
    public static void main(String[] args) {
        KthElementLarge kthElementLarge = new KthElementLarge();
        int result = kthElementLarge.solve(4, 4);
        System.out.println("result = " + result);
    }

    /*
    0
    01
    01 10
    01 10 10 01
    01 10 10 01 10 01 01 10
    01 10 10 01 10 01 01 10 | 10 01 01 10 01 10 10 01
    */
    public int solve(int A, long B) {
        if (A == 1 && B == 1) return 0;
        ArrayList<Integer> seedList = new ArrayList<>();
        seedList.add(0);
        seedList.add(1);
        if (A == 2) return seedList.get((int) B);
        return findElement(seedList, 1, A, B);
    }

    public Integer findElement(ArrayList<Integer> list, Integer row, Integer rowLimit, long B) {
        long countRemaining = B - list.size();
        for (int r = row; r < rowLimit; r++) {
            //Bisect the array and add second half first.
            List<Integer> firstHalf = list.subList(0, list.size() / 2);
            List<Integer> secondHalf = list.subList(list.size() / 2, list.size());
            list.addAll(secondHalf);
            countRemaining -= secondHalf.size();
            if (countRemaining <= 0) {
                return secondHalf.get((int) countRemaining);
            }
            list.addAll(firstHalf);
            countRemaining -= firstHalf.size();
            if (countRemaining <= 0) {
                return firstHalf.get((int) countRemaining);
            }
        }
        return 0;
    }
}
