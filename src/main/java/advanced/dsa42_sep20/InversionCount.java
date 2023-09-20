package advanced.dsa42_sep20;

public class InversionCount {
    static int c = 0;
    private static int inversionCount(int[] ar) {

        c = 0;
        mergeSort(ar, );
        int ans = 0;
        return c;
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

    }
}
