package advanced.dsa44_sep22;

public class ReArrangeToCorrectPosition {

    private void reArrange(int[] ar) {
        int p1 = 1;
        int p2 = ar.length - 1;

        while (p1 <= p2) {
            if (ar[p1] <= ar[0]) {
                p1++;
            } else if (ar[p2] > ar[0]) {
                p2--;
            } else {
                swap(ar, p1, p2);
                p1++;
                p2--;
            }
        }
        //At the end p2 is less than p1 - value would be less than ar[0]
        swap(ar, 0, p2);
    }

    private void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}
