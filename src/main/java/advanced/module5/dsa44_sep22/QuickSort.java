package advanced.module5.dsa44_sep22;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] ar = {
                18, 27, 3, 6, 8, 11, 20, 14, 31, 23
        };
        quickSort(ar, 0, ar.length - 1);
        System.out.println("ar = " + Arrays.toString(ar));
    }

    private static void quickSort(int[] ar, int s, int e) {
        if (s >= e) {
            return;
        }
        int index = getPosition(ar, s, e);
        quickSort(ar, s, index - 1);
        quickSort(ar, index + 1, e);
    }

    private static int getPosition(int[] ar, int s, int e) {
        randomizeToAdjustForExtremeValuesAtPivot(ar, s, e);
        int pivot = ar[s];
        int p1 = s + 1;
        int p2 = e;
        while (p1 <= p2) {
            if (ar[p1] < pivot) {
                p1++;
            } else if (ar[p2] > pivot) {
                p2--;
            } else {
                swap(ar, p1, p2);
                p1++;
                p2--;
            }
        }
        return swap(ar, s, p2);
    }

    private static void randomizeToAdjustForExtremeValuesAtPivot(int[] ar, int s, int e) {
        int index = (int) (Math.random() * (e - s + 1) + s);
        swap(ar, s, index);
    }

    private static int swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;

        return j;
    }
}
