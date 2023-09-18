package advanced.dsa39_sep13;

public class PalindromeCheckWithRecursion {

    public static void main(String[] args) {
        int result = new PalindromeCheckWithRecursion().solve("malayalam");
        System.out.println("result = " + result);
    }

    public int solve(String A) {
        if (A.length() <= 1) return 1;

        if (A.charAt(0) == A.charAt(A.length() - 1)) {
            return solve(A.substring(1, A.length() - 1));
        }
        return 0;
    }
}
