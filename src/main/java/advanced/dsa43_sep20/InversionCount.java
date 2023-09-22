package advanced.dsa43_sep20;

/**
 * Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A.
 * Find the total number of inversions of A modulo (10^9 + 7).
 */
public class InversionCount {
    public static void main(String[] args) {
        //1, 2, 3,
        int inversionPairCount = inversionCount(new int[]{23, 54, 2, 3, 1, 93});
        System.out.println("inversionPairCount = " + inversionPairCount);
    }

    static int c = 0;

    private static int inversionCount(int[] ar) {
        mergeSort(ar, 0, ar.length - 1);
        return c % 1000_000_007;
    }

    private static void mergeSort(int[] ar, int l, int h) {
        if (l == h) {
            return;
        }
        int m = (l + h) / 2;
        mergeSort(ar, l, m);
        mergeSort(ar, m + 1, h);

        merge(ar, l, m, h);
    }

    private static void merge(int[] ar, int l, int m, int h) {
        int[] tmp = new int[h - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int p = 0;

        while (p1 <= m && p2 <= h) {
            if (ar[p1] < ar[p2]) {
                tmp[p] = ar[p1];
                p1++;
            } else {
                //Add the number of elements in 1st half from p1 to m
                c += m - p1 + 1;
                c = c % 1000_000_007;
                tmp[p] = ar[p2];
                p2++;
            }
            p++;
        }
        while (p1 <= m) {
            tmp[p] = ar[p1];
            p1++;
            p++;
        }
        while (p2 <= h) {
            tmp[p] = ar[p2];
            p2++;
            p++;
        }
        for (int i = l; i <= h; i++) {
            ar[i] = tmp[i - l];
        }
    }
}
