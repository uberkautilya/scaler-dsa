package dsa23_july31;

public class SumOfBinaryStrings {
    public static void main(String[] args) {
        SumOfBinaryStrings sumOfBinaryStrings = new SumOfBinaryStrings();
        //Expected: 1001110001111010101001110
        String result = sumOfBinaryStrings.addBinary("1010110111001101101000", "1000011011000000111100110");
        System.out.println("result = " + result);

        result = sumOfBinaryStrings.addBinary("1", "1");
        System.out.println("result = " + result);
    }

    public String addBinary(String A, String B) {
        char[] aChars = A.toCharArray();
        char[] bChars = B.toCharArray();
        int i = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (aChars.length > i || bChars.length > i) {
            int a = 0;
            int b = 0;
            if (aChars.length > i) {
                if (aChars[aChars.length - 1 - i] == '1') {
                    a = 1;
                }
            }
            if (bChars.length > i) {
                if (bChars[bChars.length - 1 - i] == '1') {
                    b = 1;
                }
            }
            if (a + b + carry == 2) {
                sb.append("0");
                carry = 1;
            } else if (a + b + carry == 3) {
                sb.append("1");
                carry = 1;
            } else {
                int val = a + b + carry;
                sb.append(val);
                carry = 0;
            }
            i++;
        }
        if (carry == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
