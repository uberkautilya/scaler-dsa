package advanced.dsa36_sep06;

import java.util.Arrays;
import java.util.List;

public class ElemenetNotThrice {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 2, 3, 2, 3, 6, 7, 6, 6);
        Integer element = solve(numbers);
        System.out.println("element = " + element);
    }

    private static Integer solve(List<Integer> numbers) {

        int uniqueElement = 0;
        for (int i = 0; i < 32; i++) {
            int c = 0;
            //Looping through the given numbers
            for (Integer num : numbers) {
                if ((num & 1 << i) != 0) {
                    c += 1;
                }
            }
            if (c % 3 != 0) {
                uniqueElement = uniqueElement | (1 << i);
            }
        }
        return uniqueElement;
    }
}
