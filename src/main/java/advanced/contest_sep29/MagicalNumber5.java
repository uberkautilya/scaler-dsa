package advanced.contest_sep29;

import java.util.ArrayList;
import java.util.Arrays;

public class MagicalNumber5 {
    public static void main(String[] args) {
//        ArrayList<Integer> result = new MagicalNumber5().solve(new ArrayList<>(Arrays.asList(0, 0, 1, 1, 1, 1)));
//        ArrayList<Integer> result = new MagicalNumber5().solve(new ArrayList<>(Arrays.asList(0, 0, 1, 0, 1, 1)));
//        ArrayList<Integer> result = new MagicalNumber5().solve(new ArrayList<>(Arrays.asList(1, 0, 1)));
        ArrayList<Integer> result = new MagicalNumber5().solve(new ArrayList<>(Arrays.asList(1, 0, 1, 0, 0)));
        System.out.println("result = " + result);
    }

    private ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int num = A.get(0);

        for (int current: A) {
            num = (num << 1) + current;
            result.add(num % 5 == 0 ? 1 : 0);
        }
        return result;
    }
}
