package advanced.dsa32_aug28;

import java.util.Arrays;

public class AddOneToIntAsArray {
    public static void main(String[] args) {
        AddOneToIntAsArray addOneToIntAsArray = new AddOneToIntAsArray();
        int[] result = addOneToIntAsArray.plusOne(new int[]{0, 0, 4, 4, 6, 0, 9, 6, 5, 1});
        System.out.println("result = " + Arrays.toString(result));

    }

    public int[] plusOne(int[] A) {
        int[] digits = new int[A.length + 1];

        int carry = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int digit = A[i] + carry;
            if (i == A.length - 1) {
                digit = A[i] + 1;
            }
            if (digit == 10) {
                digit = 0;
                carry = 1;
            } else {
                carry = 0;
            }
            digits[i + 1] = digit;
        }
        if (carry == 1) {
            digits[0] = carry;
        }
        int zeroCount = 0;
        for (int digit : digits) {
            if (digit != 0) break;
            zeroCount++;
        }
        int[] result = new int[digits.length - zeroCount];
        for (int i = zeroCount; i < digits.length; i++) {
            result[i - zeroCount] = digits[i];
        }
        return result;
    }
}
