package advanced.dsa44_sep22;

import java.util.ArrayList;
import java.util.Arrays;

public class WaveArray {
    public static void main(String[] args) {
        WaveArray waveArray = new WaveArray();
        ArrayList<Integer> result = waveArray.wave(new ArrayList(Arrays.asList(5, 1, 3, 2, 4)));
        System.out.println("result = " + result);

    }

    /**
     * Given an array of integers A, sort the array into a wave-like array and return it.
     * In other words, arrange the elements into a sequence such that
     * a1 >= a2 <= a3 >= a4 <= a5.....
     */
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        if (A.size() == 1) return A;
        quickSort(A, 0, A.size() - 1);
        waveIt(A);
        return A;
    }

    private void quickSort(ArrayList<Integer> A, int s, int e) {
        if (s >= e) return;

        int pivot = A.get(s);
        int p1 = s + 1;
        int p2 = e;
        while (p1 <= p2) {
            if (A.get(p1) < pivot) {
                p1++;
            } else if (A.get(p2) > pivot) {
                p2--;
            } else {
                swap(A, p1, p2);
                p1++;
                p2--;
            }
        }
        int index = swap(A, s, p2);
        //Position correct for pivot
        quickSort(A, s, index - 1);
        quickSort(A, index + 1, e);
    }

    private int swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
        return j;
    }

    private void waveIt(ArrayList<Integer> A) {
        for (int i = 1; i < A.size(); i = i + 2) {
            int temp = A.get(i - 1);
            A.set(i - 1, A.get(i));
            A.set(i, temp);
        }
    }

}
