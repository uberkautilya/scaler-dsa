package advanced.module6.stacks.day65;

import java.util.ArrayList;

/**
 * Given an integer array with distinct values,
 * for all sub-arrays find $(max - min)$ in each sub-array and return the sum.
 */
public class SumOfDiffMaxMinInAllSubArrays {

    public Integer sumOfDifference(ArrayList<Integer> data) {
        int sum = 0;
        ArrayList<Integer> nearestLargerOnLeft = new NearestElementIndex()
                .nearestLargerOnLeftIndices(data);
        ArrayList<Integer> nearestSmallerOnLeft = new NearestElementIndex()
                .nearestSmallerOnLeftIndices(data);
        ArrayList<Integer> nearestLargerOnRight = new NearestElementIndex()
                .nearestLargerOnRightIndices(data);
        ArrayList<Integer> nearestSmallerOnRight = new NearestElementIndex()
                .nearestSmallerOnRightIndices(data);
        for (int i = 0; i < data.size(); i++) {
            Integer val = data.get(i);
            int ngLeft = nearestLargerOnLeft.get(i);
            int ngRight = nearestLargerOnRight.get(i);
            int nsLeft = nearestSmallerOnLeft.get(i);
            int nsRight = nearestSmallerOnRight.get(i);
            sum += val * (
                    (i - ngLeft) * (ngRight - i) -
                            (i - nsLeft) * (nsRight - i)
            );
        }
        return sum;
    }
}
