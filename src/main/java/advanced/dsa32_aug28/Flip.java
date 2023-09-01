package advanced.dsa32_aug28;

import java.util.Arrays;

public class Flip {
    public static void main(String[] args) {
        Flip flip = new Flip();
        int[] indexArray = flip.flip("001010");
        System.out.println(Arrays.toString(indexArray));
    }

    public int[] flip(String A) {
        boolean areAllOnes = true;
        for (char c : A.toCharArray()) {
            if (c == '0') {
                areAllOnes = false;
                break;
            }
        }
        if (areAllOnes) return new int[0];

        int left = 0;
        int right = 0;
        int zero = 0;
        int maxZeros = 0;
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (c == '0') {
                zero++;
                if (zero > maxZeros) {
                    maxZeros = zero;
                    right = i;
                }
            } else {
                zero--;
            }
            if (zero < 0) {
                zero = 0;
                left = i;
                right = i;
            }
        }
        //L and R start from 1, as per the question. Correcting the indexing
        return new int[]{left + 1, right + 1};
    }
}
