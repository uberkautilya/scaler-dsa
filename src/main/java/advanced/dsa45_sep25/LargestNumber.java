package advanced.dsa45_sep25;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public static void main(String[] args) {
//        String s = new LargestNumber().largestNumber(Arrays.asList(3, 30));
//        String s = new LargestNumber().largestNumber(Arrays.asList(0, 0, 0));
        String s = new LargestNumber().largestNumber(Arrays.asList(3, 30, 34, 5, 9));
        System.out.println("s = " + s);
    }

    public String largestNumber(final List<Integer> A) {
        A.sort(new IntSorter());
        StringBuilder sb = new StringBuilder();

        for (int i : A) {
            sb.append(i);
        }
        if (sb.toString().toCharArray()[0] == '0') return "0";
        return sb.toString();
    }

    private class IntSorter implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            String alternate1 = o1.toString() + o2.toString();
            String alternate2 = o2.toString() + o1.toString();

            return alternate2.compareTo(alternate1);
        }
    }
}
