package advanced.module5.dsa43_sep20;

import java.util.ArrayList;
import java.util.Arrays;

public class InversionCountWithList {
    public static void main(String[] args) {
        //1, 2, 3,
        int inversionPairCount = new InversionCountWithList()
                .solve(new ArrayList<>(Arrays.asList(23, 54, 2, 3, 1, 93))); //Ans: 8
//        int inversionPairCount = new InversionCountWithList()
//                .solve(new ArrayList<>(Arrays.asList(6,12,10,17,10,22,9,19,21,31,26,8)));
        System.out.println("inversionPairCount = " + inversionPairCount);
    }

    int c = 0;

    public int solve(ArrayList<Integer> A) {
        mergeSort(A, 0, A.size() - 1);
        return c % 1000_000_007;
    }

    private void mergeSort(ArrayList<Integer> ar, int l, int h) {
        if (l == h) {
            return;
        }
        int m = (l + h) / 2;
        mergeSort(ar, l, m);
        mergeSort(ar, m + 1, h);
        merge(ar, l, m, h);
    }

    private void merge(ArrayList<Integer> ar, int l, int m, int h) {
        int[] tmp = new int[h - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int p = 0;

        while (p1 <= m && p2 <= h) {
            if (ar.get(p1) <= ar.get(p2)) {
                tmp[p] = ar.get(p1);
                p1++;
            } else {
                c += m - p1 + 1;
                c = c % 1000_000_007;
                tmp[p] = ar.get(p2);
                p2++;
            }
            p++;
        }

        while (p1 <= m) {
            tmp[p] = ar.get(p1);
            p1++;
            p++;
        }
        while (p2 <= h) {
            tmp[p] = ar.get(p2);
            p2++;
            p++;
        }
        for (int i = l; i <= h; i++) {
            ar.set(i, tmp[i - l]);
        }
    }
}
