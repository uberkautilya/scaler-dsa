package homeworks_experiments;

public class BitwiseOperations {
    public static void main(String[] args) {
        System.out.println(12 & 1);

        int a = 12;
        System.out.println("(a << 2) = " + (a << 2));
        System.out.println(a);
        System.out.println("solve(10) = " + solve(10));
    }

    public static int solve(int A) {
        int helpCount = 0;

        while (A > 0) {
            if (A % 2 == 0) {
                helpCount++;
            }
            A = A/2;
        }
        return helpCount;
    }
}


/**
 * public class Solution {
 * public int solve(int A, int B) {
 * //Set the Ath and Bth bit in 0000000000...
 * int num = 0;
 * num = (num | 1<<A);
 * num = (num | 1<<B);
 * <p>
 * int numDecimal = 0;
 * int exp = 0;
 * while(num > 0){
 * <p>
 * int indexDigit = num % 10;
 * //indexDigit<<exp = indexDigit * 2^exp
 * int contributionFromIndex = indexDigit<<exp;
 * numDecimal += contributionFromIndex;
 * exp++;
 * num = num/10;
 * <p>
 * }
 * return numDecimal;
 * }
 * }
 */