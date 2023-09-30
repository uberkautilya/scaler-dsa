package advanced.dsa46_sep27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocalMinimaInArray {
    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>(Arrays.asList(9, 8, 7, 3, 6, 4, 1, 5, 2));
        int localMinima = new LocalMinimaInArray().findLocalMinima(
                integerList, 1, integerList.size() - 2
        );
        System.out.println("localMinima = " + localMinima);
    }

    /**
     * Given an unsorted array with all distinct elements, return any one local minima.
     * Given at least one local minima exists
     * @param integerList
     * @param lowerIndex
     * @param higherIndex
     * @return
     */
    private int findLocalMinima(List<Integer> integerList, int lowerIndex, int higherIndex) {
        int lastIndex = integerList.size() - 1;
        if (lastIndex == 0) {
            //Only 1 element in the list
            return integerList.get(0);
        }
        if (integerList.get(0) < integerList.get(1)) {
            return integerList.get(0);
        }
        if (integerList.get(lastIndex) < integerList.get(lastIndex - 1)) {
            return integerList.get(lastIndex);
        }

        int midIndex = (lowerIndex + higherIndex) / 2;
        Integer midElement = integerList.get(midIndex);
        Integer previousElement = integerList.get(midIndex - 1);
        Integer nextElement = integerList.get(midIndex + 1);

        if (midElement < previousElement && midElement < nextElement) {
            //This is a local minima
            return midElement;
        } else if (previousElement < midIndex) {
            //Local minima guaranteed in the left half
            return findLocalMinima(integerList, lowerIndex, midIndex - 1);
        } else if (midElement > nextElement) {
            //Local minima guaranteed in the right half
            return findLocalMinima(integerList, midIndex + 1, higherIndex);
        } else {
            //Local minima guaranteed in either halves. Arbitrarily choosing the right side
            return findLocalMinima(integerList, midIndex + 1, higherIndex);
        }
    }
}
