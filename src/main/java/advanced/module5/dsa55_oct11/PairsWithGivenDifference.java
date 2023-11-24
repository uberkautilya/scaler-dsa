package advanced.module5.dsa55_oct11;

import java.util.ArrayList;
import java.util.Arrays;

public class PairsWithGivenDifference {
    public static void main(String[] args) {
        PairsWithGivenDifference pairsWithGivenDifference = new PairsWithGivenDifference();
        ArrayList<Integer> numList = new ArrayList<>(Arrays.asList(
                8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3
        ));
        numList = new ArrayList<>(Arrays.asList(5, 2, 2, 4, 9, 8, 5, 3, 8, 8, 10, 4, 2, 10, 9, 7, 6, 1, 3, 9, 7, 1, 3, 5));
        numList = new ArrayList<>(Arrays.asList(1, 8, 2, 8, 8, 8, 8, 4, 4, 6, 10, 10, 9, 2, 9, 3, 7));
        int b = 3;
        b = 1;
        b = 0;
        Integer result = pairsWithGivenDifference.solve(
                numList, b);
        System.out.println("result = " + result);

    }

    public int solve(ArrayList<Integer> A, int B) {
        int size = A.size();
        int count = 0;
        A.sort((a, b) -> a - b);
        int p1 = 0, p2 = 1;

        while (p2 < size && p1 <= p2) {
            int num1 = A.get(p1);
            int num2 = A.get(p2);
            if (num2 - num1 == B && p1 != p2) {
                count++;
                while ((p2 + 1) < size &&
                        num2 == A.get(p2 + 1)) {
                    p2++;
                }
                while ((p1 + 1) < p2 &&
                        num1 == A.get(p1 + 1)) {
                    p1++;
                }
            }
            if (num2 - num1 <= B && (p2 + 1) < size) {
                p2++;
            }else {
                p1++;
            }
        }
        return count;
    }

}
