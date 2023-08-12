package dsa27_aug09;

import java.util.ArrayList;
import java.util.Objects;

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
        int result = kthElementLarge.solve(277, 887);
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
        if (A == 1 && B == 0) return 0;
        ArrayList<Integer> seedList = new ArrayList<>();
        seedList.add(0);
        seedList.add(1);
        if (A == 2) {
            return seedList.get((int) B);
        }
        //Find A-1 th row. If B > A-1th row size, take B - (A-1)th size and compliment it
        ArrayList<Integer> resultList = recurse(seedList, 2, A-1, B);
        if (B >= resultList.size()) {
            return resultList.get((int) (B - resultList.size()) ) == 1 ? 0 : 1;
        } else {
            return resultList.get((int) B);
        }
    }

    public ArrayList<Integer> recurse(ArrayList<Integer> list, Integer row, Integer rowLimit, long B) {

        if (Objects.equals(row, rowLimit)) return list;
        ArrayList<Integer> newList = new ArrayList<>(list);
        for (Integer val : list) {
            newList.add(val == 0 ? 1 : 0);
        }
        return recurse(newList, ++row, rowLimit, B);
    }
}
