package advanced.module5.contest_sep29;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * For all decimal numbers formed, including 0 that is divisible by 5, the result needs to have 1
 */
public class MagicalNumber5 {
    public static void main(String[] args) {
//        ArrayList<Integer> result = new MagicalNumber5().solve(new ArrayList<>(Arrays.asList(0, 0, 1, 1, 1, 1)));
//        ArrayList<Integer> result = new MagicalNumber5().solve(new ArrayList<>(Arrays.asList(0, 0, 1, 0, 1, 1)));
//        ArrayList<Integer> result = new MagicalNumber5().solve(new ArrayList<>(Arrays.asList(1, 0, 1)));
        ArrayList<Integer> result = new MagicalNumber5().solve(new ArrayList<>(Arrays.asList(0, 0, 0, 1)));
//        ArrayList<Integer> result = new MagicalNumber5().solve(new ArrayList<>(Arrays.asList(1, 0, 1, 0, 0)));
        System.out.println("result = " + result);
    }

    private ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int num = 0;

        for (int current : A) {
            //The below step cannot be done - Left Shift can create wrong values
            //num = (num << 1) + current;

            num = ((num << 1) + current) % 5;
            result.add(num == 0 ? 1 : 0);
        }
        return result;
    }
}
