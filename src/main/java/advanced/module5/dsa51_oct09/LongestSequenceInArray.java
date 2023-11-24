package advanced.module5.dsa51_oct09;

import java.util.ArrayList;
import java.util.HashSet;

public class LongestSequenceInArray {
    /**
     * Given an Integer array,
     * find the length of longest consecutive chain of elements - order irrelevant
     */
    private int countLongest(ArrayList<Integer> numList) {
        if (null == numList) {
            return 0;
        }
        HashSet<Integer> hs = new HashSet<>(numList);
        int ans = 0;
        for (Integer num : hs) {
            //Check if num-1 is present in hs
            if (hs.contains(num - 1)) {
                //Skip
            } else {
                int count = 1;
                int nextUpInt = num + 1;
                while (hs.contains(nextUpInt)) {
                    nextUpInt++;
                    count++;
                }
                if (count > ans) {
                    ans = count;
                }
            }
        }
        return ans;
    }
}
