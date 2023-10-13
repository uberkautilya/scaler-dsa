package advanced.contest_oct13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class HighestFrequencyStringCount {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("aa", "bb", "bb", "aa", "aa"));
        ArrayList<String> B = new ArrayList<>(Arrays.asList("aa", "cc"));
        String solve = new HighestFrequencyStringCount().solve(strList, B);
        System.out.println("solve = " + solve);
    }


    public String solveOptimized(ArrayList<String> A, ArrayList<String> B) {
        HashMap<String, Integer> countMap = new HashMap<>();
        String ans = "";
        int maxCount = 0;
        HashSet<String> banned = new HashSet<>();
        for (String s : B) {
            banned.add(s);
        }

        for (String str : A) {
            //This takes another O(N) nested
            if (banned.contains(str)) {
                continue;
            }
            if (!countMap.containsKey(str)) {
                countMap.put(str, 0);
            }
            int count = countMap.get(str) + 1;
            countMap.put(str, count);
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

    public String solve(ArrayList<String> A, ArrayList<String> B) {
        HashMap<String, Integer> countMap = new HashMap<>();
        String ans = "";
        int maxCount = 0;

        for (String str : A) {
            //This takes another O(N) nested
            if (B.contains(str)) {
                continue;
            }
            if (!countMap.containsKey(str)) {
                countMap.put(str, 0);
            }
            int count = countMap.get(str) + 1;
            countMap.put(str, count);
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
