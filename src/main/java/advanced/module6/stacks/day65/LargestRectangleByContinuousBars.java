package advanced.module6.stacks.day65;

import java.util.ArrayList;

/**
 * Given an integer array A, where A[i] is the height of ith bar, width of each being 1.
 * Find the area of largest rectangle formed by continuous bars
 */
public class LargestRectangleByContinuousBars {
    public Integer findMaxRectangleArea(ArrayList<Integer> lengths) {
        int maxArea = 0;
        ArrayList<Integer> smallerOnLeftIndices = new NearestElementIndex().nearestSmallerOnLeftIndices(lengths);
        ArrayList<Integer> smallerOnRightIndices = new NearestElementIndex().nearestSmallerOnRightIndices(lengths);
        for (int i = 0; i < lengths.size(); i++) {
            //Find biggest rectangle possible with the current element's height
            Integer smallerOnRight = smallerOnRightIndices.get(i);
            Integer smallerOnLeft = smallerOnLeftIndices.get(i);
            int area = lengths.get(i) * (smallerOnRight - smallerOnLeft - 1);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
