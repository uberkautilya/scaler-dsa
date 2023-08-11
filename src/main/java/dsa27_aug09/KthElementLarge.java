package dsa27_aug09;

import java.util.ArrayList;

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
     * @param args
     */
    public static void main(String[] args) {
        KthElementLarge kthElementLarge = new KthElementLarge();
        int result = kthElementLarge.solve(4, 4);
        System.out.println("result = " + result);
    }

    public int solve(int A, long B) {
        /*
        0
        01
        01 10
        01 10 10 01
        01 10 10 01 10 01 01 10
        */
        if (A == 1 && B == 0L) return 0;
        ArrayList<Integer> list = new ArrayList<Integer>() {
            {
                add(0);
            }
        };
        return recurse(list, A - 1, B);

    }

    public Integer recurse(ArrayList<Integer> list, Integer row, Long index) {

        long count = -1L;

        ArrayList<Integer> newList = new ArrayList<>();
        for (Integer val : list) {
            if (val == 0) {
                newList.add(0);
                if (index.equals(++count)) return 0;
                newList.add(1);
                if (index.equals(++count)) return 1;
            } else {
                newList.add(1);
                if (index.equals(++count)) return 1;
                newList.add(0);
                if (index.equals(++count)) return 0;
            }
        }
        return recurse(newList, row - 1, index);
    }
}
