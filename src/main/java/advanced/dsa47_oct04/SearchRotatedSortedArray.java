package advanced.dsa47_oct04;

import java.util.ArrayList;

public class SearchRotatedSortedArray {


    private int search(ArrayList<Integer> list, int needle) {
        int n = list.size();
        int l = 0;
        int h = n - 1;

        while (l <= h) {
            int m = (l + h) / 2;
            if (list.get(m) == needle) {
                return m;
            }
            if (list.get(l) <= list.get(m)) {
                //Implies l to m is sorted
                if (list.get(l) <= needle && needle <= list.get(m)) {
                    //This shows the left part is sorted and needle lies in this range
                    h = m - 1;
                } else {
                    //This shows the right part is sorted
                    l = m + 1;
                }
            } else {
                //Implies m to h is sorted
                if (list.get(m) <= needle && needle <= list.get(h)) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }
        return -1;
    }
}
