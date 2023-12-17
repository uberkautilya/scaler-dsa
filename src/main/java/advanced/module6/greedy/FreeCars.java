package advanced.module6.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given two arrays, A and B of size N. A[i] represents the time by which you can buy the ith car without paying any money.
 * <p>
 * B[i] represents the profit you can earn by buying the ith car. It takes 1 minute to buy a car, so you can only buy the ith car when the current time <= A[i] - 1.
 * <p>
 * Your task is to find the maximum profit one can earn by buying cars considering that you can only buy one car at a time.
 * <p>
 * NOTE:
 * You can start buying from time = 0.
 * Return your answer modulo 109 + 7.
 */
public class FreeCars {

    public static void main(String[] args) {
        ArrayList<Integer> timeArray = new ArrayList<>(Arrays.asList(1, 3, 2, 3, 3));
        ArrayList<Integer> profitArray = new ArrayList<>(Arrays.asList(5, 6, 1, 3, 9));

        timeArray = new ArrayList<>(Arrays.asList(1, 3, 1, 7, 2, 7, 1, 7, 6, 7, 8, 3, 3, 5, 4, 4, 5));
        profitArray = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 4, 4, 4, 11, 8, 11, 8, 7, 7, 7, 6, 10, 4));

        timeArray = new ArrayList<>(Arrays.asList(3, 8, 7, 5));
        profitArray = new ArrayList<>(Arrays.asList(3, 1, 7, 19));

        int maxProfit = new FreeCars().solve(timeArray, profitArray);
        System.out.println("maxProfit = " + maxProfit);
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int size = A.size();
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            pairs.add(new Pair(A.get(i), B.get(i)));
        }
        Collections.sort(pairs);


        int profit = pairs.get(0).profit;
        int currentTime = 1; //Takes 1 minute to buy the first car
        for (int i = 1; i < size; i++) {
            Pair thisPair = pairs.get(i);

            if ((currentTime + 1) <= thisPair.time) {
                profit += thisPair.profit;
                profit = profit % 1000_000_007;
                currentTime++;
            }
        }
        return profit;
    }


    class Pair implements Comparable<Pair> {
        int time;
        int profit;

        public Pair(int time, int profit) {
            this.time = time;
            this.profit = profit;
        }

        @Override
        public int compareTo(Pair o) {
            //In case the times are equal, higher profit needs to come first
            return this.time == o.time ? o.profit - this.profit : this.time - o.time;
        }
    }
}
