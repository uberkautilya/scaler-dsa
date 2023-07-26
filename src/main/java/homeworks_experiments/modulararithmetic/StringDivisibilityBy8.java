package homeworks_experiments.modulararithmetic;

public class StringDivisibilityBy8 {
    public static void main(String[] args) {
        String number = "87324";
        char[] charArray = number.toCharArray();
        int[] digitArray = new int[charArray.length];
        for (int i = 0; i < digitArray.length; i++) {
            digitArray[i] = (int) charArray[i] - '0';
        }

        int modulo = findModuloBy8(digitArray, 8);
        System.out.println("modulo = " + modulo);
    }

    private static int findModuloBy8(int[] digitArray, int divisor) {

        if (digitArray.length == 1) return digitArray[0] % 8;
        long powerOf10Contribution = 1;
        long result = digitArray[digitArray.length - 1] % divisor;

        for (int i = digitArray.length - 2; i >= 0; i--) {
            int digit = digitArray[i];
            powerOf10Contribution = (powerOf10Contribution * 10 % divisor) % divisor;
            result += (digit % divisor * powerOf10Contribution) % divisor;
        }
        return (int) (result % divisor);
    }
}
