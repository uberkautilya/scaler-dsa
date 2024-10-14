package advanced.module5.dsa56_oct18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    private static final int BIG_PRIME = 1000_000_007;
    private static final int PRIME = 29;

    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        int result = isomorphicStrings.solve("aba", "xxx"); //Expected: 0
        System.out.println("result = " + result);

    }

    //AABCDE ... DDGERW
    public int solve(String A, String B) {
        Map<Character, Integer> aCountMap = new HashMap<>();
        Map<Character, Integer> bCountMap = new HashMap<>();
        int aHash = 0;
        int bHash = 0;
        int f = 1;
        int b = 1;
        for (Character c : A.toCharArray()) {
            int charCount;
            if (!aCountMap.containsKey(c)) {
                aCountMap.put(c, f++);
            }
            charCount = aCountMap.get(c);
            aHash = aHash * PRIME + charCount;
            aHash %= BIG_PRIME;
        }
        for (Character c : B.toCharArray()) {
            int charCount;
            if(!bCountMap.containsKey(c)) {
                bCountMap.put(c, b++);
            }
            charCount = bCountMap.get(c);
            bHash = bHash * PRIME + charCount;
            bHash %= BIG_PRIME;
        }
        if(aHash == bHash) {
            return 1;
        }
        return 0;
    }
}
