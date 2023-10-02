package advanced.dsa45_sep25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FactorsSort {

    public static void main(String[] args) {

        ArrayList<Integer> integerArrayList = new ArrayList<>(Arrays.asList(6, 8, 9));
        integerArrayList = new ArrayList<>(Arrays.asList(2, 4, 7));
        ArrayList<Integer> sortedArray = new FactorsSort().solve(integerArrayList);
        System.out.println("sortedArray = " + sortedArray);
    }

    public ArrayList<Integer> solve(ArrayList<Integer> integerArrayList) {
        integerArrayList.sort(new FactorComparator());
        return integerArrayList;
    }

    private class FactorComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            int o1FactorCount = countFactors(o1);
            int o2FactorCount = countFactors(o2);
            if (o1FactorCount == o2FactorCount) {
                return o1 - o2;
            }
            return o1FactorCount - o2FactorCount;
        }

        private Integer countFactors(Integer val) {
            int count = 2;
            for (int i = 2; i * i <= val; i++) {
                if (val % i == 0) {
                    count += 2;
                }
                if (i * i == val) {
                    count--;
                }
            }
            return count;
        }
    }

}
