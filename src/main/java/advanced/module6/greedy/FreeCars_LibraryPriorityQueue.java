package advanced.module6.greedy;

import java.util.*;

public class FreeCars_LibraryPriorityQueue {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int size = A.size();
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            pairs.add(new Pair(A.get(i), B.get(i)));
        }
        Collections.sort(pairs);

        //Holds the profits added at any given time. If a higher profit comes, the min from this is replaced with the new value
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        int profit = 0;
        int currentTime = 0; //Takes 1 minute to buy the first car
        for (int i = 0; i < size; i++) {
            int thisTime = pairs.get(i).time;
            int thisProfit = pairs.get(i).profit;

            if (currentTime + 1 <= thisTime) {
                minHeap.add(thisProfit);
                profit += thisProfit;
                currentTime++;
            } else if (thisProfit > minHeap.peek()) {
                //Here, we trash a lower value added in a previous step, for one with a better profit
                //Thus currentTime is not incremented - we are correcting an old transaction
                profit -= minHeap.poll();
                profit += thisProfit;
                minHeap.add(thisProfit);
            }
            profit = profit % 1000_000_007;
        }
        return profit;
    }


    static class Pair implements Comparable<Pair> {
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
