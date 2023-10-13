package advanced.contest_oct13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HighestFrequencyStringCount {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("aa", "bb", "bb", "aa", "aa"));
        ArrayList<String> B = new ArrayList<>(Arrays.asList("aa", "cc"));
        String solve = new HighestFrequencyStringCount().solve(strList, B);
        System.out.println("solve = " + solve);
    }


    public String solve(ArrayList<String> A, ArrayList<String> B) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        String ans = "";
        int maxCount = 0;

        for (String str : A) {
            if (B.contains(str)) {
                continue;
            }
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, 0);
            }
            int count = hashMap.get(str) + 1;
            hashMap.put(str, count);
            if (count > maxCount) {
                maxCount = count;
                ans = str;
            } else if (count == maxCount) {
                if (ans.compareTo(str) > 0) {
                    ans = str;
                }
            }
        }
        return ans;
    }
}
