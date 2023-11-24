package advanced.module5.dsa43_sep20;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] elements = {2, 4, 1, 7, 9, 3, 4, 2};
        int[] result = mergeSort(elements, 0, elements.length);
        System.out.println("result = " + Arrays.toString(result));
    }

    private static int[] mergeSort(int[] elements, int l, int h) {
        if (l == h) {
            return elements;
        }
        int m = (l + h) / 2;
        mergeSort(elements, l, m);
        mergeSort(elements, m + 1, h);
        merge(elements, l, m, h);
        return elements;
    }

    private static int[] merge(int[] elements, int l, int mid, int h) {
        int[] a = Arrays.copyOfRange(elements, l, mid + 1);
        int[] b = Arrays.copyOfRange(elements, mid + 1, h);
        int n = a.length;
        int m = b.length;
        int[] result = new int[n + m];

        int p1 = 0, p2 = 0, p = 0;
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
        for (int i = l; i < h; i++) {
            elements[i] = result[i - l];
        }
        return elements;
    }
}
