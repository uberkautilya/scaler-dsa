package advanced.module4.dsa36_sep06;

import java.util.Arrays;
import java.util.List;

public class TwoUniqueElementsInList {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 2, 3, 6, 7, 6, 6);
        solve(numbers);
    }

    private static void solve(List<Integer> numbers) {

        int xor = 0;
        for (Integer num : numbers) {
            xor = xor ^ num;
        }
        int indexBitSet = Integer.MIN_VALUE;
        for (int i = 0; i < 32; i++) {
            //Find the LSB which is set in the XOR result
            if ((xor & 1 << i) != 0) {
                indexBitSet = i;
                break;
            }
        }
        int setUnique = 0;
        int unsetUnique = 0;
        for (Integer num : numbers) {
            if ((num & 1 << indexBitSet) != 0) {
                //XOR to remove duplicates
                setUnique = setUnique ^ num;
            } else {
                //XOR to remove duplicates
                unsetUnique = unsetUnique ^ num;
            }
        }
        System.out.println("setUnique = " + setUnique);
        System.out.println("unsetUnique = " + unsetUnique);
    }
}


/*0013 -> 0113, 1013
    0113 -> 0213, 1113
        0213 -> 0313, 1213
            0313 -> 0413, 1313
                0413 -> return
                1313 -> +1
            1213 -> 1313, 2213
                1313 -> +1
                2213 -> return
        1113 -> 1213, 2113
            1213 -> 1313, 2213
                1313 -> +1
                2213 -> return
    1013 -> 1113, 2013
        1113 -> 1213, 2113
            1213 -> +1
            2113 -> return
        2013 -> 2113, 3013
            2113 -> return
            3013 -> return*/
