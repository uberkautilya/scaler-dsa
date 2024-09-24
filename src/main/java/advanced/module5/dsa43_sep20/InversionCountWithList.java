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

    int count = 0;

    public int solve(ArrayList<Integer> A) {
        mergeSort(A, 0, A.size() - 1);
        return count % 1000_000_007;
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

    private void merge(ArrayList<Integer> ar, int lIndex, int mIndex, int hIndex) {
        int[] tmp = new int[hIndex - lIndex + 1];
        int p1 = lIndex;
        int p2 = mIndex + 1;
        int index = 0;

        while (p1 <= mIndex && p2 <= hIndex) {
            if (ar.get(p1) <= ar.get(p2)) {
                tmp[index] = ar.get(p1);
                p1++;
            } else {
                count += mIndex - p1 + 1;
                count = count % 1000_000_007;
                tmp[index] = ar.get(p2);
                p2++;
            }
            index++;
        }

        while (p1 <= mIndex) {
            tmp[index] = ar.get(p1);
            p1++;
            index++;
        }
        while (p2 <= hIndex) {
            tmp[index] = ar.get(p2);
            p2++;
            index++;
        }
        for (int i = lIndex; i <= hIndex; i++) {
            ar.set(i, tmp[i - lIndex]);
        }
    }
}
