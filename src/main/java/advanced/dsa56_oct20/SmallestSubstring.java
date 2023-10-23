package advanced.dsa56_oct20;

import java.util.HashMap;
import java.util.Objects;

public class SmallestSubstring {
    public static void main(String[] args) {
        Character[] A = new Character[]{'a', 'a', 'c', 'a', 'b', 'x', 'd', 'a', 'c', 'b', 'a', 'p'};
        Character[] B = new Character[]{'a', 'c', 'a', 'd', 'x'};
        int result = new SmallestSubstring().solve(A, B);
        System.out.println("result = " + result);
    }

    private int solve(Character[] A, Character[] B) {
        int i = 0, j = 0, length = A.length;
        int ans = Integer.MAX_VALUE;
        int satisfied = 0;
        HashMap<Character, Integer> patternMap = new HashMap<>(), charMap = new HashMap<>();
        for (Character b : B) {
            //populates patternMap from B
            patternMap.put(b, patternMap.getOrDefault(b, 0) + 1);
        }
        while (j < length) {
            if (!patternMap.containsKey(A[j])) {
                j++;
                continue;
            }
            charMap.put(A[j], charMap.getOrDefault(A[j], 0) + 1);

            if (charMap.get(A[j]) <= patternMap.get(A[j])) {
                //After increment, if count is not in excess
                satisfied++;
            }
            if (satisfied == B.length) {
                while (!patternMap.containsKey(A[i]) || charMap.get(A[i]) > patternMap.get(A[i])) {
                    if (patternMap.containsKey(A[i])) {
                        charMap.put(A[i], charMap.get(A[i]) - 1);
                    }
                    i++;
                }
                int len = j - i + 1;
                ans = min(len, ans);
                if (patternMap.containsKey(A[i]) && Objects.equals(charMap.get(A[i]), patternMap.get(A[i]))) {
                    charMap.put(A[i], charMap.get(A[i]) - 1);
                    i++;
                    satisfied--;
                }
            }
            j++;
        }
        return ans;
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }
}
