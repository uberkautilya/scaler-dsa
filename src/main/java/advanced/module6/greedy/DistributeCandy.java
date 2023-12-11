package advanced.module6.greedy;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * N children are standing in a line. Each child is assigned a rating value.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum number of candies you must give?
 */
public class DistributeCandy {
    public static void main(String[] args) {
        ArrayList<Integer> marksScored = new ArrayList<>(Arrays.asList(1, 5, 2, 1));
        new DistributeCandy().candy(marksScored);
    }

    public int candy(ArrayList<Integer> A) {
        int size = A.size();
        ArrayList<Integer> countArray = new ArrayList<>();

        countArray.add(1);
        for (int i = 1; i < size; i++) {
            countArray.add(1);
            if (A.get(i) > A.get(i - 1)) {
                countArray.set(i, countArray.get(i - 1) + 1);
            }
        }
        int totalCandyCount = countArray.get(size - 1);
        for (int i = size - 2; i >= 0; i--) {
            if (A.get(i) > A.get(i + 1)) {
                int maxCount = (countArray.get(i + 1) + 1) > countArray.get(i) ?
                        countArray.get(i + 1) + 1 :
                        countArray.get(i);
                countArray.set(i, maxCount);
            }
            totalCandyCount += countArray.get(i);
        }
        return totalCandyCount;
    }
}
