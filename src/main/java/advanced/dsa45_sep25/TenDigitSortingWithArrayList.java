package advanced.dsa45_sep25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TenDigitSortingWithArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> sortedArray = new TenDigitSortingWithArrayList().solve(new ArrayList<Integer>(Arrays.asList(
                23, 2, 57, 19, 93, 225
        )));
        System.out.println("sortedArray = " + sortedArray);
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        A.sort(new TensPlaceComparator());
        return A;
    }

    private static class TensPlaceComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {

            int diff = ((o1 / 10) % 10) - ((o2 / 10) % 10);
            if (diff == 0) {
                return o2 - o1;
            }
            return diff;
        }
    }
}
