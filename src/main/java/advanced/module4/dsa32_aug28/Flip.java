package advanced.module4.dsa32_aug28;

import java.util.Arrays;

public class Flip {
    public static void main(String[] args) {
        Flip flip = new Flip();
        int[] indexArray = flip.flip("0111000100010"); //Expected: 5, 11
//        int[] indexArray = flip.flip("1101010001"); //Expected: 3, 9
        System.out.println(Arrays.toString(indexArray));
    }

    public int[] flip(String A) {
        if (!A.contains("0")) return new int[0];

        int l = 0;
        int r = 0;
        int left = 0;
        int zeroCount = 0;
        int maxZeros = 0;
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (c == '0') {
                zeroCount++;
                if (zeroCount > maxZeros) {
                    maxZeros = zeroCount;
                    l = left;
                    r = i;
                }
            } else {
                zeroCount--;
            }
            if (zeroCount < 0) {
                zeroCount = 0;
                left = i + 1;
            }
        }
        //L and R start from 1, as per the question. Correcting the indexing
        return new int[]{l + 1, r + 1};
    }
}
