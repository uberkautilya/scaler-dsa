package advanced.module4.dsa34_sep01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals2 {

    public static void main(String[] args) {
        MergeIntervals2 mergeIntervals2 = new MergeIntervals2();
        ArrayList<Interval> intervals = new ArrayList<>(Arrays.asList(
                new Interval(54, 75), new Interval(56, 60), new Interval(61, 86), new Interval(22, 43),
                new Interval(56, 87), new Interval(32, 53), new Interval(14, 81), new Interval(64, 65),
                new Interval(9, 42), new Interval(12, 33), new Interval(22, 58), new Interval(84, 90),
                new Interval(27, 59), new Interval(41, 48), new Interval(43, 47), new Interval(22, 29),
                new Interval(16, 23), new Interval(41, 72), new Interval(15, 87), new Interval(20, 59),
                new Interval(45, 84), new Interval(14, 77), new Interval(72, 93), new Interval(20, 58),
                new Interval(47, 53), new Interval(25, 88), new Interval(5, 89), new Interval(34, 97),
                new Interval(14, 47)
        ));
        ArrayList<Interval> result = mergeIntervals2.merge(intervals);
        System.out.println("result = " + result);

    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> newIntervals = new ArrayList<Interval>();
        Collections.sort(intervals, new SortbyStart());
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            int s = min(interval.start, interval.end);
            int e = max(interval.start, interval.end);

            if (end < s) {
                newIntervals.add(new Interval(start, end));
                start = s;
                end = e;
            } else if (e < start) {
                newIntervals.add(interval);
            } else {
                //Overlap condition. Merge.
                start = min(start, s);
                end = max(end, e);
            }
        }
        newIntervals.add(new Interval(start, end));
        return newIntervals;
    }

    private int min(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }

    private int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    class SortbyStart implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }
}
