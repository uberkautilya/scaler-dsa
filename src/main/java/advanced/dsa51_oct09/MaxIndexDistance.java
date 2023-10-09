package advanced.dsa51_oct09;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxIndexDistance {
    /**
     * Given an integer array A, find any pair[i, j] such that A[i] == A[j] && |i-j| should be maximum
     *
     * @param numbers
     * @return
     */
    private int farthestSameElements(ArrayList<Integer> numbers) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int distance = -1;
        int left = -1;
        int right = -1;
        for (int i = 0; i < numbers.size(); i++) {
            Integer num = numbers.get(i);
            if (indexMap.containsKey(num)) {
                Integer firstIndex = indexMap.get(num);
                if (i - firstIndex > distance) {
                    left = firstIndex;
                    right = i;
                    distance = i - firstIndex;
                }
            } else {
                indexMap.put(num, i);
            }
        }
        System.out.println("left = " + left);
        System.out.println("right = " + right);
        return distance;
    }
}
