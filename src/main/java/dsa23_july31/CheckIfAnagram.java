package dsa23_july31;

public class CheckIfAnagram {
    public static void main(String[] args) {
        String stringA = "bgipsvukg";
        String stringB = "ylwfyulte";
        int answer = solve(stringA, stringB);
        System.out.println("answer = " + answer);
    }

    public static int solve(String A, String B) {
        int[] count = new int[26];
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            count[c - 'a'] += 1;
        }
        for (int i = 0; i < B.length(); i++) {
            char c = B.charAt(i);
            count[c - 'a'] -= 1;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return 0;
            }
        }
        return 1;
    }
}
