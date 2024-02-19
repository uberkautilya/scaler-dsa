package advanced.module6.greedy;

import advanced.module6.MinHeap;
import advanced.module6.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlipkartMaximizeProfit {
    public static void main(String[] args) {

        Integer[] expiry = new Integer[]{1, 3, 2, 6};
        Integer[] profit = new Integer[]{9, 3, 2, 8};
        int maxProfit = findMaxProfit(expiry, profit);
        System.out.println("maxProfit = " + maxProfit);
    }

    private static int findMaxProfit(Integer[] expiry, Integer[] profit) {
        List<Pair> pairList = new ArrayList<>();
        for (int i = 0; i < expiry.length; i++) {
            Pair pair = new Pair(expiry[i], profit[i]);
            pairList.add(pair);
        }
        Collections.sort(pairList);
        MinHeap heap = new MinHeap();

        int time = 0;
        for (Pair pair : pairList) {
            if (pair.key < time) {
                heap.insert(pair.value);
                time++;
            } else {
                Integer minInHeap = heap.peek();
                if (pair.value > minInHeap) {
                    heap.getMin();
                    heap.insert(pair.value);
                }
            }
        }
        int totalProfit = 0;
        while (null != heap.peek()) {
            totalProfit += heap.getMin();
        }
        return totalProfit;
    }

}
