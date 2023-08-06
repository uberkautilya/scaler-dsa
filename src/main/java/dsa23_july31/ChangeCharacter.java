package dsa23_july31;

import java.util.Arrays;
import java.util.Collections;

public class ChangeCharacter {
    public static void main(String[] args) {
        ChangeCharacter changeCharacter = new ChangeCharacter();
        int result = changeCharacter.solve("a", 1);
        System.out.println("result = " + result);

    }

    public int solve(String A, int B) {
        char[] chars = A.toCharArray();
        int[] count = new int[26];

        for (char c : chars) {
            count[c - 'a'] += 1;
        }

        Arrays.sort(count);
        int i = 0;
        while (count[i] <= B && i!= 25) {
            B -= count[i];
            count[25] += count[i];
            count[i] = 0;
            if (B == 0) {
                break;
            }
            i++;
        }
        int minNoOfAlphabets = 0;
        for (int val : count) {
            if (val != 0) {
                minNoOfAlphabets++;
            }
        }
        return minNoOfAlphabets;
    }
}
