package dsa23_july31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SortIntegerArray {
    public static void main(String[] args) {

        int[] solve = new SortIntegerArray().solve(new int[]{10, 9, 8});
//        int[] solve = new SortIntegerArray().solve(new int[]{2, 4, 2, 1, 7, 3});
        System.out.println("solve = " + Arrays.toString(solve));
    }

    public int[] solve(int[] A) {
        List<Integer> intList = new ArrayList<>();
        for (int a : A) {
            intList.add(a);
        }
        intList.sort(Integer::compareTo);
        int[] newArray = new int[A.length];
        for (int i = 0; i < intList.size(); i++) {
            newArray[i] = intList.get(i);
        }
        return newArray;
    }
}
