package advanced.module6.greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * There are N jobs to be done, but you can do only one job at a time.
 * <p>
 * Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
 * <p>
 * Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.
 * <p>
 * Return the maximum number of jobs you can finish.
 */
public class FinishMaximumJobs {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int size = A.size();
        ArrayList<Pair> jobs = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            jobs.add(new Pair(A.get(i), B.get(i)));
        }
        Collections.sort(jobs);
        int count = 1;
        int endTime = jobs.get(0).end;

        for (int i = 1; i < size; i++) {
            if (jobs.get(i).start >= endTime) {
                count++;
                endTime = jobs.get(i).end;
            }
        }
        return count;
    }

    class Pair implements Comparable<Pair> {
        int start;
        int end;

        Pair(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Pair o) {
            return this.end == o.end ? 0 : (this.end > o.end ? 1 : -1);
        }
    }
}
