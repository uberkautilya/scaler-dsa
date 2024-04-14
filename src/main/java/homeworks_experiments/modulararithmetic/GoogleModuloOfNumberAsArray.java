package homeworks_experiments.modulararithmetic;

import java.util.Arrays;

public class GoogleModuloOfNumberAsArray {

    /**
     * Constraints:
     * 1 <= N <= 100_000
     * 0 <= array[i] <= 9
     * 2 <= divisor <= 1000_000_000
     */
    public static void main(String[] args) {

        int[] array = new int[]{
                7, 9, 3
        };
        int divisor = 6;

        long modulo = findModulo(array, divisor);
        System.out.printf("\n%s Modulo %d: %d\n", Arrays.toString(array), divisor, modulo);
    }

    public static long findModulo(int[] array, int divisor) {
        int length = array.length;
        long result = array[length - 1] % divisor;
        long powerOf10PercentDivisor = 1;

        for (int i = length - 2; i >= 0; i--) {
            //10's positive power begins at index 1 only. Hence, loop start at second-last digit
            powerOf10PercentDivisor = (  powerOf10PercentDivisor * (10 % divisor) ) % divisor;

            result += ( (array[i] % divisor) * powerOf10PercentDivisor ) % divisor;
        }
        return (result % divisor);
    }
}
