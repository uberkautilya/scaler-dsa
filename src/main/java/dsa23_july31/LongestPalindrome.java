package dsa23_july31;

public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome palindrome = new LongestPalindrome();
        palindrome.longestPalindrome("notthinmalayalamnotthis");
    }

    public String longestPalindrome(String A) {
        String maxPalindrome = "";

        //Assuming the palindrome has odd length
        for (int i = 0; i < A.length(); i++) {
            int left = i;
            int right = i;
            String palindrome = expand(A, left, right);
            if (palindrome.length() > maxPalindrome.length()) {
                maxPalindrome = palindrome;
            }
        }
        //Assuming the palindrome has even length
        for (int i = 0; i < A.length() - 1; i++) {
            int left = i;
            int right = i + 1;
            String palindrome = expand(A, left, right);
            if (palindrome.length() > maxPalindrome.length()) {
                maxPalindrome = palindrome;
            }
        }
        System.out.println("maxPalindrome = " + maxPalindrome);
        return maxPalindrome;
    }

    private String expand(String string, int left, int right) {
        while (left >= 0 && right < string.length() &&
                string.charAt(left) == string.charAt(right)) {
            left--;
            right++;
        }
        left++;
        //right is exclusive in substring function
        return string.substring(left, right);
    }
}
