package intermediate.dsa20_july26;

/**
 * Given a binary string A.
 * It is allowed to do at most one swap between any 0 and 1.
 * Find and return the length of the longest consecutive 1’s that can be achieved.
 */
public class LengthOfLongestConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println("solve(\"1011111101001\") = " + solve("1011111101001"));
        System.out.println("solve(\"11111111\") = " + solve("11111111"));
    }

    public static int solve(String A) {

        int countOf1s = 0;
        int maxCount = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '1') {
                countOf1s++;
            }
            int left1s = 0;
            int right1s = 0;
            if (A.charAt(i) == '0') {
                for (int j = i - 1; j >= 0; j--) {
                    if (A.charAt(j) == '1') {
                        left1s++;
                        continue;
                    }
                    break;
                }
                for (int j = i + 1; j < A.length(); j++) {
                    if (A.charAt(j) == '1') {
                        right1s++;
                        continue;
                    }
                    break;
                }
                if (left1s + right1s > maxCount) {
                    maxCount = left1s + right1s;
                }
            }
        }
        if (countOf1s == A.length()) {
            return countOf1s;
        }
        if (countOf1s > maxCount) {
            maxCount++;
        }
        return maxCount;
    }

}
