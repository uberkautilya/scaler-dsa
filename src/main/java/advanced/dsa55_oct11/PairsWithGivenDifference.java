package advanced.dsa55_oct11;

import java.util.ArrayList;
import java.util.Arrays;

public class PairsWithGivenDifference {
    public static void main(String[] args) {
        PairsWithGivenDifference pairsWithGivenDifference = new PairsWithGivenDifference();
        ArrayList<Integer> numList = new ArrayList<>(Arrays.asList(
                8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3
        ));
        numList = new ArrayList<>(Arrays.asList(5, 2, 2, 4, 9, 8, 5, 3, 8, 8, 10, 4, 2, 10, 9, 7, 6, 1, 3, 9, 7, 1, 3, 5));
        Integer result = pairsWithGivenDifference.solve(
                numList, 3);
        System.out.println("result = " + result);

    }

    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        A.sort((a, b) -> a - b);
        int p1 = 0;
        int p2 = 1;
        while (p2 < A.size() && p1 < p2) {
            int n1 = A.get(p1);
            int n2 = A.get(p2);
            if (n2 - n1 == B) {
                count++;
                while (p2 < A.size() && n2 == A.get(p2)) {
                    p2++;
                }
                while (p1 < p2 && n1 == A.get(p1)) {
                    p1++;
                }
            }
            if (n2 - n1 < B) {
                p2++;
            } else {
                p1++;
            }
        }
        return count;
    }

}
