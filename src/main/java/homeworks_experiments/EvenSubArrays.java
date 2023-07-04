package homeworks_experiments;

public class EvenSubArrays {

    public static void main(String[] args) {
        int[] a = {796, 483, 671, 998, 149, 374, 801, 191, 457, 802, 903, 329, 191, 286, 153, 600, 917, 189, 724, 741, 306, 253, 520, 372};
        System.out.println(solve(a));
    }

    /**
     * Decide whether it is possible to divide the array into one or more sub-arrays of even length
     * such that the first and last element of all sub-arrays will be even.
     * <p>
     * Return "YES" if it is possible; otherwise, return "NO" (without quotes).
     * @param A
     * @return
     */
    public static String solve(int[] A) {
        int len = A.length;
        System.out.println("No. of elements: " + len);
        if (len % 2 != 0 || A[0] % 2 != 0 || A[len - 1] % 2 != 0) {
            return "NO";
        }
        for (int i = 1; i < len - 2; i += 2) {
            if (A[i] % 2 == 0 && A[i + 1] % 2 == 0) {
                return "YES";
            }
        }
        return "NO";
    }
}
