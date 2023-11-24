package advanced.module5.dsa49_oct04;

public class SqrtOfWholeNumberAssignment {
    public static void main(String[] args) {
        int sqrt = new SqrtOfWholeNumberAssignment().sqrt(2147483647);
        System.out.println("sqrt = " + sqrt);
    }

    public int sqrt(int A) {
        if (A == 0) {
            return 0;
        }
        int l = 1;
        int h = A;
        int sqrt = -1;

        while (l <= h) {
            long mid = (int)(((long)l + h)) / 2;
            if (mid * mid <= A) {
                sqrt = (int) mid;
                l = (int)mid + 1;
            } else {
                h = (int)mid - 1;
            }
        }
        return sqrt;
    }
}
