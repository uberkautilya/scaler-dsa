package advanced.module4.dsa32_aug28;

public class WaterTrapped {
    public static void main(String[] args) {
        WaterTrapped waterTrapped = new WaterTrapped();
        //Expected answer: 6
        int result = waterTrapped.solve(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println("result = " + result);
    }

    public int solve(int[] A) {
        int[] maxOnRight = new int[A.length];
        int[] maxOnLeft = new int[A.length];
        maxOnLeft[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            maxOnLeft[i] = max(maxOnLeft[i - 1], A[i - 1]);
        }
        maxOnRight[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            maxOnRight[i] = max(maxOnRight[i + 1], A[i + 1]);
        }
        int volumeAccumulated = 0;
        for (int i = 0; i < A.length; i++) {
            int val = min(maxOnLeft[i], maxOnRight[i]);
            if(val > A[i]) volumeAccumulated += val - A[i];
        }
        return volumeAccumulated;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
    private int min(int a, int b) {
        return a < b ? a : b;
    }
}
