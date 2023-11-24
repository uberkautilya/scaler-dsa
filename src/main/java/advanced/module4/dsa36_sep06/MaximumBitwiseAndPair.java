package advanced.module4.dsa36_sep06;

import java.util.Arrays;
import java.util.List;

public class MaximumBitwiseAndPair {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(26, 13, 23, 28, 27, 7, 25);
        numbers = Arrays.asList(13,18,23,56,81,20,4,24,93);
        for (Integer num : numbers) {
            System.out.println(Integer.toBinaryString(num));
        }
        int maximum = solve(numbers);
        System.out.println("maximum = " + maximum);
    }

    private static int solve(List<Integer> numbers) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int count = countElementsIthBitSet(numbers, i);
            //If count of elements with ith bit set is <2, can't remove any from list of contenders
            if (count >= 2) {
                int ithBit = (1 << i);
                ans = ans + (1 << i);
                for (int j = 0; j < numbers.size(); j++) {
                    //If count >= 2, set numbers whose ith bit is zero to 0.
                    if ((numbers.get(j) & ithBit) == 0) {
                        numbers.set(j, 0);
                    }
                }
                /*
                for (Integer num: numbers) {
                    //If count >= 2, set numbers whose ith bit is zero to 0.
                    if ((num & ithBit) == 0) {
                        num = 0;
                    }
                }*/
            }
        }
        return ans;
    }

    private static int countElementsIthBitSet(List<Integer> numbers, int i) {
        int count = 0;
        for (Integer num : numbers) {
            if ((num & 1 << i) != 0) {
                count++;
            }
        }
        return count;
    }
}
