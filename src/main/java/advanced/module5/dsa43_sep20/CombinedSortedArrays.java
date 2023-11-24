package advanced.module5.dsa43_sep20;

import java.util.Arrays;

public class CombinedSortedArrays {
    public static void main(String[] args) {
        int[] result = combine(new int[]{2, 4, 7}, new int[]{1, 3, 5});
        System.out.println("result = " + Arrays.toString(result));
    }

    private static int[] combine(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int p1 = 0, p2 = 0, p = 0;

        int[] result = new int[n + m];
        while (p1 < n && p2 < m) {
            if (a[p1] < b[p2]) {
                result[p] = a[p1];
                p1++;
            } else {
                result[p] = b[p2];
                p2++;
            }
            p++;
        }
        while (p1 < n) {
            result[p] = a[p1];
            p1++;
            p++;
        }
        while (p2 < m) {
            result[p] = b[p2];
            p2++;
            p++;
        }
        return result;
    }
}
