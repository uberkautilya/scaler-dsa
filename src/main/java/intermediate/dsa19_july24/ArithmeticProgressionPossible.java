package intermediate.dsa19_july24;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an integer array A of size N. Return 1 if the array can be arranged to form an arithmetic progression, otherwise return 0.
 * <p>
 * A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
 */
public class ArithmeticProgressionPossible {
    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        if (A.size() <= 2) {
            return 1;
        }
        int diff = A.get(1) - A.get(0);
        for (int i = 1; i + 1 < A.size(); i++) {
            if (A.get(i + 1) - A.get(i) != diff) {
                return 0;
            }
        }
        return 1;
    }
}
