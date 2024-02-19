package advanced.module6.greedy;


import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.max;

/**
 * N children are standing in a line. Each child is assigned a rating value.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum number of candies you must give?
 * T.C. = O(N), S.C. = O(N)
 */
public class DistributeCandy2 {
    public static void main(String[] args) {
        ArrayList<Integer> marksScored = new ArrayList<>(Arrays.asList(1, 5, 2, 1));
        new DistributeCandy2().candy(marksScored);
    }

    public int candy(ArrayList<Integer> A) {
        int size = A.size();

        ArrayList<Integer> candyCount = new ArrayList<>();
        candyCount.set(0, 1);
        for (int i = 1; i < size; i++) {
            candyCount.add(1);
            if (A.get(i) > A.get(i - 1)) {
                candyCount.set(i, candyCount.get(i - 1) + 1);
            }
        }
        ArrayList<Integer> candyCountRTL = new ArrayList<>();
        candyCountRTL.set(size - 1, 1);
        for (int i = size - 2; i >= 0; i--) {
            candyCountRTL.set(i, 1);
            if (A.get(i) > A.get(i + 1)) {
                candyCountRTL.add(i, candyCountRTL.get(i + 1) + 1);
            }
        }

        int ans = 0;
        for (int i = 0; i < size; i++) {
            ans += max(candyCount.get(i), candyCountRTL.get(i));
        }
        return ans;
    }
}
