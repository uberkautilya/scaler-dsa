package advanced.dsa34_sep01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        //Expected: (6037774, 6198243) (6726550, 7004541) (8842554, 10866536) (11027721, 11341296) (11972532, 14746848) (16374805, 16706396) (17557262, 20518214) (22139780, 22379559) (27212352, 28404611) (28921768, 29621583) (29823256, 32060921) (33950165, 64859907) (65277782, 65296274) (67497842, 68386607) (70414085, 73339545) (73896106, 75605861) (79672668, 84539434) (84821550, 86558001) (91116470, 92198054) (96147808, 98979097)
        List<Interval> list = Arrays.asList(
                new Interval(6037774, 6198243), new Interval(6726550, 7004541), new Interval(8842554, 10866536), new Interval(11027721, 11341296), new Interval(11972532, 14746848), new Interval(16374805, 16706396), new Interval(17557262, 20518214), new Interval(22139780, 22379559), new Interval(27212352, 28404611), new Interval(28921768, 29621583), new Interval(29823256, 32060921), new Interval(33950165, 36418956), new Interval(37225039, 37785557), new Interval(40087908, 41184444), new Interval(41922814, 45297414), new Interval(48142402, 48244133), new Interval(48622983, 50443163), new Interval(50898369, 55612831), new Interval(57030757, 58120901), new Interval(59772759, 59943999), new Interval(61141939, 64859907), new Interval(65277782, 65296274), new Interval(67497842, 68386607), new Interval(70414085, 73339545), new Interval(73896106, 75605861), new Interval(79672668, 84539434), new Interval(84821550, 86558001), new Interval(91116470, 92198054), new Interval(96147808, 98979097)
        );
        ArrayList<Interval> result = mergeIntervals.insert(
                new ArrayList<>(list), new Interval(36210193, 61984219)
        );

        System.out.println("result = " + result);
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int start = min(newInterval.start, newInterval.end);
        int end = max(newInterval.start, newInterval.end);
        ArrayList<Interval> newIntervals = new ArrayList<Interval>();

        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            int s = interval.start;
            int e = interval.end;

            if (end < s) {
                newIntervals.add(new Interval(start, end));
                for (int j = i; j < intervals.size(); j++) {
                    newIntervals.add(intervals.get(j));
                }
                return newIntervals;
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

}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "(" + start + ", " + end + ")";
    }
}

/*
//Expected: (6037774, 6198243) (6726550, 7004541) (8842554, 10866536) (11027721, 11341296) (11972532, 14746848) (16374805, 16706396) (17557262, 20518214) (22139780, 22379559) (27212352, 28404611) (28921768, 29621583) (29823256, 32060921) (33950165, 64859907) (65277782, 65296274) (67497842, 68386607) (70414085, 73339545) (73896106, 75605861) (79672668, 84539434) (84821550, 86558001) (91116470, 92198054) (96147808, 98979097)
        List<Interval> list = Arrays.asList(
                new Interval(6037774, 6198243), new Interval(6726550, 7004541), new Interval(8842554, 10866536), new Interval(11027721, 11341296), new Interval(11972532, 14746848), new Interval(16374805, 16706396), new Interval(17557262, 20518214), new Interval(22139780, 22379559), new Interval(27212352, 28404611), new Interval(28921768, 29621583), new Interval(29823256, 32060921), new Interval(33950165, 36418956), new Interval(37225039, 37785557), new Interval(40087908, 41184444), new Interval(41922814, 45297414), new Interval(48142402, 48244133), new Interval(48622983, 50443163), new Interval(50898369, 55612831), new Interval(57030757, 58120901), new Interval(59772759, 59943999), new Interval(61141939, 64859907), new Interval(65277782, 65296274), new Interval(67497842, 68386607), new Interval(70414085, 73339545), new Interval(73896106, 75605861), new Interval(79672668, 84539434), new Interval(84821550, 86558001), new Interval(91116470, 92198054), new Interval(96147808, 98979097)
        );
        ArrayList<Interval> result = mergeIntervals.insert(
                new ArrayList<>(list), new Interval(36210193, 61984219)
        );
 */