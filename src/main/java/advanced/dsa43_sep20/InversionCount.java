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

    static int count = 0;

    private static int inversionCount(int[] ar) {
        mergeSort(ar, 0, ar.length - 1);
        return count % 1000_000_007;
    }

    private static void mergeSort(int[] ar, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(ar, low, mid);
        mergeSort(ar, mid + 1, high);

        merge(ar, low, mid, high);
    }

    private static void merge(int[] ar, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int p1 = low;
        int p2 = mid + 1;
        int p = 0;

        while (p1 <= mid && p2 <= high) {
            if (ar[p1] < ar[p2]) {
                tmp[p] = ar[p1];
                p1++;
            } else {
                //Add the number of elements in 1st half from p1 to mid
                count += mid - p1 + 1;
                count = count % 1000_000_007;
                tmp[p] = ar[p2];
                p2++;
            }
            p++;
        }
        while (p1 <= mid) {
            tmp[p] = ar[p1];
            p1++;
            p++;
        }
        while (p2 <= high) {
            tmp[p] = ar[p2];
            p2++;
            p++;
        }
        for (int i = low; i <= high; i++) {
            ar[i] = tmp[i - low];
        }
    }
}
