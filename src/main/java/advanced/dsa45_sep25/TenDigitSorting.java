package advanced.dsa45_sep25;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TenDigitSorting {
    public static void main(String[] args) {
        int[] sortedArray = new TenDigitSorting().solve(new int[]{
                23, 2, 57, 19, 93, 225
        });
        System.out.println("sortedArray = " + Arrays.toString(sortedArray));
    }

    public int[] solve(int[] A) {

        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());

        list.sort(new TensPlaceComparator());
        return list.stream().mapToInt(Integer::intValue).toArray();
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
