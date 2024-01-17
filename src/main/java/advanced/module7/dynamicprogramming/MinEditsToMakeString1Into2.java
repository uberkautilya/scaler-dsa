package advanced.module7.dynamicprogramming;

import java.util.Arrays;

public class MinEditsToMakeString1Into2 {
    public static void main(String[] args) {
        String a = "aba";
        String b = "abca";
        int minEdits = new MinEditsToMakeString1Into2().minDistance(a, b);
        System.out.println("minEdits = " + minEdits);
    }

    public int minDistance(String A, String B) {
        int[][] dp = new int[A.length()][B.length()];
        for (int[] array : dp) {
            Arrays.fill(array, -1);
        }
        return findMin(A, B, A.length() - 1, B.length() - 1, dp);
    }

    int findMin(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0) { //(0, j) has j + 1 characters, to be inserted
            return j + 1;
        }
        if (j < 0) { //(0, i) has i + 1 characters, to be deleted
            return i + 1;
        }
        if (dp[i][j] == -1) {
            if (s1.charAt(i) == s2.charAt(j)) {
                dp[i][j] = findMin(s1, s2, i - 1, j - 1, dp);
            } else {
                int delCount = findMin(s1, s2, i - 1, j, dp);
                int replaceCount = findMin(s1, s2, i - 1, j - 1, dp);
                int insertCount = findMin(s1, s2, i, j - 1, dp);
                dp[i][j] = 1 + min(delCount, replaceCount, insertCount);
            }
        }
        return dp[i][j];
    }

    int min(int a, int b, int c) {
        if (a <= b && a <= c) return a;
        return b <= c ? b : c;
    }
}
