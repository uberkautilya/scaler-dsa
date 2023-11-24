package advanced.module5.dsa56_oct18;

import java.util.HashSet;
import java.util.Set;

public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        int result = isomorphicStrings.solve("cvv", "xyx"); //Expected: 0
        System.out.println("result = " + result);

    }

    public int solve(String A, String B) {
        Set<Character> aSet = new HashSet<>();
        Set<Character> bSet = new HashSet<>();
        for (Character a : A.toCharArray()) {
            aSet.add(a);
        }
        for (Character b : B.toCharArray()) {
            bSet.add(b);
        }
        aSet.removeAll(bSet);
        bSet.removeAll(aSet);
        return aSet.size() == bSet.size() ? 1 : 0;
    }
}
