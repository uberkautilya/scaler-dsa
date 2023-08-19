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


/*
foo(3, 5) -> bar(3, foo(3, 4)) -> bar(3, bar(3, foo(3,3)) -> bar(3, }3, foo(3, 2) -> bar3*4 foo(3,1) -> bar3*5 foo(3, 0) -> bar3*5 1
3*3*3*3*3 = 81*3 = 243
 */