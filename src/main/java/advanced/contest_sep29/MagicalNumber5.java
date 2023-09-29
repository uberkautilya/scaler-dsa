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
        int size = A.size();
        for (int i = 0; i < size; i++) {
            boolean divisibleBy5 = check(A, i);
            result.add(divisibleBy5 ? 1 : 0);
        }
        return result;
    }

    private boolean check(ArrayList<Integer> A, int end) {
        int num = 0;
        int posVal = 1;
        while (end >= 0) {
            num += A.get(end) * posVal;
            end--;
            posVal *= 2;
        }
        return num % 5 == 0;
    }
}
