package homeworks_experiments.usesofsorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * You are given an array A of N elements.
 * Sort the given array in increasing order of number of distinct factors of each element,
 * i.e., element having the least number of factors should be the first to be displayed and
 * the number having highest number of factors should be the last one.
 * If 2 elements have same number of factors, then number with less value should come first.
 * <p>
 * Note: You cannot use any extra space
 */
public class FactorsSort {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>();
        array.add(23);
        System.out.println("solve(array) = " + solve(array));
    }

    //How do you solve when A is a primitive int[] - Todo
    public static List<Integer> solve(List<Integer> A) {

        A.sort((Integer a, Integer b) -> {
            if (Objects.equals(a, b)) return 0;
            if (countFactors(a) < countFactors(b)) {
                return -1;
            } else if (Objects.equals(countFactors(a), countFactors(b)) && a < b) {
                return -1;
            } else {
                return 1;
            }
        });
        return A;
    }

    ;

    public static Integer countFactors(Integer num) {
        if (num == 1) return 1;
        Integer count = 2;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                count += 2;
            }
            if (i * i == num) {
                count--;
            }
        }
        return count;
    }
}
