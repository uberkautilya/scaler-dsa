package advanced.module5.dsa49_oct04;

import java.util.ArrayList;

public class SearchRotatedSortedArray {


    private int search(ArrayList<Integer> list, int needle) {
        int size = list.size();
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int midValue = (low + high) / 2;
            if (list.get(midValue) == needle) {
                return midValue;
            }
            if (list.get(low) <= list.get(midValue)) {
                //Implies low to midValue is sorted
                if (list.get(low) <= needle && needle <= list.get(midValue)) {
                    //This shows the left part is sorted and needle lies in this range
                    high = midValue - 1;
                } else {
                    //This shows the right part is sorted
                    low = midValue + 1;
                }
            } else {
                //Implies midValue to high is sorted
                if (list.get(midValue) <= needle && needle <= list.get(high)) {
                    low = midValue + 1;
                } else {
                    high = midValue - 1;
                }
            }
        }
        return -1;
    }
}
