package fundamentals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListToArrays {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);

        int[] leaders = arrayListToArray(integerList);
        System.out.println(Arrays.toString(leaders));
    }

    private static int[] arrayListToArray(List<Integer> integerList) {
        int[] leaders = new int[integerList.size()];
        int index = 0;
        for (Integer i : integerList) {
            leaders[index] = i;
            i++;
        }
        return leaders;
    }
}
