package advanced.module5.dsa44_sep22;


public class InsertionSort {

    private void insertionSort(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (ar[j] > ar[j + 1]) {
                    swap(ar, j, j + 1);
                } else {
                    break;
                }
            }
        }
    }

    private void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}
