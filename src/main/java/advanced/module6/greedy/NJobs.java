package advanced.module6.greedy;

import advanced.module6.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given N jobs -> Start and end times.
 * Find the maximum number of jobs that can be completed if only one job can be completed at a given time
 * Solution: Greedily select the job that ends earliest
 * T.C. = O(NlogN) -> From sorting, S.C. = O(N) -> From pairs
 */
public class NJobs {
    public static void main(String[] args) {
        int countOfJobs = getCountOfJobs(new Integer[]{2, 8, 9, 1, 3}, new Integer[]{2, 9, 4, 8, 3});
        System.out.println("countOfJobs = " + countOfJobs);
    }

    public static int getCountOfJobs(Integer[] start, Integer[] end) {
        int size = start.length;
        List<Pair> pairList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Pair pair = new Pair(start[i], end[i]);
            pairList.add(pair);
        }
        //Sort the jobs based on the completion time - earliest ending one first
        pairList.sort(Comparator.comparingInt(o -> o.value));

        int count = 0;
        int time = 0;
        for (Pair pair : pairList) {
            if (time <= pair.key) {
                count++;
                time = pair.value;
            }
        }
        return count;
    }
}
