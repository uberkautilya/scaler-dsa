package advanced.module5.dsa49_oct04;

public class SqrtPositiveNumber {
    public static void main(String[] args) {
        int sqrt = new SqrtPositiveNumber().sqrt(26);
        System.out.println("sqrt = " + sqrt);

        int sqrtWithBinarySort = new SqrtPositiveNumber().sqrtBinarySearch(3);
        System.out.println("sqrtWithBinarySort = " + sqrtWithBinarySort);
    }

    private int sqrt(Integer number) {
        int ans = -1;
        for (int i = 1; i * i <= number; i++) {
            if (i * i <= number) {
                ans = i;
            }
        }
        return ans;
    }

    /**
     * This is better wiht T.C. of O(logN), agains sqrt(N) of the previous approach
     *
     * @param number
     * @return
     */
    private int sqrtBinarySearch(Integer number) {
        int ans = -1;
        int l = 1;
        int h = number;
        while (l <= h) {
            int m = (l + h) / 2;
            if (m * m == number) {
                return m;
            }
            if (m * m <= number) {
                //Discard the left part
                ans = m;
                l = m + 1;
            } else {
                //Discard the right part
                h = m - 1;
            }
        }
        return ans;
    }
}
